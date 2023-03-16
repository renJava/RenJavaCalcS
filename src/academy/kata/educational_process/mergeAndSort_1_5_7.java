package academy.kata.educational_process;

import java.util.Arrays;

public class mergeAndSort_1_5_7 {
    /**
     * Реализовать метод mergeAndSort(int[] firstArr, int[] secondArray),
     * который принимает соединяет и сортирует два произвольных массива чисел
     */
    public static int[] mergeAndSort(int[] firstArray, int[] secondArray) {
        //твой код тут
        int firstArrayL = firstArray.length;
        int secondArrayL = secondArray.length;
        int resultArrL = firstArrayL + secondArrayL;

        int[] resultUnsortAr = new int[resultArrL];

        if (firstArrayL == 0 && secondArrayL == 0) {
            return new int[0];
        }

        int totalCounter = 0;

        for (int i = 0; i < firstArrayL; i++) {
            resultUnsortAr[i] = firstArray[i];
            totalCounter++;
        }

        for (int j : secondArray) {
            resultUnsortAr[totalCounter++] = j;                   //Добавляем правее по возрастанию индекса
        }

        boolean hasNotSorted = false;
        int temp;
        while (!hasNotSorted) {
            hasNotSorted = true;
            for (int i = 0; i < resultUnsortAr.length - 1; i++) {
                if (resultUnsortAr[i] > resultUnsortAr[i + 1]) {
                    hasNotSorted = false;

                    temp = resultUnsortAr[i];
                    resultUnsortAr[i] = resultUnsortAr[i + 1];
                    resultUnsortAr[i + 1] = temp;
                }
            }
        }
        return resultUnsortAr;
    }

    public static void main(String[] args) {
        int[] arr1 = {11, 13, 15, 21, 29, 11, 23, 18, 20};        // 9 элементов
        int[] arr2 = {17, 12, 51, 17, 99, 1, 6, 14, 3, 19};       // 10 элементов
        System.out.println("\n\nИтоговый диапазон: ");
        System.out.println(Arrays.toString(mergeAndSort(arr1, arr2)));
    }

}
