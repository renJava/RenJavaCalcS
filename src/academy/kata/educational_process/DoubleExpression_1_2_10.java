package academy.kata.educational_process;

/**
 * Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c ?
 * Допустимая погрешность – 0.0001 (1E-4) doubleExpression
 */
public class DoubleExpression_1_2_10 {
    public static boolean doubleExpression(double a, double b, double c) {
        return (Math.abs(c-(a + b))) < 1E-4;
    }

    public static void main(String[] args) {
        System.out.println("\nПроверка точности: " + doubleExpression(1.22, 2.33, 3.55));
        System.out.println(0x0bp3);
    }
}
