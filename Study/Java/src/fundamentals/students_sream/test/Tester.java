package fundamentals.students_sream.test;

import fundamentals.collections.utils.RandomUtils;
import fundamentals.students_sream.entity.Student;
import fundamentals.students_sream.resourses.Options;
import fundamentals.students_sream.utils.ObjectManager;
import fundamentals.students_sream.utils.ReaderUtil;
import fundamentals.students_sream.utils.WriterUtil;

import java.util.List;

public class Tester {

    public void run() {

        List<Student> students = ReaderUtil.getStartData(
                () -> new Student(RandomUtils.getRandomString(0, 25),
                        RandomUtils.getRandomString(0, 25),
                        RandomUtils.getRandomString(0, 25),
                        RandomUtils.getRandomInt(1, 10)));

        List<Student> top = ObjectManager.getTopByScore(students, 5000);

        WriterUtil.saveData(Options.DEFAULT_FILE_WITH_TOP, top);

    }

}
