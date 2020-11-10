package fundamentals.tower_of_brahma.io;

import fundamentals.tower_of_brahma.model.Options;

import java.util.*;

public class Reader {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean stopFlag;
    
    public static Options getOption () {

        stopFlag = false;
        
        Options options = new Options();

        String text = "Select game mode(1 - manual mode; 2 - auto mode; 0 - exit)";
        options.setMode(getInputValue(text,1,2));
        
        if (stopFlag) {
            return options;
        }        

        text = "Select number of rings (form 3 to 8; 0 - exit)";
        options.setNumberRings(getInputValue(text, 3,8));

        if (stopFlag) {
            return options;
        }
        
        return options;
    }

    private static int getInputValue(String request, int minValue, int maxValue) {

        int inValue;

        while (true){
            Writer.showText(request);
            inValue = scanner.nextInt();
            if (inValue >= minValue && inValue <= maxValue ) {
                break;
            } else if (inValue == 0) {
                stopFlag = true;
                return 0;
            }
            Writer.showText("Incorrect value! Please repeat!");
        }

        return inValue;
    }

    public static boolean isStopFlag() {
        return stopFlag;
    }

    public static int[] getNextMove(int rings) {

        Writer.showText("Enter next move \"N N\"(1-st is\"from\",2-nd if \"to\"; 0 - for exit )");
        int[] array = new int[2];

        for (int i = 0; i < 2; i++) {
            array[i] = scanner.nextInt();

            if (array[i] > rings - 1 || array[i] < 0) {
                Writer.showText("You cannot make this move! Try again!");
                i--;
            }

            if (array[i] == 0) {
                stopFlag = true;
                return array;
            }
        }

        return array;
    }

    public static String askSaveGame() {

        Writer.showText("Do you want to save the game(y / n)?");
        String line = scanner.next();
        if (line.trim().equals("n")) {
            return null;
        }
        Writer.showText("Write file name");
        return scanner.next().trim();
    }

}
