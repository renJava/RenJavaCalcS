package academy.kata.educational_process.mod6.main6213_3Egor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Main6213_3Egor {
    public static void main(String[] args) {
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .map(String::toLowerCase)
                .map(w -> w.split("[\\p{Punct}\\s]+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(System.out::println);
    }
}
