package academy.kata.educational_process.mod1;

import java.util.Arrays;

/**
 * Реализуйте метод, который будет принимать массив чисел и выводить его значения в консоль c помощью методов
 * класса Arrays
 */
public class PrintArray_1_5_9 {
    public static void printArray(int[] numbers) {
        //твой код тут
        System.out.println(Arrays.toString(numbers));
    }
    public static void main(String[] args) {
        int[] arr1 = {11, 13, 15, 21, 29, 11, 23, 18, 20};        // 9 элементов
        System.out.println("\n\nИтоговый диапазон: \n");
        printArray(arr1);
    }

}
