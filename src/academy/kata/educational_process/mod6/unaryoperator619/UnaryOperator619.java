package academy.kata.educational_process.mod6.unaryoperator619;

import java.util.function.UnaryOperator;

/**
 * Цель: практика функциональных интерфейсов
 * Задание:
 * Напишите метод с названием sqrt, который возвращает реализацию функционального интерфейса UnaryOperator,
 * который принимает целое число(тип int) и возвращает его квадрат.
 */
public class UnaryOperator619 {
    public UnaryOperator<Integer> sqrt() {
        //Твой код здесь
        return x -> x * x;
    }
/*

    public UnaryOperator<Integer> sqrt() {
        //Твой код здесь
        UnaryOperator<Integer> sqr = x -> x * x;
        return sqr;
    }
*/

}
