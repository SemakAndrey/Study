package fundamentals.collections.utils;

import fundamentals.collections.service.comparators.core.ICompare;

import java.util.List;

public class SorterUtil {

    public static <T extends ICompare<T>> void sort(List<T> list) {

        int length = list.size();
        if (list.size() == 0) {
            return;
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                T elemJ = list.get(j);
                T elemJ1 = list.get(j - 1);
                if (elemJ.compareByAlgorithm(elemJ1) < 0) {
                    list.add(j, elemJ1);
                    list.add(j - 1, elemJ);
                    list.remove(j);
                    list.remove(j + 1);
                }
            }
        }
    }

}
