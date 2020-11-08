package fundamentals.strings;

import fundamentals.strings.util.ConverterUtil;

public class Main {

    /*
     * Строки. Все методы пишутся в одном классе:
     * 1. Написать метод String toString(int number).
     *         1.1 В данном методе произвести конвертацию переданного числа в число прописью. Числа от - 999 999 999 до 999 999 999
     *         1.2 Пример передали: 223. Получили "Двести двадцать три"
     * 2. Написать метод String toString(double number).
     *         2.1 В данном методе произвести конвертацию переданного числа в число прописью. Выводить до сотых, без округления.
     *         2.2 Пример передали: 223.1599999. Получили "Двести двадцать три целых пятнадцать сотых".
     * 3. Написать метод String toWeek(int day).
     *         3.1 В данном методе посчитать количество прошедших недель по переданному числу дней.
     *         3.2 Пример передали: 5. Получили "0 недель"
     *         3.3 Пример передали: 14. Получили "2 недели"
     *         3.4 Пример передали: 177. Получили "25 недель"
     * 4.* Написать метод String toHoursMinuteSecondMillisecond(long millisecond, boolean shortFormat).
     *         4.1 В данном методе конвертируют переданные миллисекунды в количество часов, минут, секунд и миллисекунд.
     *         4.2 В зависимости от параметра shortFormat возвращать либо короткое написание в формате HH:mm:ss.SSS, где HH - это часы, mm - это минуты, ss - это секунды, SSS - это миллисекунды. Либо полное написание
     *         4.3 Пример передали: 7789001, true. Получили 02:09:49.001 - прошу обратить что в цифрах могут быть ведущие нули: "02", "09"
     *         4.4 Пример передали: 7789001, false. Получили 2 часа 9 минут 49 секунд 1 миллисекунда
     */

    public static void main(String[] args) {

        ConverterUtil converterUtil = new ConverterUtil();
        //1
        System.out.println(converterUtil.getNumberAsText("-56231223"));

        //2
        System.out.println(converterUtil.getNumberAsText("34231223.1234"));

        //3
        System.out.println(converterUtil.toWeek(5));
        System.out.println(converterUtil.toWeek(14));
        System.out.println(converterUtil.toWeek(177));

        //4
        System.out.println(converterUtil.toHoursMinuteSecondMillisecond(7789001, true));
        System.out.println(converterUtil.toHoursMinuteSecondMillisecond(7789001, false));

    }

}
