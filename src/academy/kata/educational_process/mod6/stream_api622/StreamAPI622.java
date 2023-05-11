package academy.kata.educational_process.mod6.stream_api622;

import java.util.*;
import java.util.stream.IntStream;

public class StreamAPI622 {
    public static void main(String[] args) {
        // Создаём хэш-карту
        HashMap hm = new HashMap();

        // Кладём элементы в Map
        hm.put("Зоя", 3434.34);
        hm.put("Марк", 123.22);
        hm.put("Аня", 1378.00);
        hm.put("Маргарита", 99.22);
        hm.put("Михаил", -19.08);

        // Получаем набор элементов
        Set set = hm.entrySet();

        // Отображение элементов
        for (Object o : set) {
            Map.Entry me = (Map.Entry) o;
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();

        // Вносим 1000 на счёт Зои
        double balance = (Double) hm.get("Зоя");
        hm.put("Зоя", balance + 1000);
        System.out.println("Новый баланс Зои: " + hm.get("Зоя"));
    }
}
