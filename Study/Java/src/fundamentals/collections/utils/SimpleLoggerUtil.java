package fundamentals.collections.utils;

public class SimpleLoggerUtil {

    private long timeStart;

    public SimpleLoggerUtil() {
        this.timeStart = System.currentTimeMillis();
    }

    public void log(String operation) {

        long finishTime = System.currentTimeMillis();
        System.out.println("Операция: " + operation + ". Заняла " + (finishTime - this.timeStart) + " мс");
        this.timeStart = finishTime;

    }
}
