package fundamentals.tower_of_brahma.model;

import fundamentals.tower_of_brahma.ai.RobotSmart;
import fundamentals.tower_of_brahma.io.Reader;
import fundamentals.tower_of_brahma.io.Writer;

public class Game {

    private int mode;
    private int[][] gameDesk;
    private int moveCounter;
    private final int SHAFT = 3;
    private int rings;

    private void initializeFields() {

        Options options = Reader.getOption();

        this.mode = options.getMode();
        this.rings = options.getNumberRings();
        gameDesk = initializeArrayForGame();
        moveCounter = 0;

    }

    private int[][] initializeArrayForGame() {

        if (this.rings == 0) {
            return null;
        }

        int[][] array = new int[SHAFT][this.rings];
        for (int i = 0; i < this.rings; i++) {
            array[0][i] = this.rings - i;
        }
        return array;
    }

    public void start() {

        initializeFields();

        while (true) {

            if (Reader.isStopFlag()) {
                return;
            }

            if (gameFinished()) {
                Writer.showText("You've made " + moveCounter + " steps");
                Writer.printGameDesk(gameDesk, rings);
                return;
            }

            moveCounter++;

            Writer.printGameDesk(gameDesk, rings);
            int[] move;
            if (mode == 1) {
                move = Reader.getNextMove(rings);
            } else {
                move = RobotSmart.getNextMove(gameDesk);
            }

            if (move[0] != 0 && move[1] != 0 && !makeMove(move[0], move[1])) {
                Writer.showText("You cannot make this move! Try again!");
            }

        }

    }

    private boolean makeMove(int from, int to) {

        if (from == to) {
            return true;
        }

        from--;
        to--;

        int indexFrom = getLastNotEmptyElementIndex(gameDesk[from]);
        int indexTo = getLastNotEmptyElementIndex(gameDesk[to]);

        if (gameDesk[from][indexFrom] == 0 ||
                gameDesk[from][indexFrom] > gameDesk[to][indexTo] && gameDesk[to][indexTo] != 0) {
            return false;
        }

        if (gameDesk[to][indexTo] == 0) {
            gameDesk[to][indexTo] = gameDesk[from][indexFrom];
        } else {
            gameDesk[to][indexTo + 1] = gameDesk[from][indexFrom];
        }
        gameDesk[from][indexFrom] = 0;

        return true;
    }

    public static int getLastNotEmptyElementIndex(int[] arr) {

        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    private boolean gameFinished() {

        if (gameDesk[SHAFT - 1][this.rings - 1] != 0) {
            Writer.showText("Congratulation! You win!!!!!!!!");
            return true;
        }
        return false;
    }

}