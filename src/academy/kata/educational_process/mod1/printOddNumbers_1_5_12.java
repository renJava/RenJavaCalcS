package academy.kata.educational_process.mod1;

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

        boolean moreOneOddComma = false;

        for (int i : arr) {

            if (i % 2 != 0) {

                if (moreOneOddComma == false) {        //Это условие работает только для самого первого нечетного числа
                    System.out.print(i);
                    moreOneOddComma = true;

                } else {
                    System.out.print("," + i);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] range = {-99, -101, -18, 2, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, -15, -16, -17, -18, -19, -20, -21, -22, -23, -24, -25};
        System.out.println("\n\nИтоговый диапазон: \n");
        printOddNumbers(range);

//          Тест 16-ричной системы
        int b = Integer.parseInt("444",16);
        System.out.println("b = " + b);
    }

}