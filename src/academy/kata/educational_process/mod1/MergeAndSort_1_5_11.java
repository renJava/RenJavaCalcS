package academy.kata.educational_process.mod1;

import java.util.Arrays;

public class MergeAndSort_1_5_11 {
    public static int[] mergeAndSort(int[] firstArray, int[] secondArray) {
        //Твой код тут
        int firstArrayL = firstArray.length;
        int secondArrayL = secondArray.length;
        if (firstArrayL == 0 && secondArrayL == 0) {
            return new int[0];
        }

        int[] resultArray = Arrays.copyOf(firstArray, firstArrayL + secondArrayL);

        System.arraycopy(secondArray, 0, resultArray, firstArrayL, secondArrayL);
        Arrays.sort(resultArray);

        return resultArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {11, 13, 15, 21, 29, 11, 23, 18, 20};        // 9 элементов
        int[] arr2 = {17, 12, 51, 17, 99, 1, 6, 14, 3, 19};       // 10 элементов
        System.out.println("\n\nИтоговый диапазон: ");
        System.out.println(Arrays.toString(mergeAndSort(arr1, arr2)));
    }
}
