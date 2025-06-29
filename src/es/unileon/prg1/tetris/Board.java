package es.unileon.prg1.tetris;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase que representa el tablero del juego.
 * @author Óscar González Juan
 */

public class Board {

    /**
     * Objeto que registra los logs que se implementen a posteriori.
     */
    private static final Logger logger = LogManager.getLogger(Board.class);

    /**
     * Se crea un array bidimensional de la clase Piece llamado board (este es el tablero).
     */
    private Piece[][] board; 

    /**
     * Se crea la variable que define los puntos que consigue el jugador por partida. Se suman 10 por cada línea completada.
     */
    private int points; 


    /**
     * Constructor del tablero. Crea una tablero de piezas vacías con las dimensiones especificadas en los parámetros.
     * @param width Cantidad de filas.
     * @param height Cantidad de columnas.
     */

    public Board(int width, int height) {
        this.board = new Piece[width][height]; // Inicialización del array board con las filas y columnas requeridas (ubicadas como argumentos en el constructor, width y height)

        for (int i = 0; i < this.board.length; i++) { // Lectura de filas del array.
            for (int j = 0; j < this.board[0].length; j++) { // Lectura de columnas por cada línea.
                this.board[i][j] = new Piece(); // Se crea una pieza vacía (constituida por 2 espacios) en cada posición del array.
            }
        }

        this.points = 0;  // Aquí se inicializa la cantidad de puntos a 0.
    }


    /**
     * Método que devuelve la puntuación de la partida actual.
     * @return Devuelve la puntuación numérica de la partida actual.
     */

    public int getPoints() {
        return this.points; 
    }


    /**
     * Método que devuelve las filas del tablero.
     * @return Filas del tablero.
     */

     public int getRows() {
        return this.board.length;
    }


    /**
     * Método que devuelve las columnas del tablero.
     * @return Columnas del tablero.
     */

    public int getColumns() {
        return this.board[0].length;
    }

    
    /**
     * Método que actualiza el tablero cuando se hace drop de un bloque. Calcula la altura máxima a la que se puede tirar un bloque sobre un "techo" de piezas ya existentes en el tablero (iterando sobre cada fila posible en la que no colisiones con posiciones no vacías del tablero), 
     * e imprime el bloque dentro del tablero de abajo para arriba, para evitar que se imprima al revés. De igual forma, se itera sobre cada fila del tablero en busca de filas completas. En caso afirmativo, se elimina, sumando 10 puntos adicionales al jugador y bajando todo el contenido
     * superior a la fila eliminada una unidad.
     * @param block Bloque que se insertará en el tablero.
     */

    public void updateBoard(Block block) {
        int blockColumn = block.columns();  // Columna en la que se encuentra el bloque actual.
        int blockRows = block.getRows(); // Cantidad de filas del bloque actual.
        int blockColumns = block.getCols(); // Cantidad de columnas del bloque actual.
        Piece pblock = block.getPiece();    // La pieza del bloque actual. Dicha puede ser una O, una T, Z... dependiendo de la letra que use cada bloque que se cree.
        int altura = 0; // Altura máxima que puede alcanzar un bloque al hacerle drop en la tabla. Se inicializa en 0.

        // Cálculo de la variable altura.
        boolean isValidRow = true;  // Se inicializa una variable booleana cuyo valor volverá a ser verdadero por cada iteración del bucle anterior.

        for (int i = 0; i < this.board.length; i++) {    // Lectura de las columnas del tablero.

            for (int j = 0; j < blockRows && isValidRow; j++) { // Se hace una doble comprobación de que j es menor que las filas del bloque (se itera en base a las filas del bloque) y que isValidRow es verdadero.
                for (int k = 0; k < blockColumns; k++) {    // Iteración sobre las columnas del bloque.
                    int rowToCheck = i + j; // Representa la fila en el tablero que se está verificando.
                    int colToCheck = blockColumn + k;   // Representa la columna en el tablero que se está verificando.
        
                    // Se verifica si la posición calculada está dentro de los límites del tablero.
                    if (rowToCheck >= 0 && rowToCheck < this.board.length && colToCheck >= 0 && colToCheck < this.board[0].length) {
        
                        // Se verifica si la posición en el tablero está vacia utilizando el método isEmpty() de la clase Piece. De igual forma, se comprueba que en dicha posición, el valor de la pieza del bloque es 1
                        if (!this.board[rowToCheck][colToCheck].isEmpty() && block.get(j, k) == 1) {
                            isValidRow = false;
                        }
                    } else {
                        isValidRow = false;
                    }
                }
            }
        
            if (isValidRow) {   // Si isValidRow es verdadero, la altura se establece como la fila actual más la cantidad de filas del bloque.
                altura = i + blockRows;
            }
        }

        // Coloca al revés el bloque en el tablero. Es decir, esta parte imprime el bloque, leyendo las filas del bloque al revés (ya que se imprime de abajo para arriba). También lo imprime en
        // el tablero leyéndolo de abajo para arriba.
        for (int i = 0; i < blockRows; i++) {
            for (int j = 0; j < blockColumns; j++) {
                if (block.get(i, j) == 1) {
                    this.board[altura - blockRows + i][blockColumn + j] = pblock;
                }
            }
        }

        // Checkea y limpia las filas llenas de 1 en 1.
        for (int row = this.board.length - 1; row >= 0; row--) {
            boolean isRowFull = true;
    
            // Verifica si la línea actual está llena.
            for (int col = 0; col < this.board[0].length; col++) {
                if (this.board[row][col].isEmpty()) {
                    isRowFull = false;
                }
            }

            // Desplaza las filas hacia abajo en caso de ubicar una línea llena.
            if (isRowFull) {

                logger.info("Fila "+(this.getRows() - row)+" llena. Bajando el contenido de encima...");

                for (int i = row; i > 0; i--) {
                    for (int j = 0; j < this.board[0].length; j++) {
                        this.board[i][j] = this.board[i - 1][j];
                    }
                }

                // Rellena la primera fila con piezas vacías.
                for (int j = 0; j < this.board[0].length; j++) {
                    this.board[0][j] = new Piece();
                }

                // Aumenta la puntuación en 10 puntos y ajusta el índice de fila.
                this.points += 10;
                row++; 
            }
        }
    }


