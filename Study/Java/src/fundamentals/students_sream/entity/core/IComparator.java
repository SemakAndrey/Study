package fundamentals.students_sream.entity.core;

public interface IComparator<T> {

    int compareByStringParam(T o1);
    int compareByIntParam(T o1);

}
