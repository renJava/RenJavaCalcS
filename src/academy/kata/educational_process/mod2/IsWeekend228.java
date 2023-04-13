package academy.kata.educational_process.mod2;

import java.util.Scanner;

/**
 * Реализуй три метода:
 * 1. boolean isWeekend(String dayName) - метод принимает строку и отвечает, является ли данная строка выходным днем.
 * Выходным днем являются Sunday и Saturday.
 * 2. int weekendCount(String[] days) - метод принимает массив строк и возвращает количество выходных дней в этом массиве.
 * 3. int weekdayCount(String[] days) - метод принимает массив строк и возвращает количество будних дней в этом массиве.
 */
public class IsWeekend228 {
    static String[] stringWeekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public static boolean isWeekend(String dayName) {
        //Твой код здесь
        if (dayName == null) {
            return false;
        }
        return (dayName.equals(ST) || dayName.equals(SD));
    }
    public static int weekendCount(String[] days) {
        //Твой код здесь
        return (days.length - weekdayCount(days));
    }

    public static int weekdayCount(String[] days) {
        //Твой код здесь
        int workDays = 0;
        for (String work : days) {
            if (!work.equals(ST) && !work.equals(SD)) {
                workDays++;
            }
        }
        return workDays;
    }

    static final String ST = "Saturday";
    static final String SD = "Sunday";

    public static void main(String[] args) {

        System.out.print("\nВведите день недели по-английски с большой буквы: ");
        Scanner scanner = new Scanner(System.in);
        String someWeekday = scanner.nextLine();
//        String someWeekday = null;
        System.out.println("Рабочих дней: " + weekdayCount(stringWeekDays));
        System.out.println("Выходных: " + weekendCount(stringWeekDays));
        System.out.println(someWeekday + " выходной? " + isWeekend(someWeekday));

    }
}
