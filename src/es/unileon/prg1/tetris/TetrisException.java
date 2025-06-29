package es.unileon.prg1.tetris;

/** 
 * Extiende la clase base Exception, identificándose como una excepción propia del juego.
*/

public class TetrisException extends Exception {

    /**
     * Constructor de TetrisException
     * @param message El mensaje que se quiere informar en la excepción
     */

    public TetrisException(String message){
        super(message); // Utiliza el constructor de la clase que extiende (Exception) para crear la excepción requerida
    }
}
