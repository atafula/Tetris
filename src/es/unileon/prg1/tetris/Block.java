package es.unileon.prg1.tetris;

/**
 * Clase que define cada bloque del juego.
 * @author Diego Ferreiro Alonso
 */

public class Block {

    /**
     * Cada bloque es realmente una "instancia" de ArrayMxN.
     */
    protected ArrayMxN bloque;

    /**
     * Pieza asociada al bloque.
     */
    protected Piece piece;  

    /**
     * Color de la pieza del bloque.
     */
    protected Color color;  

    /**
     * Columna en la que se ubica el bloque actualmente.
     */
    private int col;    


    /**
     * Constructor por defecto de Block que crea un bloque cuadrado 2x2 de color amarillo (siempre se inicia en la columna 0, a la izquierda del tablero).
     */

    public Block() {
        this.bloque = new ArrayMxN(2, 2); // Crea una instancia de la clase ArrayMxN con dimensiones 2x2.
        this.bloque.set(0,0,1); // Se establece el valor 1 en la posición (0,0).
        this.bloque.set(0,1,1); // Se establece el valor 1 en la posición (0,1).
        this.bloque.set(1,0,1); // Se establece el valor 1 en la posición (1,0).
        this.bloque.set(1,1,1); // Se establece el valor 1 en la posición (1,1).

        this.piece = new Piece(Color.YELLOW, "O"); // Se crea una instancia de la clase Piece .

        this.col = 0; // Inicializa la variable en la que se instancia la columna en la que empieza un bloque con el valor 0.
    }

    /**
     * Obtiene el valor (1 o 0) de una posición concreta del bloque.
     * @param a Fila especificada.
     * @param b Columna especificada.
     * @return Valor de la posición especificada del bloque (puede ser un 1 o un 0).
     */

    public int get(int a, int b) {
        return this.bloque.get(a,b);
    }


    /**
     * Obtiene la cantidad de filas del bloque.
     * @return Número de filas.
     */

    public int getRows() {
        return this.bloque.rows();
    }


    /**
     * Obtiene la cantidad de columnas del bloque.
     * @return Número de columnas.
     */

    public int getCols() {
        return this.bloque.columns();
    }


    /**
     * Obtiene el color de la pieza del bloque.
     * @return Color de la pieza del bloque.
     */
    
    public Color getColor() {
        return this.piece.getColor();
    }


    /**
     * Obtiene la pieza del bloque.
     * @return Pieza asociada al bloque.
     */

    public Piece getPiece() {
        return this.piece;
    }


    /**
     * Representación en cadena de texto del bloque.
     * @return Cadena de texto que representa el bloque.
     */

    public String toString() {
        StringBuilder sb = new StringBuilder(); // Se crea un StringBuilder para poder definir fácilmente cada línea en cadena de texto del bloque
        
        for (int i = 0; i < bloque.rows(); i++) {
            // Agrega espacios a la izquierda según la columna
            sb.append(" ");
            for (int x = 0; x < col * 2; x++) {
                sb.append(" ");
            }
    
            for (int j = 0; j < bloque.columns(); j++) {
                if (bloque.get(i, j) == 1) {
                    sb.append(piece.toString());
                } else {
                    sb.append(new Piece()); // Si el valor es 0 en cierta posición, se usará una pieza vacía
                }
            }
    
            if (i < bloque.rows() - 1) {
                sb.append("\n");    // Salto de línea en cada línea menos la última
            }
        }
    
        return sb.toString();
    }

    
    /**
     * Mueve el bloque hacia la izquierda en el tablero.
     * @return Resta una unidad a la columna en la que se encuentre el bloque.
     */

   public int moveLeft() {
        return col--;
   }


    /**
     * Mueve el bloque hacia la derecha en el tablero.
     * @return Suma una unidad a la columna en la que se encuentre el bloque.
     */

    public int moveRight() { //Mueve el bloque a la derecha
        return col++;
    }


    /**
     * Gira el bloque a la derecha y devuelve su formato en cadena de texto.
     * @return Representación en cadena de texto del bloque después de rotarlo.
     */

    public String spinRight() {
        ArrayNxN convertedBlock = conversor();  // Convierte el bloque a un arrayNxN
        ArrayMxN convertido;
    
        convertedBlock = convertedBlock.spinRight();    // Rota el bloque convertido a la derecha
        convertido = convertedBlock.getMinArray();  // Usa el método getMinArray para eliminar las de filas y columnas vacías y lo equivale a un arrayMxN

        this.bloque = convertido;   // Bloque, al ser de tipo arrayMxN, se puede hacer una conversión directa

        return this.toString(); // Devuelve en formato de cadena de texto el bloque rotado

    }


    /**
     * Gira el bloque a la izquierda y lo devuelve en formato de cadena de texto.
     * @return Representa en cadena de texto el bloque después de la rotación.
     */

    public String spinLeft() {
        ArrayNxN convertedBlock = conversor();  // Convierte el bloque a un arrayNxN
        ArrayMxN convertido;
    
        convertedBlock = convertedBlock.spinLeft(); // Rota el bloque convertido a la izquierda
        convertido = convertedBlock.getMinArray();  // Usa el método getMinArray para eliminar las de filas y columnas vacías y lo equivale a un arrayMxN

        this.bloque = convertido;   // Bloque, al ser de tipo arrayMxN, se puede hacer una conversión directa

        return this.toString(); // Devuelve en formato de cadena de texto el bloque rotado

    }


    /**
     * Convierte el bloque a un formato más grande (ArrayNxN) para poder rotarlo.
     * @return Bloque convertido a ArrayNxN.
     */

    public ArrayNxN conversor() {
        // Convertir de nuevo a ArrayNxN.
        int num = Math.max(this.bloque.columns(), this.bloque.rows());  // Usa el número máximo entre el las filas y columnas del bloque que se quiere rotar, para hacer un arrayNxN de las máximas dimensiones posibles
        ArrayNxN convertedBlock = new ArrayNxN(num);    // Crea un arrayNxN con la dimensión antes señalada

        for (int i = 0; i < this.bloque.rows(); i++) {
            for (int j = 0; j < this.bloque.columns(); j++) {
                convertedBlock.set(i, j, this.bloque.get(i, j));    // Incluye en el array creado el valor de cada posición del bloque actual
            }
        }

        return convertedBlock;  // Devuelve el bloque convertido
    }


    /**
     * Obtiene la columna en la que se encuentra el bloque en el tablero.
     * @return Columna en la que se encuentra el bloque.
     */

    public int columns() {
        return this.col;
    }

}