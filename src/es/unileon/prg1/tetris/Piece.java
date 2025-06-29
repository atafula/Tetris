package es.unileon.prg1.tetris;

import es.unileon.prg1.tetris.strategy.ColorStrategySingleton;

/**
 * Clase que contiene la "información" de una pieza
 */

public class Piece {

    private Color color;    // Se crea una variable que identifica el color de la pieza
    private String sign;    // La letra que identifica la pieza

    /**
     * Constructor de Piece que crea una pieza vacía sin color
     */

    public Piece() {
        this.color = Color.NONE;    // Sin color
        this.sign = "  ";       // Dos espacios, es por ello que los bloques que no tienen pieza en una posición, pasan a tener 2 espacios, o el tablero mismo que se compone por 2 espacios por pieza vacía también
    }


    /**
     * Constructor de Piece que crea una pieza con un color y letra específicas
     * @param color Color de la pieza
     * @param sign Letra de la pieza
     */

    public Piece(Color color, String sign) {
        this.color = color; // Color de la pieza
        this.sign = sign + " ";     // Letra de la pieza + un espacio. Es por ello que la posición ocupada (no vacía) de una pieza es una letra más un espacio
    }

    /**
     * Constructor dque crea una copia de otra pieza
     * @param another Otra pieza a copiar
     */

    public Piece(Piece another){
        this.color = another.getColor();    // Equivale el color de la pieza que se quiere copiar, al actual
        this.sign = another.getSign();  // Equivale la letra de la pieza que se quiere copiar, al actual
    }


    /**
     * Obtiene el color de la pieza
     * @return Color de la pieza
     */

    public Color getColor() {
        return this.color;  // Devuelve el color actual
    }


    /**
     * Obtiene la letra de la pieza
     * @return Letra de la pieza
     */

    public String getSign() {
        return this.sign;   // Devuelve el signo o letra de la pieza actual
    }


    /**
     * Verifica si la pieza está "vacía"
     * @return "true" si está vacía, "false" en caso contrario
     */

    public boolean isEmpty() {
        return this.sign.trim().length() == 0;  // ELimina espacios a la izquierda y la derecha de la letra de la pieza. En caso de que la longitud sea 0, se devuelve "true"
    }


    /**
     * Representación en cadena de texto de la pieza
     * Utiliza ColorStrategySingleton para generar la cadena (pues si tiene color, se mostrará "pintada")
     * @return Cadena de texto que representa la pieza actual
     */

    public String toString() {
        return ColorStrategySingleton.getInstance().toString(this); // Devuelve en cadena de texto la pieza actual
    }

}