package academy.kata.educational_process.mod4;

import java.io.IOException;
import java.io.InputStream;

/**
 * Напишите метод int sumOfStream(InputStream inputStream), который принимает InputStream и возвращает сумму
 * всех его элементов.
 */
public class SumOfStream_4_2_5 {
    public int sumOfStream(InputStream inputStream) throws IOException {
        //твой код здесь
        int sum = 0;
        int intByte;
        while ((intByte = inputStream.read()) != -1) {
            sum += (byte) intByte;
        }
        return sum;
    }

}
