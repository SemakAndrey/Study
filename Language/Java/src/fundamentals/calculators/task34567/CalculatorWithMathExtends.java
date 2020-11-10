package fundamentals.calculators.task34567;

import fundamentals.calculators.task1.CalculatorWithOperator;

public class CalculatorWithMathExtends extends CalculatorWithOperator {
    /*
     * 3. Создать класс CalculatorWithMathCopy (скопировать базовые математические операции из CalculatorWithOperator)
     * и CalculatorWithMathExtends (унаследовать базовые математические операции из CalculatorWithOperator).
     * Изучить библиотеку (класс) Math из jdk. (https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)
     * 6. В классе CalculatorWithMathExtends должны присутствовать 4 метода (деления, умножение, вычитание, сложение)
     *  данные методы нужно наследовать из класса CalculatorWithOperator.
     *  В методах (Возведение в степень, Модуль числа, Корень из числа) требуется переопределить
     * и можно использовать только вызовы  методов библиотеки Math, все методы в данном классе НЕ статические
     * 7. Повторить пункт 2 с классом CalculatorWithMathExtends
     */

    @Override
    public double pow(double a, int b) {
        return Math.pow(a,b);
    }

    @Override
    public double abs(double a) {
        return Math.abs(a);
    }

    @Override
    public double root(double a, int b) {
        return Math.exp(Math.log(a)/b);
    }
}
