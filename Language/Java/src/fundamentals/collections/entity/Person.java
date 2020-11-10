package fundamentals.collections.entity;

import fundamentals.collections.service.comparators.core.ICompare;

import java.util.Objects;

public class Person implements ICompare<Person>,Comparable<Person> {

    private String nick;
    private String password;

    public Person(String nick, String password) {
        this.nick = nick;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(nick, person.nick) &&
                Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password.length(), nick);
    }

    @Override
    public int compareByMainField(Person o) {

        if (o == null) {
            return 1;
        }

        return this.password.length() - o.password.length();
    }

    @Override
    public int compareByAlgorithm(Person o) {

        int compareMainElem = compareByMainField(o);

        if (compareMainElem == 0) {
            return this.nick.compareTo(o.nick);
        }

        return compareMainElem;
    }

    @Override
    public int compareTo(Person o) {
        return compareByAlgorithm(o);
    }
}
