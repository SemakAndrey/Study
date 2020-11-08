package fundamentals.students_sream.test;

import fundamentals.students_sream.entity.Student;
import fundamentals.students_sream.resourses.Options;
import fundamentals.students_sream.utils.ReaderUtil;

import java.io.File;
import java.util.List;

public class Tester2 {

    public void run() {

        int limit = 10;
        List<Student> top = ReaderUtil.readFile(new File(Options.DEFAULT_FILE_WITH_TOP));
        top.stream()
                .sorted((o1, o2) -> o2.compareByStringParam(o1))
                .limit(limit)
                .forEach(System.out::println);
    }
}
