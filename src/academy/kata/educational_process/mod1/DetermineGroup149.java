package academy.kata.educational_process.mod1;

import java.util.Scanner;

/**
 * В спортивном центре есть три возрастные группы для занятий волейболом
 * 1 - от 7 до 13 лет
 * 2 - от 14 до 17 лет
 * 3 - от 18 до 65 лет.
 *
 *  Напишите публичный нестатичный метод determineGroup который принимает возраст человека и возвращает целое число,
 *  которое обозначает номер группы в которую его надо определить, если подходящей группы нет - верните -1.
 */
public class DetermineGroup149 {
    public static int determineGroup(int age) {
        //Твой код здесь

        if (age >= 7 && age <= 13) {
            return 1;
        }

        if (age >= 14 && age <= 17) {
            return 2;
        }

        if (age >= 18 && age <= 65) {
            return 3;
        }

        return -1;
    }
    public static void main(String[] args) {
//        determineGroup object = new determineGroup();
        System.out.print("\nОпределение возрастной группы\n" + "\nВведите возраст: ");
        Scanner scanner = new Scanner(System.in);
        int yourAge = scanner.nextInt();
        System.out.println("\n\nГруппы для возраста: " + yourAge + ", № " + determineGroup(yourAge));
    }

}
