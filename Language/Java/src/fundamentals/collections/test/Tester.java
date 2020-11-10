package fundamentals.collections.test;

import fundamentals.collections.service.comparators.core.ICompare;
import fundamentals.collections.service.generators.ObjectGenerator;
import fundamentals.collections.service.comparators.SimpleComparator;
import fundamentals.collections.service.generators.core.IGenerator;
import fundamentals.collections.utils.SimpleLoggerUtil;

import java.util.*;

public class Tester<T extends ICompare<T>> {

    private IGenerator<T> generator;
    private int size;

    public Tester(IGenerator<T> generator, int size) {
        this.generator = generator;
        this.size = size;
    }

    public void run(Collection<T> collection) {

        SimpleLoggerUtil simpleLoggerUtil = new SimpleLoggerUtil();

        ObjectGenerator.generate(collection, this.generator, this.size);
        simpleLoggerUtil.log("Заполнение коллекции");

        if (collection instanceof List) {
            SimpleComparator<T> comparator = new SimpleComparator<>();
            ((List<T>) collection).sort(comparator);
            simpleLoggerUtil.log("Стандартная сортировка коллекции");

//            //3.3.2
//            Sorter.sort((List<T>) collectionForSecondTest);
//            printer.showDuration("Собственная сортировка коллекции");
        } else {
            System.out.println("Для данной коллекции тестирование Сортировки не предусмотрено");
        }


        /* 3.4.2. Итерирования коллекции:
         *  3.4.2.1. При помощи iterator
         *  3.4.2.2. При помощи любого другого способа (не foreach)
         */
        useIterator(collection);
        simpleLoggerUtil.log("Итерирование коллекции через Итератор");

        useNoIterator(collection);
        simpleLoggerUtil.log("Итерирование коллекции без Итератора");

        /* 3.4.3. Удаления всех элементов коллекции (выбрать один из):
         *   3.4.3.1. При помощи iterator
         *   3.4.3.2. При помощи любого другого способа
         */

        removeWithIterator(collection);
        simpleLoggerUtil.log("Удаление из коллекции через Итератор");

//        removeWithoutIterator(collection);
//        simpleLoggerUtil.log("Удаление из коллекции без Итератора");

    }

    private void useIterator(Collection<T> collection) {

        Iterator<T> iterator = collection.iterator();
        T elem = null;
        while (iterator.hasNext()) {
            elem = iterator.next();
        }

    }

    private void useNoIterator(Collection<T> collection) {

        try {
            T elem = null;
            for (Object o : collection.toArray()) {
                elem = (T) o;
            }
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private void removeWithIterator(Collection<T> collection) {

        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

    }

    private void removeWithoutIterator(Collection<T> collection) {

        int size = collection.size();
        try {
            T[] array = (T[]) collection.toArray();

            T elem = null;
            for (int i = 0; i < size; i++) {
                collection.remove(array[i]);
            }
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

}
