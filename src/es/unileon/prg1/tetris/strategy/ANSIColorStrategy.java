package es.unileon.prg1.tetris.strategy;

import es.unileon.prg1.tetris.Color;
import es.unileon.prg1.tetris.Piece;

public class ANSIColorStrategy implements ColorStrategy{

    // NONE, YELLOW, WHITE, GREEN, CYAN, BLUE, RED, MAGENTA, BLACK;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_DEFAULT = "\u001b[49;1m  " + ANSI_RESET;
    public static final String ANSI_YELLOW = "\u001b[43;1m  " + ANSI_RESET;
    public static final String ANSI_WHITE = "\u001b[47;1m  " + ANSI_RESET;
    public static final String ANSI_GREEN = "\u001b[42;1m  " + ANSI_RESET;
    public static final String ANSI_CYAN = "\u001b[46m  " + ANSI_RESET;
    public static final String ANSI_BLUE = "\u001b[44m  " + ANSI_RESET;
    public static final String ANSI_RED = "\u001b[41;1m  " + ANSI_RESET;
    public static final String ANSI_MAGENTA = "\u001b[45;1m  " + ANSI_RESET;
    public static final String ANSI_BLACK = "\u001b[40;1m  " + ANSI_RESET;

    protected ANSIColorStrategy(){
    }

    private String ansiColor(Color color) {
        String ansiString;
        switch (color) {
            case YELLOW:
                ansiString = ANSI_YELLOW;
                break;
            case WHITE:
                ansiString = ANSI_WHITE;
                break;
            case GREEN:
                ansiString = ANSI_GREEN;
                break;
            case CYAN:
                ansiString = ANSI_CYAN;
                break;
            case BLUE:
                ansiString = ANSI_BLUE;
                break;
            case RED:
                ansiString = ANSI_RED;
                break;
            case MAGENTA:
                ansiString = ANSI_MAGENTA;
                break;
            case BLACK:
                ansiString = ANSI_BLACK;
                break;
            default:
                ansiString = ANSI_DEFAULT;
        }
        return ansiString;
    }

    public String toString(Piece piece){
        return this.ansiColor(piece.getColor());
    }
}
