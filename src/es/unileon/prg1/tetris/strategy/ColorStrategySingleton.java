package es.unileon.prg1.tetris.strategy;

public class ColorStrategySingleton {
    private static ColorStrategy strategy;

    private ColorStrategySingleton() {
    }

    public static ColorStrategy getInstance() {
        if (strategy == null) {
            strategy = new NoColorStrategy();
        }
        return strategy;
    }

    public static ColorStrategy getInstance(String mode) {
        if (strategy == null) {
            if (mode.equals("color")) {
                strategy = new ANSIColorStrategy();
            } else {
                strategy = new NoColorStrategy();
            }
        }
        return strategy;
    }
}
