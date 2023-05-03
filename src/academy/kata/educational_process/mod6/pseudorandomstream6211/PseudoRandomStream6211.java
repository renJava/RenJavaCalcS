package academy.kata.educational_process.mod6.pseudorandomstream6211;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
 *
 * Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
 * Первый элемент последовательности устанавливается равным этому числу.
 * Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn2), где mid — это функция, выделяющая второй,
 * третий и четвертый разряд переданного числа. Например, mid(123456)=345.
 *
 * Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)
 */
public class PseudoRandomStream6211 {
    public static IntStream pseudoRandomStream(int firstVolume) {
        //твой код здесь
        return IntStream.iterate(firstVolume, n -> mid(n * n))
                .map(n -> n % 1000);
    }


    private static int mid(int n) {
        return (n / 10) % 1000;
    }

}
