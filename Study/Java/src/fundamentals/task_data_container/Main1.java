package homework4.task_data_container;

import java.util.Arrays;
import java.util.Comparator;

public class Main1 {

    /*
    * Работа с массивами, Работа с дженериками, Comparable, Comparator. DataContainer:
    * 1. Создать класс DataContainer у которого есть один дженерик (обобщение). Например T.
    * 2. Внутри DataContainer есть поле T[] data которое предназначено для хранения передаваемых объектов.
    * 3. Данный класс будет служить для хранения неограниченного количества объектов передаваемых
    *   через метод int add(T item). Данный метод сохраняет переданный item внутри Data container
    *   и возвращает index данного элемента.
    * 4. Метод int add(T item) добавляет данные в первую позицию (ячейку) в массиве после последней заполненной
    *   ячейки. Пример: data = [1, 2, 3, null, null, null]. Вызвали add(777).
    *   Должно получиться data = [1, 2, 3, 777, null]. Метод add вернёт число 3.
    * 5. В случае если массив будет переполнен нужно придумать механизм который будет расширять пространство
    *   для новых элементов. Тут вам поможет Arrays.copyOf. Пример: data = [1, 2, 3].
    *   Вызвали add(777). Должно получиться data = [1, 2, 3, 777]. Метод add вернёт число 3.
    * 5. В данном классе должен быть метод T get(int index). Данный метод получает из Data container предварительно сохранённый объект в нём (переданный через add).
    * 6. В данном классе должен быть метод T[] getItems(). Данный метод возвращает data.
    * 7. Добавить метод boolean delete(int index) который будет удалять элемент массива по индексу.
    * 	7.1 Метод возвращает true если у нас получилось удалить данные. Пример data = [1, 2, 3, 777]. Вызывают delete(3). Должно получиться data = [1, 2, 3]. Метод delete вернёт true
    * 	7.2 Метод возвращает false если нет такого индекса. Пример data = [1, 2, 3, 777]. Вызывают delete(9). Должно получиться data = [1, 2, 3, 777]. Метод delete вернёт false
    * 	7.4. Освободившуюся ячейку необходимо удалить полностью. Пустых элементов не должно быть. Пример data = [1, 2, 3, 777]. Вызывают delete(2). Должно получиться data = [1, 2, 777]. Метод delete вернёт true
    * 8. Добавить метод boolean delete(E item) который будет удалять элемент массива по элементу.
    * 	8.1 Метод возвращает true если у нас получилось удалить данные. Пример data = [1, 2, 3, 777]. Вызывают delete(777). Должно получиться data = [1, 2, 3]. Метод delete вернёт true
    * 	8.2 Метод возвращает false если нет такого элемента. Пример data = [1, 2, 3, 777]. Вызывают delete(111). Должно получиться data = [1, 2, 3, 777]. Метод delete вернёт false
    * 	8.3 Освободившуюся ячейку необходимо удалить полностью. Пустых элементов не должно быть. Пример data = [1, 2, 3, 777, 3]. Вызывают delete(3). Должно получиться data = [1, 2, 777, 3]. Метод delete вернёт true
    * 9. В данном классе должен быть НЕ СТАТИЧЕСКИЙ метод void sort(Comparator<.......> comparator).
    *   Данный метод должен отсортировать текущий контейнер используя реализацию
    *   сравнения из ПЕРЕДАННОГО объекта интерфейса Comparator.
    * 10. Переопределить метод toString() в классе и выводить содержимое data без ячеек в которых хранится null.
    * 11.* В даном классе должен быть СТАТИЧЕСКИЙ метод void sort(DataContainer<.............> container)
    *   который будет принимать объект DataContainer с дженериком extends Comparable.
    *   Данный метод будет сортировать элементы в ПЕРЕДАННОМ объекте DataContainer
    *   используя реализацию сравнения вызываемый у хранимых объектов.
    * 12.** В данном классе должен быть СТАТИЧЕСКИЙ метод void sort(DataContainer<.............> container,
    *   Comparator<.......> comparator) который будет принимать объект DataContainer
    *   и реализацию интерфейса Comparator. Данный метод будет сортировать элементы в
    *   ПЕРЕДАННОМ объекте DataContainer используя реализацию сравнения из ПЕРЕДАННОГО объекта интерфейса Comparator.
    */

    public static void main(String[] args) {

        Integer[] arr = {1, 20, 3, 70, null};

        DataContainer<Integer> dc = new DataContainer<>(arr);

        //4
        System.out.println("\nadd:");
        System.out.println(dc.add(777));
        System.out.println(dc.add(45));

        System.out.println(dc.add(null));

        //5
        System.out.println("\nget:");
        System.out.println(dc.get(2));

        //6
        System.out.println("\ngetItems:");
        System.out.println(Arrays.toString(dc.getItems()));

        //7
        System.out.println("\ndelete:");
        System.out.println(dc.delete(8));
        System.out.println(Arrays.toString(dc.getItems()));
        System.out.println(dc.delete(0));
        System.out.println(Arrays.toString(dc.getItems()));

        //8
        System.out.println("\ndelete by Item:");
        System.out.println(dc.delete((Integer) 8));
        System.out.println(Arrays.toString(dc.getItems()));
        System.out.println(dc.delete((Integer) 777));
        System.out.println(Arrays.toString(dc.getItems()));

        //9
        Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) {
                    return 0;
                } else if (o1 == null) {
                    return -1;
                } else if (o2 == null) {
                    return 1;
                }

                return o1 - o2;
            }
        };
        System.out.println("\nsort:");
        dc.sort(comparator);
        System.out.println(Arrays.toString(dc.getItems()));

        //10
        System.out.println("\ntoString:");
        dc.add(null);
        System.out.println(Arrays.toString(dc.getItems()));
        System.out.println(dc.toString());

        //11
        System.out.println("\nComparable:");
        arr = new Integer[] {1, 20, 3, 70, 2};
        dc = new DataContainer<>(arr);
        System.out.println(dc.toString());
        DataContainer.sort(dc);
        System.out.println(dc.toString());

        //12
        System.out.println("\nSort with comparator:");
        arr = new Integer[] {1, 20, 3, 70, 2};
        dc = new DataContainer<>(arr);
        System.out.println(dc.toString());
        DataContainer.sort(dc,comparator);
        System.out.println(dc.toString());


    }

}
