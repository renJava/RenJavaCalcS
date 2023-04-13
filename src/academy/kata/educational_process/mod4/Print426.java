package academy.kata.educational_process.mod4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Напишите метод void print(InputStream inputStream, OutputStream outputStream) который принимает InputStream и
 * OutputStream, считывает все байты из inputStream и записывает в OutputStream только четные.
 */
public class Print426 {
    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        //твой код здесь
        int intByte;
        while ((intByte = inputStream.read()) != -1) {
            if (intByte % 2 == 0) {
                outputStream.write(intByte);
            }
        }
        inputStream.close();
        outputStream.close();
    }

}
