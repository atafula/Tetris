package es.unileon.prg1.tetris;

/**
 * Clase que representa el bloque Z, heredando de la clase principal, Block.
 * @author Adrián Tafula Da Silva
 */

public class BlockZ extends Block {

    /**
     * Constructor que crea el bloque Z y establece su forma y color (verde).
     * @see Block
     */

    public BlockZ() {

        this.bloque = new ArrayMxN(2, 3); //Define el tamaño de la matriz
        
        this.bloque.set(0,0,1);
        this.bloque.set(0,1,1);
        this.bloque.set(1,1,1);
        this.bloque.set(1,2,1);

        this.piece = new Piece(Color.GREEN, "Z"); //Define el color y la señal de la pieza
    }
}