package academy.kata.educational_process.mod5.getSalesMap5214Igor;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

public class GetSalesMap5214Igor {
    public static Map<String, Long> getSalesMap(Reader reader) {
        Map<String, Long> map = new HashMap<>();
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNext()) {
            map.merge(scanner.next(),scanner.nextLong(),(oldVal, newVal) -> oldVal + newVal);
        }
        return map;
    }
}