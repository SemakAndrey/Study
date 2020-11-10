package fundamentals.collections.service.comparators;

import fundamentals.collections.service.comparators.core.ICompare;

import java.util.Comparator;

public class SimpleComparator<T extends ICompare<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {

        return o1.compareByAlgorithm(o2);

    }

}
