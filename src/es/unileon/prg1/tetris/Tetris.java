package es.unileon.prg1.tetris;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.unileon.prg1.tetris.strategy.ColorStrategySingleton;

/**
 * Clase que representa el juego Tetris
 * @author Daniel Díez Prieto
 */

public class Tetris {

    /**
     * Objeto logger para realizar registros personalizados.
     */
    private static final Logger logger = LogManager.getLogger(Tetris.class);

    /**
     * Bloque actual del juego
     */
    private Block block;    

    /**
     * Tablero del juego
     */
    private Board board;    

    /**
     * Número de columnas en el tablero
     */
    private int columns;    


    /**
     * Constructor de la clase Tetris. Instancia el juego con o sin color, crea un tablero y genera un bloque aleatorio.
     * @param rows Número de filas del tablero.
     * @param columns Número de columnas del tablero.
     * @param color Si los bloques van a ser de colores o mostrarán las piezas con sus letras correspondientes (solo puede ser "color" o "nocolor").
     * @throws TetrisException Si hubiera un error con las dimensión especificadas.
     */

    public Tetris(int rows, int columns, String color) throws TetrisException {
        if (!(rows > 4 && rows < 21 && columns > 5 && columns < 21)) {  // Condición que lanza excepción si no se cumple con las dimensiones del tablero especificadas.
            throw new TetrisException("Error en las dimensiones especificadas.");
        }

        ColorStrategySingleton.getInstance(color);  // Devuelve la instancia en base a si se quiso jugar con o sin color.

        this.board = new Board(rows, columns);  // Crea un nuevo tablero.
        this.columns = columns; // Equivale el valor de las clase de la variable columns al columns, incluido como argumento.

        this.block = generador();
    }

    /**
     * Establece el bloque actual en el juego.
     * @param block Pieza a establecer.
     */

    public void set(Block block){
        this.block = block; // Equivale el bloque actual utilizado al que se recibe como parámetro.
    }


    /**
     * Obtiene la puntuación actual del juego.
     * @return Devuelve el valor que devuelve el método que devuelve la puntuación de la clase Board, pues dicha se gestiona en esta última clase.
     */

    public int getPoints() {
        return this.board.getPoints();  // Devuelve el valor que devuelve el método getPoints de la clase Board.
    }


    /**
     * Gira el bloque actual hacia la derecha. Llama al método de rotación de la clase Block, pues es el que se rota realmente.
     * @see Block
     */

    public void spinRight() {

        this.block.spinRight(); // Gira el bloque a la derecha utilizando dicho método ubicado en su clase.

        logger.info("Rotando a la derecha al bloque.");

        while (this.block.getCols() + this.block.columns() > this.columns) {
            logger.error("Bloque fuera de los límites, moviendo a la izquierda una posición.");
            this.block.moveLeft();
        }

    }


    /**
     * Gira el bloque actual hacia la izquierda. Llama al método de rotación del bloque, pues es esto quien realmente rota.
     * @see Block
     */

    public void spinLeft() {
        logger.info("Rotando a la izquierda al bloque.");
        this.block.spinLeft(); // Gira el bloque a la izquierda utilizando dicho método ubicado en su clase.
    }
    

    /**
     * Mueve el bloque a la izquierda solo en caso de que este no se ubique en la columna 0.
     * @see Block
     * @throws TetrisException Si se intenta salir del límite izquierdo, muestra una alerta informativa.
     */

    public void moveLeft() throws TetrisException {
        if (this.block.columns() != 0) {    // Condiciona cuando la columna no sea 0.
            logger.info("Moviendo una posición a la izquierda al bloque.");
            this.block.moveLeft();   // Movimiento a la izquierda.
        } else {    // En caso de que no se cumpla la condición, lanza la excepción que se mostrará en el catch de TetrisTextUI.
            throw new TetrisException("Error al mover a la izquierda, no te puedes salir del límite izquierdo.");  // Mensaje de la excepción.
        }
    }


    /**
     * Mueve la pieza a la derecha en caso de que la columna en la que se ubique el bloque sea menor que la longitud del tablero menos la cantidad de columnas del bloque actual.
     * @see Block
     * @throws TetrisException Si se intenta salir del límite derecho, muestra una alerta informativa.
     */

