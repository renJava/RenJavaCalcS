package academy.kata.educational_process;

/**
 * Напишите метод printOddNumbers, который принимает массив и выводит в консоль только нечетные числа из него,
 * через запятую. Конец вывода должен перевести курсор на новую строку.
 */
public class printOddNumbers_1_5_12 {
    public static void printOddNumbers(int[] arr) {
        //Твой код здесь
        int arrL = arr.length;

        if (arrL == 0) {
            return;
        }

        int moreOneOddComma = 0;

        for (int i : arr) {

            if (i % 2 != 0) {

                if (moreOneOddComma == 0) {
                    System.out.print(i);
                    moreOneOddComma++;

                } else {
                    System.out.print("," + i);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] range = {-99, -101, -18, 2, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, -15, -16, -17, -18, -19, -20, -21, -22, -23, -24, -25, -26};
        System.out.println("\n\nИтоговый диапазон: \n");
        printOddNumbers(range);
    }

}