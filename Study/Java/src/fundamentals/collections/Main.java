package fundamentals.collections;

import fundamentals.collections.entity.Animal;
import fundamentals.collections.entity.Person;
import fundamentals.collections.service.generators.AnimalGenerator;
import fundamentals.collections.service.generators.PersonGenerator;
import fundamentals.collections.test.Tester;

import java.util.*;

public class Main {

    /*
    * Коллекции, компараторы, полиморфизм:
    * 1.Создаём классы для хранения информации об объектах:
    * 	    1.1. Написать класс Person который содержит поля:
	* 	    1.1.1. Строку nick - псевдоним пользователя
	* 	    1.1.2. Строку password - пароль (от 5 до 10 символов)
	*   1.2. Написать класс Animal:
    *       1.2.1. Число age - возраст (от 1 до 15 лет)
    *       1.2.2. Строка nick - кличка
    * 2. Создать компараторы для классов которые сравнивают:
    *    2.1. Длину пароля пользователей
    *    2.2. Длину пароля пользователей и псевдонимы пользователей по алфавиту (Смотрите уточнение в пункте 2.99)
    *    2.3. Возраст животных
    *    2.4. Возраст животных и клички животных по алфавиту (Смотрите уточнение в пункте 2.99)
    *    2.99. Особенность данных сортировок в том что у вас должна получиться сортировка по двум полям, сначала по первому, потом по второму.
    *        К примеру: есть список животных [{age: 10, nick: "Анатолий"}, {age: 10, "Игнат"}, {age: 1, nick: "Люцифер"}, {age: 10, "Ярик"}].
    *        После сортировки должно получиться: [{{age: 1, nick: "Люцифер"}, age: 10, nick: "Анатолий"}, {age: 10, "Игнат"}, {age: 10, "Ярик"}].
    *        Так как сначала сортируется по возрасту в порядке возрастания, а потом в рамках группу (age = 10), сортируется по кличке по возрастанию (по алфавиту).
    *3. Работа с коллекциями. Выполняем действия над экземплярами классов созданных на основания задания 1:
    *    3.0* В идеале можно, используя полимормизм, написать метод под каждый созданный в первом пункте
    *       класс + метод который будет выполнять основную работу над любыми коллекциями.
    *       Например метод который генерирует Person и заполняет ими указанную вами коллекцию указанным
    *       количеством  Person. Получившуюся коллекцию передаём во второй метод который выполняет все остальные прописанные действия.
    *    3.1. При помощи рандома генерируем 1_000_000 (Если компьютер глючит сделать 100_000) разных объектов одного класса. Поля заполняются рандомными данными.
    *    3.2. Заполняем:
    *        3.2.1. LinkedList
    *        3.2.2. ArrayList
    *        3.2.3. HashSet
    *        3.2.4. TreeSet
    *    3.3. Отсортировать коллекции используя компараторы из задания 2.
    *        3.3.1. Сортируем встроенными средствами jdk
    *        3.3.2.* Сортируем собственным методом сортировки
    *    3.4. Замерить время и распечатать консоль: "Операция: ХХХХ. Заняла YYYY мс". Для замера использовать метод из jdk System.currentTimeMillis():
    *       3.4.1. Заполнения коллекции
    *        3.4.2. Итерирования коллекции:
    *            3.4.2.1. При помощи iterator
    *            3.4.2.2. При помощи любого другого способа (не foreach)
    *        3.4.3. Удаления всех элементов коллекции (выбрать один из):
    *            3.4.3.1. При помощи iterator
    *            3.4.3.2. При помощи любого другого способа
    */

    public static void main(String[] args) {

    	int capacity = 100_000;

		Tester<Animal> testAnimal =  new Tester<>(new AnimalGenerator(), capacity);

		System.out.println("ArrayList<Animal>: ");
		testAnimal.run(new ArrayList<>());

		System.out.println("LinkedList<Animal>: ");
		testAnimal.run(new LinkedList<>());

		System.out.println("HashSet<Animal>: ");
		testAnimal.run(new HashSet<>());

		System.out.println("TreeSet<Animal>: ");
		testAnimal.run(new TreeSet<>());

		System.out.println("----------------------------------------------------------------");
		Tester<Person> testPerson=  new Tester<>(new PersonGenerator(), capacity);

		System.out.println("ArrayList<Person>: ");
		testPerson.run(new ArrayList<>());

		System.out.println("LinkedList<Person>: ");
		testPerson.run(new LinkedList<>());

		System.out.println("HashSet<Person>: ");
		testPerson.run(new HashSet<>());

		System.out.println("TreeSet<Person>: ");
		testPerson.run(new TreeSet<>());

    }

}
