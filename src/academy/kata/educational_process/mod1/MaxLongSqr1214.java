package academy.kata.educational_process.mod1;

import java.math.BigInteger;

/**
 * Реализовать метод, который выведет на экран квадрат максимального значения, которое может содержаться в переменной long.
 * Чтобы это значение уместилось, необходимо использовать класс BigInteger
 */
public class MaxLongSqr1214 {
    public static void maxLongSqr() {
        //Твой код тут

        System.out.println("\nКвадрат от  maxLong: ");

        BigInteger resultE = BigInteger.valueOf(Long.MAX_VALUE).pow(2);
        BigInteger result2 = BigInteger.valueOf(Long.MAX_VALUE).multiply(BigInteger.valueOf(Long.MAX_VALUE));


        System.out.println(BigInteger.valueOf(Long.MAX_VALUE).pow(2));


        System.out.println("Квадрат:    " + resultE);
        System.out.println("Умножение:  " + result2);

//    System.out.print(result);
    }

    public static void main(String[] args){
        maxLongSqr();
    }
}
