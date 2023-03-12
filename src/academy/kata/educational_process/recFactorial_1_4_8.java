package academy.kata.educational_process;

import java.math.BigInteger;
import java.util.Scanner;

public class recFactorial_1_4_8 {

    public static BigInteger factorial(int value) {
//Твой код здесь
        if (value < 0) {
                System.err.println("\nОшибка!!! Аргумент факториала должен быть >= 0\n");
        }

        if (value == 0) {
            return BigInteger.valueOf(1);
        }

        if (value <= 1) {
            return BigInteger.valueOf(value);
        } else {
            return BigInteger.valueOf(value).multiply(factorial(value - 1));
        }
    }

    public static void main(String[] args) {
        System.out.print("\nРекурсивное вычисление факториала!\n" + "Введите аргумент факториала: ");
        Scanner scanner = new Scanner(System.in);
        int mainValue = scanner.nextInt();
        System.out.println("\n\nЗначение факториала " + mainValue + ": " + factorial(mainValue));
    }

}
