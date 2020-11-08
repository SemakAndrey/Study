package fundamentals.task_data_container;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

class DataContainer<T>{

    private T[] storage;

    DataContainer(T[] array) {
        this.storage = array;
    }

    private int getIndex() {

        int length = this.storage.length;
        for (int i = 0; i < length; i++) {
            if (this.storage[i] == null) {
                return i;
            }
        }
        this.storage = Arrays.copyOf(this.storage,length + 1);
        return length;
    }

    //4. Метод int add(T item) добавляет данные в первую позицию (ячейку) в массиве после последней заполненной
    public int add(T item) {
        int index = getIndex();
        this.storage[index] = item;

        return index;
    }

    //5.В данном классе должен быть метод T get(int index). Данный метод получает из Data Container предварительно сохранённый объект в нём (переданный через add).
    public T get(int index) {

        if (index >= this.storage.length) {
            //мы же еще не знаем ArrayIndexOutOfBoundsException
            return null;
        }

        return this.storage[index];
    }

    //6.В данном классе должен быть метод T[] getItems(). Данный метод возвращает data.
    public T[] getItems() {
        return this.storage;
    }

    //7.Добавить метод boolean delete(int index) который будет удалять элемент массива по индексу.
    public boolean delete(int index) {

        if (index >= this.storage.length) {
            return false;
        }

        for (int i = index; i < this.storage.length - 1; i++) {
            T temp = storage[i];
            storage[i] = storage[i + 1];
            storage[i + 1] = temp;
        }
        storage = Arrays.copyOfRange(storage,0,this.storage.length - 1);

        return true;
    }

    //8. Добавить метод boolean delete(E item) который будет удалять элемент массива по элементу.
    public boolean delete(T item) {

        int index = -1;

        for (int i = 0; i < this.storage.length; i++) {
            if (Objects.equals(this.storage[i],item)) {
                index = i;
                break;
            }
        }

        return index != -1 && delete(index);
    }

    //9. В данном классе должен быть НЕ СТАТИЧЕСКИЙ метод void sort(Comparator<.......> comparator).
    //  Данный метод должен отсортировать текущий контейнер используя реализацию
    //  сравнения из ПЕРЕДАННОГО объекта интерфейса Comparator.
    public void sort(Comparator<T> comparator) {
        Arrays.sort(storage,comparator);
    }

    //10. Переопределить метод toString() в классе и выводить содержимое data без ячеек в которых хранится null.
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (T t : storage) {
            if (t == null) {
                continue;
            }
            sb.append(t.toString()).append(", ");
        }

        sb.append("]");

        return sb.toString().replaceAll(", ]","]");
    }

    //11. В даном классе должен быть СТАТИЧЕСКИЙ метод void sort(DataContainer<.............> container)
    //    который будет принимать объект DataContainer с дженериком extends Comparable.
    //    Данный метод будет сортировать элементы в ПЕРЕДАННОМ объекте DataContainer
    //    используя реализацию сравнения вызываемый у хранимых объектов.
    public static <T extends Comparable<T>> void sort(DataContainer<T> container) {

        T[] array = container.getItems();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j].compareTo(array[j - 1]) < 0) {
                    T temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

    }


    //12.** В данном классе должен быть СТАТИЧЕСКИЙ метод void sort(DataContainer<.............> container,
    //   Comparator<.......> comparator) который будет принимать объект Data Container
    //   и реализацию интерфейса Comparator. Данный метод будет сортировать элементы в
    //   ПЕРЕДАННОМ объекте DataContainer используя реализацию сравнения из ПЕРЕДАННОГО объекта интерфейса Comparator.
    public static <T> void sort(DataContainer<T> container,Comparator<T> comparator) {
        T[] array = container.getItems();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (comparator.compare(array[j],array[j - 1]) < 0) {
                    T temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

    }

}
