package academy.kata.educational_process.mod4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 * Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в тексте вещественных
 * чисел с точностью до шестого знака после запятой. Числом считается последовательность символов,
 * отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.
 *
 * На этот раз вам надо написать программу полностью, т.е. объявить публичный класс с именем ParseDouble437 и точку входа в
 * программу — метод main. И добавить все необходимые импорты
 */
public class ParseDouble437 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //new Scanner("123 4 555");
        double sum = 0.0;

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
//                sum += Double.parseDouble(scanner.next());
            } else {
                scanner.next();
            }
        }
        System.out.printf("%.6f", sum);
    }
}