package fundamentals.collections.utils;

import java.util.Random;

public class RandomUtils {

    public static String getRandomString(int minLength, int maxLength) {

        StringBuilder sb = new StringBuilder();
        int length = getRandomInt(minLength, maxLength);

        for (int i = 0; i < length; i++) {
            sb.append(getRandomChar());
        }

        return sb.toString();
    }

    private static char getRandomChar(){

        int currentRage = getRandomInt(0, 3);
        switch (currentRage) {
            case 1:
                return (char) (65 + getRandomInt(0, 26));
            case 2:
                return (char) (97 + getRandomInt(0, 26));

            default:
                return (char) (1040 + getRandomInt(0, 64));
        }
    }

    public static int getRandomInt(int min, int max) {

        return new Random().nextInt(max - min) + min;

    }

}
