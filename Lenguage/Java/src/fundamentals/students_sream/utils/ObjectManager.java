package fundamentals.students_sream.utils;

import fundamentals.students_sream.entity.core.IComparator;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectManager {

    public static <T extends IComparator<T>> List<T> getTopByScore(List<T> ls, int limit) {

        return ls.stream()
                .sorted(IComparator::compareByIntParam)
                .limit(limit)
                .sorted(IComparator::compareByStringParam)
                .collect(Collectors.toList());
    }
}
