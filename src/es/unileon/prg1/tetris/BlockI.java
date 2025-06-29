package es.unileon.prg1.tetris;

/**
 * Clase que representa el bloque I, heredando de la clase principal, Block.
 * @author Adrián Tafula Da Silva
 */

public class BlockI extends Block {

    /**
     * Constructor que crea el bloque I y establece su forma y color (cian).
     * @see Block
     */

    public BlockI() { // Crea el bloque I

        this.bloque = new ArrayMxN(4, 1); // Define el tamaño de la matriz
        
        this.bloque.set(0,0,1);
        this.bloque.set(1,0,1);
        this.bloque.set(2,0,1);
        this.bloque.set(3,0,1);

        this.piece = new Piece(Color.CYAN, "I"); // Define el color y la señal de la pieza
    }
}