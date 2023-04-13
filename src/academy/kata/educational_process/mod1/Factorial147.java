package academy.kata.educational_process.mod1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Реализуйте метод factorial, вычисляющий факториал заданного натурального числа.
 */
public class Factorial147 {
    public static BigInteger factorial(int value) {
//Твой код здесь
        if (value <= 0) {
            System.err.println("\nОшибка!!! Аргумент факториала - положительное целое\n");
            System.exit(0);
        }
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= value; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static void main(String[] args) {
        System.out.print("\nПрямое вычисление факториала!\n" + "Введите аргумент факториала: ");
        Scanner scanner = new Scanner(System.in);
        int mainValue = scanner.nextInt();
        System.out.println("\n\nЗначение факториала " + mainValue + ": " + factorial(mainValue));
    }
}
