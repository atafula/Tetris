package es.unileon.prg1.tetris;

/**
 * Clase de arrayNxN que define un array 2D cuadrado (mismas columnas y filas) con cierto tamaño
 * @author Daniel Díez Prieto
 */

public class ArrayNxN extends ArrayMxN {


    /**
     * Constructor que crea un array bidimensional cuadrado del tamaño especificado
     * @param size Tamaño del array
     * @see ArrayMxN
     */

    public ArrayNxN(int size) {
        super(size, size);  // Utiliza el constructor de ArrayMxN para hacer un array de mismas filas y columnas
    }


    /**
     * Constructor que crea un array bidimensional cuadrado a partir de un arrayMxN. Ut
     * @param initial arrayMxN a utilizar
     */

    public ArrayNxN(ArrayMxN initial) {
        this(Math.max(initial.rows(), initial.columns()));

        for (int i = 0; i < initial.rows(); i++) {
            for (int x = 0; x < initial.columns(); x++) {
                this.set(i, x, initial.get(i, x));
            }
        }

    }


    /**
     * Verifica si una fila está vacía
     * @param x Indice de la fila
     * @return "True" si está vacía, "False" si no
     */

    private boolean isEmptyRow(int x) {
        int col = 0;
        boolean res = true;

        while (col < this.columns() && (res = (this.get(x, col) == 0))) {
            col++;
        }

        return res;
    }


    /**
     * Verifica si una columna está vacía
     * @param x índice de la columna
     * @return "True" si está vacía, "False" si no
     */

    private boolean isEmptyColumn(int x) {
        int row = 0;
        boolean res = true;

        while (row < this.rows() && (res = (this.get(row, x) == 0))) {
            row++;
        }

        return res;
    }


    /**
     * Verifica si todo el array está vacío
     * @return "True" si está vacío, "false" si no
     */

    public boolean isEmpty() {
        int col = 0;
        boolean res = true;

        while (col < this.columns() && (res = isEmptyColumn(col))) {
            col++;
        }

        return res;
    }


    /**
     * Obtiene un nuevo arrayMxN eliminando las filas y columnas vacías del arrayNxN actual
     * @return ArrayMxN con las filas y columnas vacías eliminadas
     */

    public ArrayMxN getMinArray() {
        ArrayMxN res = null;

        if (!this.isEmpty()) {
            int startRow = 0;
            int endRow = this.rows() - 1;
            int startCol = 0;
            int endCol = this.columns() - 1;

            while (startRow < endRow && isEmptyRow(startRow)) {
                startRow++;
            }

            while (endRow > startRow && isEmptyRow(endRow)) {
                endRow--;
            }

            while (startCol < endCol && isEmptyColumn(startCol)) {
                startCol++;
            }

            while (endCol > startCol && isEmptyColumn(endCol)) {
                endCol--;
            }

            int minRows = endRow - startRow + 1;
            int minCols = endCol - startCol + 1;

            res = new ArrayMxN(minRows, minCols);

            for (int i = 0; i < minRows; i++) {
                for (int x = 0; x < minCols; x++) {
                    res.set(i, x, this.get(startRow + i, startCol + x));
                }
            }
        }

        return res;
    }


    /**
     * Obtiene el valor en la posición especificada
     * @param row Fila
     * @param column Columna
     * @return Valor en la posición especificada
     */

    public int get(int row, int column) {

        int res = Integer.MIN_VALUE;

        if (validacionNum(row, column)) {
            res = array[row][column];
        }

        return res;

    }


    /**
     * Establece un valor en el bloque en la posición especificada
     * @param row Fila específica
     * @param column Columna específica
     * @return "True" si se estableció correctamente, "false" en caso contrario
     */

    public boolean set(int row, int column, int value) {
        boolean res = validacionNum(row, column);

        if (res) {
            array[row][column] = value;
        }

        return res;
    }


    /**
     * Obtiene un arrayNxN identidad (la diagonal principal son 1s y el resto 0s)
     * @return ArrayNxN identidad
     */

    public ArrayNxN getIdentity() {
        int size = Math.max(rows(), columns());
        ArrayNxN res = new ArrayNxN(size);

        for (int i = 0; i < size; i++) {
            res.set(i, i, 1);
        }

        return res;
    }


    /**
     * Obtiene un arrayNxN reflejado verticalemente
     * @return arrayNxN reflejado verticalmente
     */

    public ArrayNxN mirrorV() {
        ArrayNxN res = new ArrayNxN(this);

        for (int x = 0; x < rows(); x++) {
            for (int i = 0; i < columns() / 2; i++) {
                int temp = res.get(x, i);
                res.set(x, i, res.get(x, columns() - i - 1));
                res.set(x, columns() - i - 1, temp);
            }
        }

        return res;
    }


    /**
     * Obtiene un arrayNxN reflejado horizontalmente
     * @return arrayNxN reflejado horizontalmente
     */

    public ArrayNxN mirrorH() {
        ArrayNxN res = new ArrayNxN(this);

        for (int m = 0; m < rows() / 2; m++) {
            for (int n = 0; n < columns(); n++) {
                int temp = res.get(m, n);
                res.set(m, n, res.get(rows() - m - 1, n));
                res.set(rows() - m - 1, n, temp);
            }
        }

        return res;
    }


    /**
     * Obtiene un arrayNxN traspuesto
     * @return ArrayNxN traspuesto
     */

    public ArrayNxN transpose() {
        ArrayNxN res = new ArrayNxN(this);

        for (int x = 0; x < rows(); x++) {
            for (int i = 0; i < columns(); i++) {
                res.set(i, x, this.get(x, i));
            }
        }

        return res;
    }


    /**
     * Multiplica el arrayNxN actual por otro NxN
     * @param another arrayNxN a multiplicar
     * @return ArrayNxN resultado de la multiplicación
     */

    public ArrayNxN multiply(ArrayNxN another) {
        int rowsA = this.rows();
        int colsA = this.columns();
        int rowsB = another.rows();
        int colsB = another.columns();

        ArrayNxN res = null;

        if (!(colsA != rowsB)) {

            res = new ArrayNxN(this);

            for (int i = 0; i < rowsA; i++) {
                for (int x = 0; x < colsB; x++) {
                    int sum = 0;
                    for (int z = 0; z < colsA; z++) {
                        sum += this.get(i, z) * another.get(z, x);
                    }
                    res.set(i, x, sum);
                }
            }
        }

        return res;
    }


    /**
     * Obtiene el arrayNxN tras girar el actual a la derecha
     * @return arrayNxN girado a la derecha
     */

    public ArrayNxN spinRight() {
        ArrayNxN spinnedArray;
        spinnedArray = this.transpose().multiply(this.getIdentity().mirrorV());
        return spinnedArray;
    }


    /**
     * Obtiene el arrayNxN tras girar el actual a la izquierda
     * @return arrayNxN girado a la izquierda
     */

    public ArrayNxN spinLeft() {
        ArrayNxN spinnedArray;
        spinnedArray = this.transpose().multiply(this.getIdentity()).mirrorH();
        return spinnedArray;
    }


    /**
     * Convierte el arrayNxN en una cadena de texto
     * @return Cadena de texto que representa el array
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
     * Realiza una validación para comprobar que el número de los índices asignados es correcto sujeto a una condición
     * @param row Fila
     * @param column Columna
     * @return "True" si los índices son correctos en caso de que 0 sea menor o igual que "row" y este, a su vez, menos que filas del arrayNxN (igual para las columnas), "false" en caso contrario
     */

    private boolean validacionNum(int row, int column) {
        return row >= 0 && row < rows() && column >= 0 && column < columns();

    }
}