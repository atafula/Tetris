package es.unileon.prg1.tetris;

/**
 * Clase de arrayMxN que define un array 2D con cierto tamaño
 * @author Daniel Díez Prieto
 */

public class ArrayMxN {

    /**
     * Array bidimensional
     */
    protected int[][] array;


    /**
     * Constructor que crea un array bidimensional con las filas y columnas especificadas
     * @param rows Número de filas
     * @param columns Números de columnas
     */

    public ArrayMxN(int rows, int columns) {
        this.array = new int[rows][columns];

    }


    /**
     * Obtiene el número de filas
     * @return Número de filas
     */

    public int rows() {
        return this.array.length;

    }


    /**
     * Obtiene el número de columnas
     * @return Número de columnas
     */

    public int columns() {
        return this.array[0].length;

    }


    /**
     * Obtiene el valor en cierta posición dentro del array (puede ser un 1 o un 0)
     * @param row Fila específica
     * @param column Columna específica
     * @return Valor de la posición especificada
     */

    public int get(int row, int column) {

        int res = Integer.MIN_VALUE;    // Se inicializa una variable primitiva, a devolver, con su valor mínimo

        if (validacionNum(row, column)) {
            res = this.array[row][column];
        }

        return res;

    }


    /**
     * Establece el valor necesario en una posición del array (preferiblemente 0 o 1)
     * @param row Fila específica
     * @param column Columna específica
     * @param value Valor concreto a establecer 
     * @return "true" si la posición es válida, "false" en caso contrario
     */

    public boolean set(int row, int column, int value) {
        boolean res = validacionNum(row, column);

        if (res) {
            this.array[row][column] = value;
        }

        return res;
    }


    /**
     * Representación en cadena de texto el array
     * @return Devuelve en cadena de texto la representación del array
     */

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < this.rows(); i++) {
            for (int x = 0; x < this.columns(); x++) {
                res.append(this.get(i, x));
            }
            res.append("\n");
        }
        return res.toString();

    }


    /**
     * Checkea si las dimensiones del array son correctas
     * @param row Fila especificada
     * @param column Columna especificada
     * @return "true" si es correcta, "false" en caso contrario
     */

    private boolean validacionNum(int row, int column) {
        return row >= 0 && row < rows() && column >= 0 && column < columns();

    }

}