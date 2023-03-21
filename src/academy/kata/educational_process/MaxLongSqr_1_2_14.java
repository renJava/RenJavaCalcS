package academy.kata.educational_process;

import java.math.BigInteger;

import static java.lang.Long.*;
//import static java.lang.Math.pow;

/**
 * Реализовать метод, который выведет на экран квадрат максимального значения, которое может содержаться в переменной long.
 * Чтобы это значение уместилось, необходимо использовать класс BigInteger
 */
public class MaxLongSqr_1_2_14 {
    public static void maxLongSqr() {
        //Твой код тут
//    long maxLong = MAX_VALUE;
//    BigInteger result = BigInteger.valueOf(Long.MAX_VALUE);
//    BigInteger resultS = BigInteger.valueOf(MAX_VALUE);

//    BigInteger result = BigInteger.valueOf(Long.MAX_VALUE);


//    System.out.println("\nМаксимальный положительный long: " + maxLong);
        System.out.println("\nКвадрат от  maxLong: ");

        BigInteger result = BigInteger.valueOf(Long.MAX_VALUE).multiply(BigInteger.valueOf(Long.MAX_VALUE));
        System.out.print(result);

//    System.out.print(result);
    }

    public static void main(String[] args){
        maxLongSqr();
    }
}
