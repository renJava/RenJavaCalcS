package academy.kata.educational_process.mod6.take_while625;

import java.util.stream.Stream;

public class TakeWhile {

    public static void main(String[] args) {

        Stream<Integer> numbers = Stream.of(-3, -2, -1, 0, 1, 2, 3, -4, -5);
        numbers.takeWhile(n -> n < 0)
                .forEach(System.out::println);
    }
}
