package fundamentals.calculators.task89;

import fundamentals.calculators.task1.Calculator;

public class CalculatorWithCounter implements Calculator {

        /*
        *8. Создать класс CalculatorWithCounter, все методы в данном классе НЕ статические.
        *   У данного класса должно быть три конструктора (или один если сможете,
        *   это ещё не изучено https://refactoring.guru/ru/design-patterns/decorator)
        *   один принимающий в себя CalculatorWithOperator, второй CalculatorWithMathCopy,
        *   третий CalculatorWithMathExtends.
        *   Данные конструкторы должны сохранять переданные калькуляторы в приватные поля класса
        *   для дальнейшего их использования.
        *   Он также имеет 7 методов как и другие калькуляторы + 1 метод getCountOperation()
        *   который должен вернуть значение внутреннего счётчика.
        *   В реализации методов должен быть вызван один из объектов переданный в констукторr то он должен вызвать метод plus
         *   у объекта CalculatorWithOperator или у объекта CalculatorWithMathCopy
         *   или у объекта  CalculatorWithMathExtends (смотря что передали в конструктор)
        *   при создании объекта CalculatorWithCounter, и вызвать соответсвующий метод у них.
        *   К примеру. Если вызывают метод plus у CalculatorWithCounte
        *   и увеличить значение внутреннего счётчика операций.
        * 9. Повторить пункт 2 с классом CalculatorWithCounter (помним что у нас нет дефолтного констуктора).
        *   В конце программы необходимо вывести в консоль инфомацию возвращаему методом getCountOperation().
        */
    private final Calculator calculator;
    private int countOperation;

    public CalculatorWithCounter(Calculator calculator) {
        this.calculator = calculator;
        countOperation = 0;
    }

    @Override
    public double add(double a, double b) {
        countOperation++;
        return calculator.add(a,b);
    }

    @Override
    public double sub(double a, double b) {
        countOperation++;
        return calculator.sub(a,b);
    }

    @Override
    public double multiply(double a, double b) {
        countOperation++;
        return calculator.multiply(a,b);
    }

    @Override
    public double div(double a, double b) {
        countOperation++;
        return calculator.div(a,b);
    }

    @Override
    public double pow(double a, int index) {
        countOperation++;
        return calculator.pow(a,index);
    }

    @Override
    public double abs(double a) {
        countOperation++;
        return calculator.abs(a);
    }

    @Override
    public double root(double a, int b) {
        countOperation++;
        return calculator.root(a,b);
    }

    public int getCountOperation() {
        return countOperation;
    }
}