    public void moveRigth() throws TetrisException {
        if (this.block.columns() < this.columns - this.block.getCols()) {   // Condición en la que se pueda efectuar el movimiento a la derecha.
            logger.info("Moviendo una posición a la derecha al bloque.");
            this.block.moveRight(); // Movimiento a la derecha.
        } else {    // En caso de que no se cumpla la condición, lanza la excepción que se mostrará en el catch de TetrisTextUI.
            throw new TetrisException("Error al mover a la derecha, no te puedes salir del límite derecho.");    // Mensaje de la excepción.
        }
    }


    /**
     * Se comprueba la posibilidad y se "tira" la pieza actual en el tablero. Se genera un nuevo bloque tras realizar dicha acción.
     * @see Board
     * @return "true" si la pieza se puede tirar, y "false" en caso negativo.
     */

    public boolean drop() {
        boolean drop = false;   // Inicia la variable booleana como negativa.

        if (this.board.candrop(this.block)) {   // Checkea si se puede dropear.
            logger.info("Dropeando bloque en la columna "+this.block.columns());
            this.board.updateBoard(this.block); // Se tira el bloque.
            drop = true;    // Cambia el valor de la variable booleana a positiva.
            this.block = generador();
        }

        return drop;    // Devuelve el valor de la variable booleana.
    }


    /**
     * Crea un bloque específico según el número (del 1 al 7) dado.
     * @param piece Número que se usará en un switch para seleccionar el tipo de bloque que se quire crear.
     * @return Devuelve el bloque creado.
     */

    public Block create(int piece) {
        Block bloqueCreate = null;  // Se inicializa un bloque.
        switch (piece) {    // El tipo de bloque equivaldrá al valor que se reciba en el parámetro.
            case 1:
                bloqueCreate = new Block();
                logger.info("[BLOQUE] Bloque O creado");
                break;
            case 2:
                bloqueCreate = new BlockI();
                logger.info("[BLOQUE] Bloque I creado");
                break;
            case 3:
                bloqueCreate = new BlockJ();
                logger.info("[BLOQUE] Bloque J creado");
                break;
            case 4:
                bloqueCreate = new BlockL();
                logger.info("[BLOQUE] Bloque L creado");
                break;
            case 5:
                bloqueCreate = new BlockT();
                logger.info("[BLOQUE] Bloque T creado");
                break;
            case 6:
                bloqueCreate = new BlockS();
                logger.info("[BLOQUE] Bloque S creado");
                break;
            case 7:
                bloqueCreate = new BlockZ();
                logger.info("[BLOQUE] Bloque Z creado");
                break;
            default:
                bloqueCreate = new Block();
                logger.info("[BLOQUE] Bloque O creado");
                break;
        }

        return bloqueCreate;    // Se devuelve el bloque con su tipo correspondiente.
    }


    /**
     * Genera un nuevo bloque aleatorio creando un número aleatorio y utilizando el método create para obtener el bloque "requerido".
     * @return Devuelve el nuevo bloque correspondiente utilizando el método create, pues se le otorga un valor pseudo-aleatorio entre el 1 y el 7.
     */

    private Block generador() { 
        Random random = new Random();   // Creación del objeto random usando el constructor de la clase Random.
        random.setSeed(System.currentTimeMillis()); // Genera una semilla "pseudo-aleatoria" en base al tiempo actual.

        int bloque = random.nextInt(7); // Otorga a la variable "bloque" el valor del 1 al 7 truncado del valor de la semilla generada en random.

        return create(bloque);  // Devuelve el bloque correspondiente del método create usando como base el valor del número aleatorio.
    }

    /**
     * Representación en cadena de texto del juego Tetris. Incluye el tablero y el bloque generado.
     * @return Cadena que representa el estado actual del juego (pues se muestra el bloque y el tablero ya definidos).
     */

    public String toString() {
        StringBuilder sb = new StringBuilder(); // Creación de un StringBuilder al que se le va a hacer append con los diferentes componentes del juego.

        sb.append(this.block.toString());   // Pasa a cadena de texto el bloque.
        sb.append(this.board.toString());   // Pasa a cadena de texto el tablero.
        return sb.toString();   // Devuelve en cadena de texto el StringBuilder anteriormente creado.

    }
}