package es.unileon.prg1.tetris.strategy;

import es.unileon.prg1.tetris.Piece;

public class NoColorStrategy implements ColorStrategy {

    protected NoColorStrategy() {
    }

    public String toString(Piece piece) {
        return piece.getSign();
    }

}
