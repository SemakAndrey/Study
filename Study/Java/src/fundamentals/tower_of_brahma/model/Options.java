package fundamentals.tower_of_brahma.model;

public class Options {

    private int mode;
    private int numberRings;

    public Options() {
        this.mode = 0;
        this.numberRings = 0;
    }

    public Options(int mode, int numberRings) {
        this.mode = mode;
        this.numberRings = numberRings;
    }

    public int getMode() {
        return mode;
    }

    public int getNumberRings() {
        return numberRings;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setNumberRings(int numberRings) {
        this.numberRings = numberRings;
    }
}
