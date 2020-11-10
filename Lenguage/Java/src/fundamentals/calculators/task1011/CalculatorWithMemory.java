package fundamentals.calculators.task1011;

import fundamentals.calculators.task1.Calculator;

public class CalculatorWithMemory implements Calculator{

    /*
    * 10*. Создать CalculatorWithMemory, принципы как и в задании 9, сможете)?.
    *   Данный калькулятор работает как настоящий калькулятор с функцией памяти.
    *   Функция памяти работает через два метода, записать в память результат выполнения последнего вызванного метода,
    *   получить из памяти записанное значение. При получении записи из памяти память стирается,
    *   при записи нового значения память перезаписывается.
    * 11. Большое выражение из 2 задания разделить на мелкие выражения в отдельных сроках
    *   выполнить данные выражения получая из памяти прошлый результат и записывая новый.
    */

    private final Calculator calculator;
    private int countOperation;
    private double valueInMemory;
    private double lastResult;


    public CalculatorWithMemory(Calculator calculator) {
        this.calculator = calculator;
        countOperation = 0;
    }

    @Override
    public double add(double a, double b) {
        countOperation++;
        this.lastResult = calculator.add(a,b);
        return this.lastResult;
    }

    @Override
    public double sub(double a, double b) {
        countOperation++;
        this.lastResult = calculator.sub(a,b);
        return this.lastResult;
    }

    @Override
    public double multiply(double a, double b) {
        countOperation++;
        this.lastResult = calculator.multiply(a,b);
        return this.lastResult;
    }

    @Override
    public double div(double a, double b) {
        countOperation++;
        this.lastResult = calculator.div(a,b);
        return this.lastResult;
    }

    @Override
    public double pow(double a, int index) {
        countOperation++;
        this.lastResult = calculator.pow(a,index);
        return this.lastResult;
    }

    @Override
    public double abs(double a) {
        countOperation++;
        this.lastResult = calculator.abs(a);
        return this.lastResult;
    }

    @Override
    public double root(double a, int b) {
        countOperation++;
        this.lastResult = calculator.root(a,b);
        return this.lastResult;
    }

    public int getCountOperation() {
        return countOperation;
    }

    public double getMemory() {
        return valueInMemory;
    }

    public void setLastResultInMemory() {
        this.valueInMemory = this.lastResult;
    }
}
