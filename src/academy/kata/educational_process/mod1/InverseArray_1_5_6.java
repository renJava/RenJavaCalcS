package academy.kata.educational_process.mod1;

import java.util.Arrays;

/**
 * Задание: Написать метод, который принимает массив, разворачивает его и возвращает.
 */
public class InverseArray_1_5_6 {
    public static int[] inverseArray(int[] numbers) {
        //твой код тут
        int lengthIn = numbers.length;
        for (int i = 0; i < lengthIn / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[lengthIn - 1 - i];
            numbers[lengthIn - 1 - i] = temp;
        }
        return numbers;
    }
    public static void main(String[] args) {
        int[] range = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27};
        System.out.println();
        System.out.println(Arrays.toString(inverseArray(range)));
    }

}
