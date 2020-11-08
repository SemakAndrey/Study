package fundamentals.war_and_piece.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReaderUtil {

    public static String readText(String url) {
        try {
            return new String(Files.readAllBytes(Paths.get(url)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

}
