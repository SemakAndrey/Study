package fundamentals.calculators.task1;

public class CalculatorWithOperator implements Calculator {

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

        double res = 1;

        for (int i = 1; i <= index; i++) {
            res *= a;
        }
        return res;
    }

    public double abs(double a) {
        return a < 0 ? -1 * a : a;
    }

    public double root(double a, int b) {

        double root = a / b;   //начальное приближение корня
        double rn = a;

        while(abs(root - rn) >= 0.001){
            rn = a;
            for(int i = 1; i < b; i++){
                rn = rn / root;
            }
            root = 0.5 * ( rn + root);
        }

        return root;

    }

}
