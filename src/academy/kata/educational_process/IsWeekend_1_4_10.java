package academy.kata.educational_process;

import java.util.Scanner;

/**
 *Реализовать метод, который будет принимать строку с названием дня недели, и отвечать, является ли этот день выходным.
 *  Список дней недели: "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday".
 *  Если строка не соответствует ни одному дню недели отправлять false.
 */
public class IsWeekend_1_4_10 {
    public static boolean isWeekend(String weekday) {
        //Твой код здесь
        String [] dayOfWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.print("\nВведите номер дня недели: ");
        Scanner scanner = new Scanner(System.in);
        String dayNumber = scanner.nextLine();
        System.out.println("Сегодня выходной? " + isWeekend(dayNumber));

        return switch (dayOfWeek[Integer.parseInt(weekday)]){
            case "Monday" -> false;
            case "Tuesday" -> false;
            case "Wednesday" -> false;
            case "Thursday" -> false;
            case "Friday" -> false;
            case "Saturday" -> true;
            case "Sunday" -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
    }
}