    /**
     * Método de tipo booleano que "checkea" si se puede dropear o no una pieza.
     * @param block Se manda como argumento el bloque actual que se intenta dropear.
     * @return "True" en caso de que sí se pueda dropear el bloque, "False" en caso contrario.
     */

    public boolean candrop(Block block) {
        int blockColumn = block.columns();  // Columna en la que se encuentra el bloque actual.
        int blockRows = block.getRows(); // Cantidad de filas del bloque actual.
        int blockColumns = block.getCols(); // Cantidad de columnas del bloque actual.
        boolean resultado = false;
    
        // Cálculo de la variable altura.
         boolean isValidRow = true;  // Se inicializa una variable booleana cuyo valor volverá a ser verdadero por cada iteración del bucle anterior.

        for (int i = 0; i < this.board.length; i++) {    // Lectura de las columnas del tablero

            for (int j = 0; j < blockRows && isValidRow; j++) { // Se hace una doble comprobación de que j es menor que las filas del bloque (se itera en base a las filas del bloque) y que isValidRow es verdadero.
                for (int k = 0; k < blockColumns; k++) {    // Iteración sobre las columnas del bloque.
                    int rowToCheck = i + j; // Representa la fila en el tablero que se está verificando.
                    int colToCheck = blockColumn + k;   // Representa la columna en el tablero que se está verificando.
        
                    // Se verifica si la posición calculada está dentro de los límites del tablero.
                    if (rowToCheck >= 0 && rowToCheck < this.board.length && colToCheck >= 0 && colToCheck < this.board[0].length) {
        
                        // Se verifica si la posición en el tablero está vacia utilizando el método isEmpty() de la clase Piece. De igual forma, se comprueba que en dicha posición, el valor de la pieza del bloque es 1
                        if (!this.board[rowToCheck][colToCheck].isEmpty() && block.get(j, k) == 1) {
                            isValidRow = false;
                        }
                    } else {
                        isValidRow = false;
                    }
                }
            }
        
            if (isValidRow) {   // Si isValidRow es verdadero, la altura se establece como la fila actual más la cantidad de filas del bloque.
                resultado = true;
            }
        }
    
        return resultado;
    }

    
    /**
     * Método que devuelve en cadena de texto el tablero.
     * @return Devuelve el tablero en formato String.
     */

    public String toString() {
        StringBuilder sb = new StringBuilder(); // Inicialización de una variable StringBuilder, pues será necesario agregarle caracteres especiales por cada fila del tablero.
        sb.append("\n\n");  // Se añaden dos saltos de línea antes de empezar a imprimir el tablero.

        // Representación del tablero.
        for (int row = 0; row < this.board.length; row++) { // Lectura de las filas del mismo.
            sb.append("\u2502");    // Antes de cada fila se añade el caracter "│". 
            for (int col = 0; col < this.board[0].length; col++) {  // Lectura de las columnas del tablero.
                sb.append(this.board[row][col].toString());
            }
            sb.append("\u2502\n");  // Al final de cada línea, se añade el caracter "│".
        }

        // Representación del borde inferior del tablero
        sb.append("\u2514");    // Se añade el símbolo "└" al principio del borde inferior.
        for (int i = 0; i < this.board[0].length * 2; i++) { // Por toda la longitud del tablero, en el borde inferior, se imprimirá el caracter "─".
            sb.append("\u2500");
        }
        sb.append("\u2518\n");  // Se finaliza el diseño del tablero con el caracter "┘".

        sb.append("POINTS: ").append(this.points);  // Representación de los puntos.

        return sb.toString();
    }

}
