package fundamentals.calculators;

import fundamentals.calculators.task1.Calculator;
import fundamentals.calculators.task1.CalculatorWithOperator;
import fundamentals.calculators.task1011.CalculatorWithMemory;
import fundamentals.calculators.task12.CalculatorStringExpression;
import fundamentals.calculators.task34567.CalculatorWithMathCopy;
import fundamentals.calculators.task34567.CalculatorWithMathExtends;
import fundamentals.calculators.task89.CalculatorWithCounter;

public class Main1 {

    /*
     * 1. Создать класс CalculatorWithOperator, все методы в данном классе НЕ статические.
     * В классе CalculatorWithOperator должны присутствовать
     * 1.1 4 метода (деления, умножение, вычитание, сложение)
     *     каждый из этих методов должен принимать два параметра (определитесь с их типами)
     *     и должны возвращать результать (определиться с возвращаемым типом результата) при помощи ключевого слово return.
     * 1.2 Также должно быть ещё 2-3 метода:
     *     (Возведение в степень дробного положительного числа в целую степень,
     *     Модуль числа, Корень из числа**).
     *     В методах можно использовать оператор + / * -. Использование библиотеки Math ЗАПРЕЩЕНО!.
     * 2. В отдельном классе, создать мэйн метод.
     * Внутри данного метода создать экземпляр класса CalculatorWithOperator сохранив его в переменную.
     * При помощи методов созданного объекта вычислить результат выражения 4.1 + 15 * 7 + (28 / 5) ^ 2.
     * Результат записать в переменную (определить самый подходящий тип переменной).
     * Вывести сохранённый результат в консоль. Внимание, знак "^" обозначает возведение в степень
     * 2.1 Далее сохранённый результат попробовать поделить на 0
     *   (если возникнет ошибка закомментировать и прокоментировать почему)
     * 2.2 Далее сохранённый результат попробовать поделить на 0.0d
     *   (если возникнет ошибка закомментировать и прокоментировать почему)
     */

    public static void main(String[] args) {

        testClasses(new CalculatorWithOperator());
        testClasses(new CalculatorWithMathCopy());
        testClasses(new CalculatorWithMathExtends());

        //test task 8-9
        CalculatorWithCounter calcCounter = new CalculatorWithCounter(new CalculatorWithOperator());
        testClasses(calcCounter);
        System.out.println(calcCounter.getCountOperation());

        //test task 10 - 11
        CalculatorWithMemory calcMemories = new CalculatorWithMemory(new CalculatorWithOperator());
        calcMemories.div(28, 5);
        calcMemories.setLastResultInMemory();

        calcMemories.pow(calcMemories.getMemory(),2);
        calcMemories.setLastResultInMemory();

        calcMemories.add(calcMemories.add(calcMemories.getMemory(),4.1), calcMemories.multiply(15, 7));
        calcMemories.setLastResultInMemory();
        System.out.println(calcMemories.getMemory());
        System.out.println(calcMemories.getCountOperation());

        CalculatorStringExpression calcExp = new CalculatorStringExpression();
        Double result = calcExp.calculateExpression("(PI+3)*2/2^2*|-5|");
        if (!result.isNaN()) {
            System.out.println(result);
        } else {
            System.out.println("Incorrect expression!");
        }

    }

    public static void testClasses(Calculator calc) {

        double valCopy = calc.add(calc.add(4.1, calc.pow(calc.div(28, 5), 2)), calc.multiply(15, 7));
        System.out.println(valCopy);
        System.out.println(valCopy / 0);     //значение val типа double, согласно стандарту  IEEE деление типа с плавающей запятой на 0
        System.out.println(valCopy / 0.0D);  //равно +/- Infinity, для целочисленных типов валится java.lang.ArithmeticException: / by zero

    }


}
