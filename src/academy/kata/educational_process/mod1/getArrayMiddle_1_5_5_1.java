package academy.kata.educational_process.mod1;

import java.util.Arrays;

/**
 * Дан массив произвольной длины. Необходимо вернуть центральную часть массива, при чем, если массив четной длины,
 * то вернуть массив из двух элементов, если нечетной, то вернуть массив из одного элемента.
 */
public class getArrayMiddle_1_5_5_1 {
    public static int[] getArrayMiddle(int[] numbers) {
        //твой код тут
        int numbersLength = numbers.length;

        if (numbersLength == 0) {
            return new int[0];
        }
        int division = numbersLength / 2;

        if (numbersLength % 2 != 0) {
            return new int[]{numbers[division]};
        } else {
            return new int[]{numbers[division - 1], numbers[division]};
        }
    }
    public static void main(String[] args) {
        int[] range = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 30, 31, 32};
        System.out.println("\n\nИтоговый диапазон: ");
        System.out.println(Arrays.toString(getArrayMiddle(range)));
    }

}
