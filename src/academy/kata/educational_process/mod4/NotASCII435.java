package academy.kata.educational_process.mod4;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class NotASCII435 {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("D:/Избранное на 2Tb/Курсы, обучение на курсах, поиск работы/IT/Java/KATA Academy/Процесс обучения с 09.03.2023/Модуль 4/test_4_3_5.txt");
        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);
        writer.write("Щ");
        writer.flush();
    }
}
