package fundamentals.calculators.task12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorStringExpression {

    /*
     * 12**. Написать класс CalculatorStringExpression реализующий разбор (парсинг) СТРОКИ с математическим выражением:
     * 12.1 Класс должен понимать операторы: + - \ * ^ ||
     * 12.2 Класс должен понимать ( )
     * 12.3 Класс должен строго учитывать приоритеты в данном выражении
     * 12.4 Класс должен уметь парсить в строке константные значение: PI, E (Экспонента)
     * 12.6 Класс должен контролировать что в строке могут быть только допустие символы (числа, операторы, скобки, константы)
     * 12.7 Класс должен контролировать чтобы выражение было валидным (2 + 2 - хорошо, 2 + - плохо)
     */

    private double res;

    public double calculateExpression(String exp) {

        exp = exp.replaceAll("\\s","").replaceAll("PI", String.valueOf(Math.PI)).replaceAll("E",String.valueOf(Math.E));
        if (!validateExp(exp)) {
            return  Double.NaN;
        }

        this.res = 0;

        while (true) {
            Matcher matcher = Pattern.compile("\\(.+\\)").matcher(exp);
            if (!matcher.find()) {
                break;
            }

            String expLocal = matcher.group();
            this.res = calcLine(expLocal.replaceAll("\\(","").replaceAll("\\)",""));
            exp = exp.replaceAll(getRegex(expLocal),String.valueOf(this.res));
        }
        if (!exp.equals(String.valueOf(this.res))) {
            this.res = calcLine(exp);
        }

        return getRes();
    }

    private double calcLine(String line) {
        double resultLocal = Double.NaN;

        String[] operations = getOperations();

        for(String operation : operations) {
            while (true) {
                Matcher matcher = Pattern.compile("\\|-?[\\d.]+\\|").matcher(line);
                if (matcher.find()) {
                    String subLine = matcher.group();
                    double abs = Math.abs(Integer.parseInt(subLine.replaceAll("\\|","")));
                    line = line.replaceAll(getRegex(subLine),String.valueOf(abs));
                }

                matcher = Pattern.compile("[\\d.]+" + operation + "[\\d.]+").matcher(line);
                if (matcher.find()) {
                    String subLine = matcher.group();

                    //get operator
                    Matcher matcherOpera = Pattern.compile(operation).matcher(subLine);
                    String oper = "";
                    if (matcherOpera.find()) {
                        oper = matcherOpera.group();
                    }

                    double[] numbers = getNumbers(subLine,operation);
                    if (numbers == null) {
                        System.out.println("Incorrect data");
                        return Double.NaN;
                    }
                    resultLocal = calcSimpleExpression(oper,numbers[0],numbers[1]);
                    line = line.replaceAll(getRegex(subLine),String.valueOf(resultLocal));

                } else {
                    break;
                }
            }
        }

        return resultLocal;
    }

    private String getRegex(String line) {
        StringBuilder sb = new StringBuilder();
        for (char ch : line.toCharArray()) {
            if (ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '|' || ch == '(' || ch == ')') {
                sb.append("\\");
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    private double calcSimpleExpression(String operation, double a, double b) {
        switch (operation) {
            case "+" :
                return a + b;
            case "-" :
                return a - b;
            case "*" :
                return a * b;
            case "/"  :
                return a / b;
            case "^" :
                return Math.pow(a, b);
            default :
                return Double.NaN;
        }

    }

    private String[] getOperations() {
        return new String[] {"[\\^]","[\\*\\/]","[\\+\\-]","[\\|]"};
    }

    private double[] getNumbers(String line, String pattern) {

        String[] elements = line.split(pattern);
        if (elements.length != 2) {
            return null;
        }
        double[] result = new double[2];
        for (int i = 0; i < elements.length; i++) {
            result[i] = Double.parseDouble(elements[i]);
        }
        return result;
    }

    private boolean validateExp(String exp) {

        Matcher matcher = Pattern.compile("[(|]*[\\-\\d.PIE|]+([+*\\/^-][|(]*[\\-\\d.PIE|]+[)|]*)+").matcher(exp);
        return matcher.find() && exp.length() == matcher.group().length();

    }

    public double getRes() {
        return res;
    }
}

