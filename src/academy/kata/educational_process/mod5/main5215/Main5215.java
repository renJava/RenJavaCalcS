package academy.kata.educational_process.mod5.main5215;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
 * затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном
 * порядке в System.out.
 *
 * Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
 *
 * Все import объявлены за вас.
 *
 * Пример ввода: 1 2 3 4 5 6 7 8 9 10
 * Пример вывода: 10 8 6 4 2
 */
public class Main5215 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;
        while (scanner.hasNextInt()) {
            if (count % 2 == 0) {
                scanner.next();
            } else {
                deque.addFirst(scanner.nextInt());
            }
            count++;
        }
        for (Integer el : deque) {
            System.out.print(el + " ");
        }
    }
}
