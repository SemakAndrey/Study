package jet_brains_academy.readability_score.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InteractionUtil {

    public static List<String> readInputData(String filename) {

        Path path = Paths.get(filename);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static String getOption() {

        String[] options = {"ARI", "FK", "SMOG", "CL", "ALL"};
        Scanner scanner = new Scanner(System.in);
        return request(scanner, options);

    }

    private static String request(Scanner scanner, String[] options) {

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, ALL):");
        String line = scanner.next();

        if (Arrays.binarySearch(options,line.toUpperCase()) == -1) {
            System.out.println("Wrong options!!! Please, try again.");
            line = request(scanner, options);
        }
        return line;
    }

}
