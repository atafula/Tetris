package es.unileon.prg1.tetris;

/**
 * Clase que representa el bloque J, heredando de la clase principal, Block.
 * @author Adrián Tafula Da Silva
 */

public class BlockJ extends Block {

    /**
     * Constructor que crea el bloque J y establece su forma y color (azul).
     * @see Block
     */

    public BlockJ() {

        this.bloque = new ArrayMxN(3, 2); //Define el tamaño de la matriz
        
        this.bloque.set(0,1,1);
        this.bloque.set(1,1,1);
        this.bloque.set(2,0,1);
        this.bloque.set(2,1,1);

        this.piece = new Piece(Color.BLUE, "J"); //Define el color y la señal de la pieza
    }
}