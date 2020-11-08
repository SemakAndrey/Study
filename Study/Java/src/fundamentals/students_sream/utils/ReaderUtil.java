package fundamentals.students_sream.utils;

import fundamentals.students_sream.resourses.Options;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class ReaderUtil {

    public static <T extends Serializable> List<T> getStartData(Supplier<T> supplier) {

        return readFile(getFile(supplier));

    }

    private static <T extends Serializable> File getFile(Supplier<T> supplier) {
        System.out.print("Enter file name: ");

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        File file = new File(fileName);
        if (!file.exists() || file.isDirectory()) {
            file = new File(Options.DEFAULT_FILE_WITH_COLLECTION);

            if (!file.exists() || file.isDirectory()) {
                WriterUtil.generateStudentsByStream(supplier, 10000);
            }
        }
        return file;
    }

    public static <T extends Serializable> List<T> readFile(File file) {

        List<T> ls = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            int type = objectInputStream.readInt();
            switch (type) {
                case 1:
                    readFileSerializable(objectInputStream, ls);
                    break;
                case 2:
                    readFileFields(objectInputStream, ls);
                    break;
                default:
                    System.out.println("Incorrect file");
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ls;
    }

    private static <T> void readFileSerializable(ObjectInputStream objectInputStream, List<T> ls) {
        try {
            ls.addAll((Collection<? extends T>) objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
        }

    }

    private static <T> void readFileFields(ObjectInputStream objectInputStream, List<T> ls) {

    }

}
