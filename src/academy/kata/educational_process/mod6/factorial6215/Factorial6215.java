package academy.kata.educational_process.mod6.factorial6215;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/**
 * Релизуйте метод, вычисляющий факториал, с помощью Stream API.
 * В тестовую систему ипортирован весь пакет java.util.stream
 */
public class Factorial6215 {
    public static BigInteger factorial(int value) {
        // Твой код здесь
        return IntStream.rangeClosed(1, value)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }


    public static void main(String[] args) {
        System.out.print("\nПрямое вычисление факториала!\n" + "Введите аргумент факториала: ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        BigInteger fact = BigInteger.ONE;
        if (value < 0) {
            System.err.println("\nОшибка!!! Аргумент факториала - положительное целое\n");
        } else if (value == 0) {
            System.out.println("\n\nЗначение факториала: 1");
        }
        System.out.println("\n\nЗначение факториала " + value + ": " + factorial(value));
    }
}
