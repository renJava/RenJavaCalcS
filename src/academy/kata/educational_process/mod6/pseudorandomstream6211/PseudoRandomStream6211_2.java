package academy.kata.educational_process.mod6.pseudorandomstream6211;

import java.util.stream.IntStream;

public class PseudoRandomStream6211_2 {
    public static IntStream pseudoRandomStream(int firstElement) {
        //твой код здесь
        return IntStream.iterate(firstElement, n -> ((n * n) / 10) % 1000);
    }
}
