package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] digits) {
        MaxThread maxThread = new MaxThread(digits);
        MinThread minThread = new MinThread(digits);
        maxThread.start();
        LOGGER.log(Level.INFO, maxThread.getName() + "started");
        minThread.start();
        LOGGER.log(Level.INFO, minThread.getName() + "started");
        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Map.of("max", maxThread.getMax(), "min", minThread.getMin());
    }
    // END
}
