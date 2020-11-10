package fundamentals.calculators.task34567;

import fundamentals.calculators.task1.Calculator;

public class CalculatorWithMathCopy implements Calculator {
    /*
    * 3. Создать класс CalculatorWithMathCopy (скопировать базовые математические операции из CalculatorWithOperator)
    * и CalculatorWithMathExtends (унаследовать базовые математические операции из CalculatorWithOperator).
    * Изучить библиотеку (класс) Math из jdk. (https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)
    * 4. В классе CalculatorWithMathCopy должны присутствовать 4 метода (деления, умножение, вычитание, сложение)
    * данные методы нужно скопировать из класса CalculatorWithOperator.
    * В методах (Возведение в степень, Модуль числа, Корень из числа) можно использовать
    * только вызовы  методов библиотеки Math, все методы в данном классе НЕ статические
    * 5. Повторить пункт 2 с классом CalculatorWithMathCopy
    */


    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        if (Integer.MAX_VALUE / a < b) {
            System.out.println("The result more than Type int max value! The result is Integer.MAX_VALUE");
            return Integer.MAX_VALUE;
        }
        return a * b;
    }

    public double div(double a, double b) {
        if (b == 0) {
            System.out.println("The divider is 0. The result cast to 0");
            return 0;
        }
        return a / b;
    }

    public double pow(double a, int index) {

        return Math.pow(a,index);

    }

    public double abs(double a) {

        return Math.abs(a);

    }

    public double root(double a, int b) {

        return Math.pow(a, 1.0 / b);

    }

}
