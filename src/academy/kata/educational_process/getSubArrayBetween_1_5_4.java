package academy.kata.educational_process;

import java.util.Scanner;

/**
 * Дан массив возрастающих чисел. Даны два числа. Задача - написать метод, который из данного массива достанет ту часть,
 * которая лежит между данными числами (включительно).
 */
public class getSubArrayBetween_1_5_4 {
    public static int[] getSubArrayBetween(int[] numbers, int start, int end) {
        //твой код тут

        return numbers;
    }
    public static void main(String[] args) {
        int[] range = {1,3,5,6,9,11,24};
        System.out.print("\nВведите два числа - края диапазона: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Диапазон: " + getSubArrayBetween(range, a, b));
    }

}
