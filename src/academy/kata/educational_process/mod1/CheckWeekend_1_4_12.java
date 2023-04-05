package academy.kata.educational_process.mod1;

import java.util.Scanner;

/**
 * Реализовать метод, который будет принимать строку с названием дня недели, и проверять, является ли этот день
 * выходным. Список дней недели: "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday".
 * Если переданная строка является выходным днем, то возвращать строку:
 * "Ура, выходной!". В других случаях возвращать строку "Надо еще поработать".
 * Решить с использованием тернарного оператора
 */
public class CheckWeekend_1_4_12 {
    public static String checkWeekend(String weekday) {
        //Твой код здесь
        return (weekday.equals("Saturday") || weekday.equals("Sunday")) ? "Ура, выходной!" : "Надо еще поработать";
    }

    public static void main(String[] args) {
        System.out.print("\nВведите день недели по-английски с большой буквы: ");
        Scanner scanner = new Scanner(System.in);
        String dayNumber = scanner.nextLine();
        System.out.println(dayNumber + " выходной? " + checkWeekend(dayNumber));
    }
}
