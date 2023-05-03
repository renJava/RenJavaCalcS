package academy.kata.educational_process.mod6.find_min_max6212;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
 * <p>
 * Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
 * <p>
 * minMaxConsumer.accept(min, max);
 * Если стрим не содержит элементов, то вызовите:
 * <p>
 * minMaxConsumer.accept(null, null);
 */
public class FindMinMax6212 {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        //Твой код здесь
        stream.collect(Collectors.teeing(Collectors.minBy(order), Collectors.maxBy(order), (min, max) -> {
            minMaxConsumer.accept(min.orElse(null), max.orElse(null));
            return null;
        }));
    }
}