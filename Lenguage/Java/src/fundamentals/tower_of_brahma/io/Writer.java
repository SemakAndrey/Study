package fundamentals.tower_of_brahma.io;

public class Writer {

    public static void printGameDesk(int[][] gameDesk, int rings) {

        System.out.println("--------");

        for (int i = rings - 1; i >= 0; i--) {
            System.out.print("|");
            for (int[] shaft : gameDesk) {
                System.out.print(shaft[i] == 0 ? " *" : " " + shaft[i]);
            }
            System.out.println("|");
        }

        System.out.println("--------");

    }

    public static void showText(String text){
        System.out.println(text);
    }

}
