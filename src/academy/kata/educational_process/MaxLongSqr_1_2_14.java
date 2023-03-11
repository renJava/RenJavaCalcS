package academy.kata.educational_process;

import java.math.BigInteger;

import static java.lang.Math.pow;

/**
 * Реализовать метод, который выведет на экран квадрат максимального значения, которое может содержаться в переменной long.
 * Чтобы это значение уместилось, необходимо использовать класс BigInteger
 */
public class MaxLongSqr_1_2_14 {
    public static void maxLongSqr() {
        //Твой код тут
    long maxLong = Long.MAX_VALUE;
    BigInteger result = BigInteger.valueOf(Long.MAX_VALUE).multiply(BigInteger.valueOf(Long.MAX_VALUE));
    System.out.println("Квадрат от  maxLong: " + result);
    System.out.println("Максимальный положительный long: " + maxLong);
    }

    public static void main(String[] args) {
        maxLongSqr();
    }
}
