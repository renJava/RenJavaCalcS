package academy.kata.educational_process.mod1;

/**
 * Реализуйте метод, который будет принимать массив чисел, и выводить его значения в консоль
 * 1,2,3,4,5,5,6,7,7
 */
public class PrintArray1531 {
    public static void printArray(int[] numbers) {
        //твой код тут
        System.out.print("Вывод элементов массива: [");

        int arrForPrint = numbers.length - 1;

        for (int i = 0; i < arrForPrint; i++) {
            System.out.print(numbers[i] + ", ");
            if (i == arrForPrint - 1) {
                break;
            }
        }
        System.out.print(numbers[arrForPrint - 1] + "]");
    }

    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3, 4, 5, 5, 6, 7, 7};
        printArray(elements);
    }
}
