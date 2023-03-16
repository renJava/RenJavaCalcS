package academy.kata.educational_process;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Дан массив возрастающих чисел. Даны два числа. Задача - написать метод, который из данного массива достанет ту часть,
 * которая лежит между данными числами (включительно).
 */
public class getSubArrayBetween_1_5_4 {
    public static int[] getSubArrayBetween(int[] numbers, int start, int end) {
        //твой код тут

        int arrInputLength = numbers.length;

        if (arrInputLength == 0) {
            return new int[0];
        }

        if ((end >= start) && (start <= numbers[arrInputLength - 1]) && (end >= numbers[0])) {
            int firstCell = 0;
            int lastCell = 0;

            for (int iStart = 0; iStart < arrInputLength; iStart++) {
                if (numbers[iStart] >= start) {
                    firstCell = iStart;                             //Выясняем с какой ячейки начать в исходном массиве
                    break;
                }
            }

            for (int toEnd = firstCell; toEnd < arrInputLength; toEnd++) {
                if (numbers[toEnd] == end) {                        //Если end внутри массива
                    lastCell = toEnd;                               //Номер последней ячейки в исходном массиве
                } else if (numbers[toEnd] > end) {
                    lastCell = toEnd - 1;
                    break;
                }
                if (end > numbers[arrInputLength - 1]) {            //Если end за пределами массива
                    lastCell = arrInputLength - 1;
                }
            }

            int arResLength = lastCell - firstCell + 1;             // + 1 - Длина результирующего массива
            int originCell = firstCell;
            int[] arRes = new int[arResLength];                     //Объявляем результирующий массив

            if (lastCell != firstCell) {
                for (int iResult = 0; iResult < arResLength; iResult++) {  //Наполняем результирующий массив
                    arRes[iResult] = numbers[originCell];
                    originCell++;
                }
            } else if ((numbers[firstCell] == start) || (end > start)) {
                arRes = new int[1];                                        //Объявляем единичный массив
                arRes[0] = numbers[firstCell];
                return arRes;
            } else {
                arRes = new int[0];                                        //Объявляем нулевой массив
            }
            return arRes;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] range = {-10, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31};
        System.out.print("\n\nВведите два числа - края диапазона. \nПервое число: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.print("\nВторое число: ");
        int b = scanner.nextInt();
        System.out.println("\nДиапазон: " + Arrays.toString(getSubArrayBetween(range, a, b)));
    }
}
