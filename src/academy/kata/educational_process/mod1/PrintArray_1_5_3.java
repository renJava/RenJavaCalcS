package academy.kata.educational_process.mod1;

/**
 * Реализуйте метод, который будет принимать массив чисел, и выводить его значения в консоль
 * 1,2,3,4,5,5,6,7,7
 */
public class PrintArray_1_5_3 {
    public static void printArray(int[] numbers) {
        //твой код тут
        System.out.print("[");

        int arrForPrintWithBracket = numbers.length - 1;

        if (arrForPrintWithBracket >= 0) {
            for (int i = 0; i < arrForPrintWithBracket; i++) {
                System.out.print(numbers[i] + ", ");
            }
        } else {
            System.out.println("]");
            return;
        }

        System.out.print(numbers[arrForPrintWithBracket] + "]");
    }

    public static void main(String[] args) {
        int[] elements = new int[]{};
        printArray(elements);
    }
}
