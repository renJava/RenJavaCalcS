package academy.kata.educational_process.mod6.factorial6215;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Реализуйте метод, вычисляющий факториал, с помощью Stream API.
 * В тестовую систему импортирован весь пакет java.util.stream
 */
public class Factorial6215 {
    public static BigInteger factorial(int value) {
        // Твой код здесь
        return IntStream.rangeClosed(1, value)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }


    public static void main(String[] args) {
        System.out.print("\nПрямое вычисление факториала!\nВведите аргумент факториала: ");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        if (value < 0) {
            System.err.println("\nОшибка!!! Аргумент факториала целое >=0\n");
        } else {
            System.out.println("\n\nЗначение факториала " + value + ": " + factorial(value));
        }
    }
}
