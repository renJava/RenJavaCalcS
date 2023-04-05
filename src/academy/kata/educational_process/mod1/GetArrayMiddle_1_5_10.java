package academy.kata.educational_process.mod1;

import java.util.Arrays;

/**
 * Дан массив произвольной длины. Необходимо вернуть центральную часть массива, при чем, если массив четной длины,
 * то вернуть массив из двух элементов, если нечетной, то вернуть массив из одного элемента.
 */
public class GetArrayMiddle_1_5_10 {
    public static int[] getArrayMiddle(int[] numbers) {
        //твой код тут
        int numbersL = numbers.length;
        if (numbersL == 0) {
            return numbers;
        }

        int evenOrOdd = numbersL % 2;

        int middleInOrigPos = numbersL / 2 + evenOrOdd - 1;               //Середины в четном и нечетном массиве разные

        return (evenOrOdd == 0) ? (Arrays.copyOfRange(numbers, middleInOrigPos, middleInOrigPos + 2)) :
                (Arrays.copyOfRange(numbers, middleInOrigPos, middleInOrigPos + 1));
    }

    public static void main(String[] args) {
        int[] range = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};      // 15 - 16 элементов
        System.out.println("\n\nИтоговый диапазон: ");
        System.out.println(Arrays.toString(getArrayMiddle(range)));
    }
}

//        int resArrayL = 2 - evenOrOdd;                                    //Середина из одного или 2-х элементов
//        int[] resArray = new int[resArrayL];

//        for (int i = 0; i < resArrayL; i++) {
//            numbers[i] = numbers[middleInOrigPos++];
//        }


