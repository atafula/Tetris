package es.unileon.prg1.tetris;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase que representa la inicialización del juego Tetris.
 * Proporciona un método para iniciar y ejecutar el juego en la consola.
 * @author Daniel Díez Prieto
 */

public class TetrisTextUI {

    /**
     * Objeto logger para realizar registros personalizados.
     */
    private static final Logger logger = LogManager.getLogger(Tetris.class);

    /**
     * Objeto duallogger para realizar registros personalizados. Este imprime en consola y guarda en un archivo la información especificada.
     */
    private static final Logger duallogger = LogManager.getLogger("TetrisTextUI");

    /**
     * Se crea una variable de tipo tetris que se usará al iniciar el programa.
     */
    private Tetris tetris;


    /**
     * Constructor de TetrisTextUI.
     * @param tetris Contiene la información del objeto de la clase Tetris que se utilizará para iniciar el "programa".
     */

    public TetrisTextUI(Tetris tetris) {
        this.tetris = tetris;   // Equivale el valor de la variable tetris de la clase, al que se recibe como parámetro.
    }

    /**
     * Método que inicia y ejecuta el juego en la consola.
     * Contiene la lógica principal del juego (un bucle que muestra el tetris repetitivamente y lo actualiza dependiendo del movimiento realizado por el usuario), permitiendo al usuario alterar el comportamiento de los bloques, pudiendo
     * realizar movimientos de izquierda a derecha (con las teclas A y D respectivamente), rotaciones a ambos lados por igual
     * y la posibilidad de "tirar" el bloque dentro del tablero con la tecla S.
     * De igual forma, al terminar el juego (voluntariamente o no) se muestra la puntuación final.
     * @throws TetrisException En el caso de que ocurra una excepción, como si el bloque intenta moverse fuera de los límites del tablero.
     */

    public void init() {
        boolean iterador = true;    // Variable booleana que permite o no seguir iterando el bucle de inicialización del juego.
        String palabratetris = "TETRIS"; // Cadena de texto que contiene la palabra "TETRIS" para posteriormente decorarla y mostrarla durante la ejecución, pues es el título.
        StringBuilder sb = new StringBuilder(); // StringBuilder para mostrar el título "TETRIS" coloreado.

        sb.append("\n");    // Salto de línea después antes de mostrar el contenido del juego.

        // Palabra TETRIS "pintada". Alternativa para pintar de negro las 3 primeras letras de la palabra.

        String[] colors = {"\u001B[43m", "\u001B[42m", "\u001B[46m", "\u001B[44m", "\u001B[41m", "\u001B[45m"}; // Códigos de colores para "pintar" la palabra "TETRIS". Muestra los colores amarillo, verde, cyan, azul, rojo y magenta respectivamente
        
        for (int i = 0; i < palabratetris.length(); i++) {  // Itera sobre cada posición de la palabra "TETRIS".
            String letterColor = colors[i]; // Equibale el valor de la variable letterColor a su respectivo por posición del array colors.

            if (i < 3) {    // Las 3 primeras letras son de color negro y el resto blancas.
                sb.append("\u001B[30m");    // Color negro para la letra.

                sb.append(letterColor); // Otorga el color respectivo en base a su posición.

                sb.append(" "); // Cada letra tiene un espacio a la izquierda y otro a la derecha.

                sb.append(palabratetris.charAt(i)); // Escribe las 3 primeras letras de la palabra "TETRIS" en base a la posición del iterador.
                sb.append(" ");

            } else {
                sb.append("\u001B[0m");
                sb.append(letterColor); // Otorga el color respectivo en base a su posición.

                sb.append(" ");

                sb.append(palabratetris.charAt(i)); // Escribe las 3 últimas letras de la palabra "TETRIS" en base a la posición del iterador.
                
                sb.append(" ");
            }
        }

        sb.append("\u001B[0m");

        sb.append("\n\n");  // Doble salto de línea para diferenciar bien lo que es el título y el juego en sí.
        
        do {    // Inicio del iterador que escribirá en consola el juego.
            try {

                System.out.println(sb.toString());  // Muestra el título ya "pintado".
                
                System.out.println(this.tetris.toString()); // Muestra en consola el tetris "pasado" a cadena de texto.

                System.out.println("'W' -> spin left 'E' -> spin right 'A' -> move left 'S' -> drop 'D' -> move right \"Salir\" to leave tetris");  // Muestra los posibles movimientos que puede realizar el usuario que ejecute el juego

                String userInput = Keyboard.readString().toLowerCase();

                logger.info("Comando escrito: "+userInput);

                switch (userInput) {    // Se crea un switch para realizar funciones en base al "input" del usuario.
                    case "w":   // Si escribe la "w", rotará el bloque a la izquierda.
                        this.tetris.spinLeft();
                        break;
                    case "e":   // Si escribe la "e", rotará el bloque a la derecha.
                        this.tetris.spinRight();
                        break;
                    case "a":   // Si escribe la "a", moverá el bloque a la izquierda cuando sea posible, gestionado esto dentro del propio método. En caso negativo, lanzará la excepción de este mismo iterador
                        this.tetris.moveLeft();
                        break;
                    case "d":   // Si escribe la "d", moverá el bloque a la derecha cuando sea posible, con la misma consecuencia que el movimiento a la izquierda
                        this.tetris.moveRigth();
                        break;
                    case "s":   // "Tira" el bloque dentro del tablero.
                        if (!this.tetris.drop()) {   // En caso de que no se pueda "tirar" un bloque, el juego se para, ya que la variable booleana que usa el iterador se negará y no podrá seguir imprimiendo. Muestra, por igual, un mensaje de despedida y la puntuación con la que se finalizó el juego
                            System.out.println("BYE!\n\n ¡Tu puntuación final fue de " + this.tetris.getPoints() + " puntos!");
                            logger.info("Partida finalizada con " + this.tetris.getPoints() + " puntos.");
                            iterador = false;
                        }
                        break;
                    case "salir":   // Si se escribe "salir", el juego se cerrará con éxito.
                        duallogger.info("Cerrando juego...");
                        iterador = false;
                        break;
                    default:    // Cualquier input no declarado anteriormente se informará como "no válido".
                        duallogger.error("Comando inválido.");
                }

            } catch (TetrisException e) {   // Cualquier excepción devuelta por el try se mostrará a continuación.
                duallogger.info(e.getMessage());
            }

        } while (iterador); // Bucle que "imprime" el juego mientras que la variable iterador sea positiva.
    }

}
