package jet_brains_academy.encrypt_decrypt.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOHandlerUtil {

    public static String readData(String in) {

        if (in.isBlank()) {
            return "";
        }

        File file = new File(in);
        try (Scanner scanner = new Scanner(file);) {
            return scanner.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void writeDataToFile (String out, String data) {

        if (out.isBlank()) {
            return;
        }

        File file = new File(out);
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataToConsole(String data) {
        System.out.println(data);
    }
}
