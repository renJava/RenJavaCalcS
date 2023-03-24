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
        System.out.println("\nВведите день недели по-русски: ");
//        Scanner scanner = new Scanner(System.in);
        String dayWeek = "понедельник";

//        for (Day day: Day.values()) {
//            if (dayWeek == Day.ge) {
//
//            }
//        }

        System.out.print("\nПонедельник? ");
        System.out.print(Day.MONDAY.getRusName() == dayWeek);

        System.out.println("\n\nДень недели: " + dayWeek);

/*
        System.out.println(Day.TUESDAY.getRusName());
        System.out.println(Day.WEDNESDAY.getRusName());
        System.out.println(Day.THURSDAY.getRusName());
        System.out.println(Day.FRIDAY.getRusName());
        System.out.println(Day.SATURDAY.getRusName());
        System.out.println(Day.SUNDAY.getRusName());
*/
    }
}

        enum Day {
            //Твой код здесь
            MONDAY("понедельник", false),
            TUESDAY("вторник", false),
            WEDNESDAY("среда", false),
            THURSDAY("четверг", false),
            FRIDAY("пятница", false),
            SATURDAY("суббота", true),
            SUNDAY("воскресенье", true);

            private final String russianDayName;
            private final boolean weekEndBooleanCons;

            Day(String russianDayName, boolean weekEndBooleanCons) {
                this.russianDayName = russianDayName;
                this.weekEndBooleanCons = weekEndBooleanCons;

            }

            public String getRusName() {
                return russianDayName;
            }

            public boolean isWeekend() {
                String dayWeek;
                System.out.print("Сегодня выходной? ");
                System.out.print(weekEndBooleanCons);
                return weekEndBooleanCons;
            }
        }