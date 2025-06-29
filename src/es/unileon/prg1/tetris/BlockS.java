package es.unileon.prg1.tetris;

/**
 * Clase que representa el bloque S, heredando de la clase principal, Block.
 * @author Adrián Tafula Da Silva
 */

public class BlockS extends Block {

    /**
     * Constructor que crea el bloque S y establece su forma y color (rojo).
     * @see Block
     */

    public BlockS() {

        this.bloque = new ArrayMxN(2, 3); //Define el tamaño de la matriz
        
        this.bloque.set(0,1,1);
        this.bloque.set(0,2,1);
        this.bloque.set(1,0,1);
        this.bloque.set(1,1,1);

        this.piece = new Piece(Color.RED, "S"); //Define el color y la señal de la pieza
    }
}