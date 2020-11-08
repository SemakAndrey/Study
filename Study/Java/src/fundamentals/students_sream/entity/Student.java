package fundamentals.students_sream.entity;

import fundamentals.students_sream.entity.core.IComparator;

import java.io.Serializable;

public class Student implements Serializable, IComparator<Student> {

    private String firstName;
    private String lastName;
    private String middleName;
    private String fio;
    private int score;

    public Student(String firstName, String lastName, String middleName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.fio = lastName + firstName + middleName;
        this.score = score;
    }

    public String getFio() {
        return fio;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fio='" + fio + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareByStringParam(Student student) {
        return this.fio.compareTo(student.getFio());
    }

    @Override
    public int compareByIntParam(Student student) {
        return  student.getScore() - this.score;
    }
}
