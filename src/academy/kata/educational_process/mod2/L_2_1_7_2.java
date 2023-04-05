package academy.kata.educational_process.mod2;

import java.util.Scanner;

public class L_2_1_7_2 {

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

        public static void main(String[] args) {
            System.out.println("\nВведите день недели по-русски маленькими буквами: ");
            String today = new Scanner(System.in).nextLine();

            System.out.println("\n\nДень недели: " + today);
            if (today.equals(Day.SATURDAY.isWeekend()) || (today.equals(Day.SUNDAY.isWeekend()))) {
                System.out.println("Сегодня выходной!" + today);
            } else {
                System.out.println("Сегодня рабочий день");
            }
        }
    }

    enum Day {
        //Твой код здесь
        MONDAY("понедельник"),
        TUESDAY("вторник"),
        WEDNESDAY("среда"),
        THURSDAY("четверг"),
        FRIDAY("пятница"),
        SATURDAY("суббота"),
        SUNDAY("воскресенье");

        private final String russianDayName;

        Day(String russianDayName) {
            this.russianDayName = russianDayName;
        }

        public String getRusName() {
            return russianDayName;
        }

        public boolean isWeekend() {

            return (getRusName() == "суббота") || (getRusName() == "воскресенье");
        }
    }