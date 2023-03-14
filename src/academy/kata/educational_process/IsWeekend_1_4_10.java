package academy.kata.educational_process;

import java.util.Scanner;

/**
 * Реализовать метод, который будет принимать строку с названием дня недели, и отвечать, является ли этот день выходным.
 * Список дней недели: "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday".
 * Если строка не соответствует ни одному дню недели отправлять false.
 */
public class IsWeekend_1_4_10 {
    public static boolean isWeekend(String weekday) {
        //Твой код здесь
        String[] daysOfWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
                "Sunday"};

        String dayOfWeek = "";

        for (String arr : daysOfWeek) {

            if (arr.equals(weekday)) {
                dayOfWeek = weekday;
                break;
            }
        }

        switch (dayOfWeek) {

            case "Saturday", "Sunday": {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("\nВведите день недели по-английски с большой буквы: ");
        Scanner scanner = new Scanner(System.in);
        String dayNumber = scanner.nextLine();
        System.out.println(dayNumber + " выходной? " + isWeekend(dayNumber));
    }
}