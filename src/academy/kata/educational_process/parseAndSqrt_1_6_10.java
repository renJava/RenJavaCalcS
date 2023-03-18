package academy.kata.educational_process;

import java.util.Scanner;

/**
 * Реализовать метод, который будет принимать целочисленное (long) число в строковом виде (например "14213123"),
 * преобразовывать его в тип long, вычислять из него квадратный корень, и округлять получившееся значение до ближайшего
 * long. Для округления воспользуйтесь классом Math.
 */
public class parseAndSqrt_1_6_10 {
    public static long parseAndSqrt(String number) {
        //Твой код тут
        long variable = Long.parseLong(number);

        return Math.round(Math.sqrt(variable));
    }
    public static void main(String[] args) {
        System.out.print("\nВведите подкоренное квадратного корня: ");
        Scanner scanner = new Scanner(System.in);
        String longVarS = scanner.nextLine();
//        String contropForPalindrom = "Was it a cat I() saw?";
        System.out.println("\nКвадратный корень SQRT? " + parseAndSqrt(longVarS));
    }
}
