package fundamentals.students_sream.utils;

import fundamentals.students_sream.resourses.Options;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriterUtil {

    public static <T extends Serializable> List<T> generateStudentsByStream(Supplier<T> supplier, int size) {

        List<T> ls = Stream.generate(supplier).limit(size).collect(Collectors.toList());
        if (saveData(Options.DEFAULT_FILE_WITH_COLLECTION, ls)) {
            System.out.println("In process saving file something gone wrong! Sorry:)");
        }
        return ls;
    }

    public static <T extends Serializable> boolean saveData(String fileName, List<T> list) {
        return  writeFileSerializable(new File(fileName), list);
    }

    private static <T extends Serializable> boolean writeFileSerializable(File file, List<T> list) {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            //write marker of type values in file 1 - objects; 2 - fields
            objectOutputStream.writeInt(1);
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static boolean writeFileFields(File file, List<Map<String, String>> ls) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            //write marker of type values in file 1 - objects; 2 - fields
            bufferedWriter.write(2);
            bufferedWriter.write("Objects : [");
            for (int i = 0; i < ls.size(); i++) {
                bufferedWriter.write(i + 1);
                bufferedWriter.write("{");
                for (Map.Entry<String, String> stringStringEntry : ls.get(i).entrySet()) {
                    bufferedWriter.write(stringStringEntry.getKey());
                    bufferedWriter.write(':');
                    bufferedWriter.write(stringStringEntry.getValue());
                }
                bufferedWriter.write("}");
                if (i != ls.size() - 1) {
                    bufferedWriter.write(',');
                }
            }
            bufferedWriter.write("]");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

}
