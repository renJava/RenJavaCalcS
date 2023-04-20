package academy.kata.educational_process.mod5.getSalesMap5214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 * Магазину нужно сохранять информацию о продажах для каждого сотрудника. Напишите метод Map getSalesMap(Reader reader)
 * который принимает Reader содержащий строки вида:
 * <p>
 * Алексей 3000
 * Дмитрий 9000
 * Антон 3000
 * Алексей 7000
 * Антон 8000
 * Метод должен получить все строки из Readera и заполнить и вернуть карту где ключом будет имя сотрудника, а значением сумма всех его продаж.
 * <p>
 * Пример ввода:
 * <p>
 * <p>
 * Алексей 3000
 * Дмитрий 9000
 * Антон 3000
 * Алексей 7000
 * Антон 8000
 * Пример вывода:
 * {Алексей=[10000], Дмитрий=[9000], Антон=[11000]}
 * <p>
 * Требования:
 * 1. Должен быть метод public static Map<String, Long> getSalesMap(Reader reader)
 * 2. Работа метода getSalesMap должна удовлетворять условию
 */
public class GetSalesMap5214 {

    public static Map<String, Long> getSalesMap(Reader reader) {
        Map<String, Long> salesMap = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                long sales = Long.parseLong(parts[1]);

                if (salesMap.containsKey(name)) {
                    salesMap.put(name, salesMap.get(name) + sales);
                } else {
                    salesMap.put(name, sales);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return salesMap;
    }

}
