package fundamentals.collections.service.comparators.core;

public interface ICompare<T> {

    int compareByMainField(T o);

    int compareByAlgorithm(T o);

}
