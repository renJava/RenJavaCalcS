package academy.kata.educational_process;

import java.util.Scanner;

/**
 * Метод должен получать из строки число типа int, делить его на 2 и выводить его в консоль,
 * используя System.out.println
 */
public class parseAndPrintNumber_1_6_8 {
    public static void parseAndPrintNumber(String str) {
        System.out.println(Integer.parseInt(str) / 2);
    }

    public static void main(String[] args) {
        System.out.print("\n\nВведите число: ");
        Scanner scanner = new Scanner(System.in);
        String strNumber = scanner.nextLine();
        parseAndPrintNumber(strNumber);
    }
}
