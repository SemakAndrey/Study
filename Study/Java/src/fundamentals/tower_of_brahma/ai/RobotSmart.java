package fundamentals.tower_of_brahma.ai;

import fundamentals.tower_of_brahma.model.Game;

public class RobotSmart {

    private static int step = 0;

    public static int[] getNextMove(int[][] gameDesk){

        boolean isEven = gameDesk[0].length % 2 == 0;
        if (step == 3) {
            step = 1;
        } else {
            step++;
        }

        int[] variant = getNextRobotMove(isEven, step);

        int indexFirst = Game.getLastNotEmptyElementIndex(gameDesk[variant[0] - 1]);
        int indexSecond = Game.getLastNotEmptyElementIndex(gameDesk[variant[1] - 1]);

        int minVal;
        if(gameDesk[variant[0] - 1][indexFirst] == 0) {
            minVal = Math.min(1000000,gameDesk[variant[1] - 1][indexSecond]);
        } else if (gameDesk[variant[1] - 1][indexSecond] == 0) {
            minVal = Math.min(gameDesk[variant[0] - 1][indexFirst],1000000);
        } else {
            minVal = Math.min(gameDesk[variant[0] - 1][indexFirst],gameDesk[variant[1] - 1][indexSecond]);
        }

        if (gameDesk[variant[0] - 1][indexFirst] != minVal) {
            int temp = variant[1];
            variant[1] = variant[0];
            variant[0] = temp;
        }

        return variant;
    }

    private static int[] getNextRobotMove(boolean isEven, int step) {

        int[] array = new int[2];

        if (isEven) {
            switch (step) {
                case 1:
                    array[0] = 1;
                    array[1] = 2;
                    return array;
                case 2:
                    array[0] = 1;
                    array[1] = 3;
                    return array;
                case 3:
                    array[0] = 2;
                    array[1] = 3;
                    return array;
            }
        } else {
            switch (step) {
                case 1:
                    array[0] = 1;
                    array[1] = 3;
                    return array;
                case 2:
                    array[0] = 1;
                    array[1] = 2;
                    return array;
                case 3:
                    array[0] = 2;
                    array[1] = 3;
                    return array;
            }
        }

        return array;
    }

}
