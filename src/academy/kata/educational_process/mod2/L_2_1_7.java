package academy.kata.educational_process.mod2;

import java.util.Scanner;

/**
 * MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
 * <p>
 * Так же, в этом Enum должны быть релизованы два метода:
 * <p>
 * 1. public boolean isWeekend() - метод, отвечающий на вопрос, является ли конкретный элемент - выходным днем.
 * (выходным днем являются только суббота и воскресенье)
 * <p>
 * 2. public String getRusName() - метод, возвращающий русское название дня недели
 * <p>
 * <p>
 * 1. public boolean isWeekend() - метод, отвечающий на вопрос, является ли конкретный элемент - выходным днем.
 * (выходным днем являются только суббота и воскресенье). Метод isWeekend возвращает boolean
 * <p>
 * 2. public String getRusName() - метод, возвращающий русское название дня недели
 * метод getRusName возвращает String
 */

public class L_2_1_7 {

    public static void main(String[] args) {
        System.out.println("\nВведите день недели по-русски маленькими буквами: ");
        String today = new Scanner(System.in).nextLine();

        System.out.println("\n\nДень недели: " + today);
        if (today.equals(Day1.SATURDAY.getRusName()) || (today.equals(Day1.SUNDAY.getRusName()))) {
            System.out.println("Сегодня выходной!" + today);
        } else {
            System.out.println("Сегодня рабочий день: " + today);
        }
    }
}

        enum Day1 {
            //Твой код здесь
            MONDAY("понедельник", false),
            TUESDAY("вторник", false),
            WEDNESDAY("среда", false),
            THURSDAY("четверг", false),
            FRIDAY("пятница", false),
            SATURDAY("суббота", true),
            SUNDAY("воскресенье", true);

            private final String russianDayName;
            private final boolean weekendBoolean;

            Day1(String russianDayName, boolean weekendBoolean) {
                this.russianDayName = russianDayName;
                this.weekendBoolean = weekendBoolean;

            }

            public String getRusName() {
                return russianDayName;
            }

            public boolean isWeekend() {
                return weekendBoolean;
            }
        }