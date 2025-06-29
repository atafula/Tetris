package es.unileon.prg1.tetris;

/**
 * Clase que representa el bloque T, heredando de la clase principal, Block.
 * @author Adrián Tafula Da Silva
 */

public class BlockT extends Block {

    /**
     * Constructor que crea el bloque T y establece su forma y color (magenta).
     * @see Block
     */

    public BlockT() {

        this.bloque = new ArrayMxN(2, 3); //Define el tamaño de la matriz
        
        this.bloque.set(0,0,1);
        this.bloque.set(0,1,1);
        this.bloque.set(0,2,1);
        this.bloque.set(1,1,1);

        this.piece = new Piece(Color.MAGENTA, "T"); //Define el color y la señal de la pieza
    }
}