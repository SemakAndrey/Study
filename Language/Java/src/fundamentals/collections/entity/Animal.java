package fundamentals.collections.entity;

import fundamentals.collections.service.comparators.core.ICompare;

import java.util.Objects;

public class Animal implements ICompare<Animal>, Comparable<Animal> {

    private int age;
    private String nick;

    public Animal(String nick, int age) {
        this.nick = nick;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", nick='" + nick + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                Objects.equals(nick, animal.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, nick);
    }

    @Override
    public int compareByMainField(Animal o) {

        if (o == null) {
            return 1;
        }

        return this.age - o.age;
    }

    @Override
    public int compareByAlgorithm(Animal o) {

        int compareMainElem = compareByMainField(o);

        if (compareMainElem == 0) {
            return this.nick.compareTo(o.nick);
        }

        return compareMainElem;
    }

    @Override
    public int compareTo(Animal o) {
        return compareByAlgorithm(o);
    }
}
