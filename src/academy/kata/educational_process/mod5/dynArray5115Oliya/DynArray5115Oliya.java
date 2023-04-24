package academy.kata.educational_process.mod5.dynArray5115Oliya;

import java.util.Arrays;

/**
 * Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение. Создайте класс DynamicArray, который
 * хранит в себе массив, и имеет методы для добавления void add(T el), void remove(int index) удаления и извлечения
 * T get(int index) из него элементов, при переполнении текущего массива, должен создаваться новый, большего размера.
 * <p>
 * Для возможности работы с различными классами DynamicArray должен быть дженериком. Для решения задачи можно
 * воспользоваться методами из класса java.util.Arrays.
 * Импорт этого класса уже объявлен в тестирующей системе. Добавлять его явно не нужно
 * <p>
 * Требования:
 * 1. должен быть класс public static class DynamicArray
 * 2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
 * 3. В случае подбора некорректного индекса ожидается, что метод get выбросит ArrayIndexOutOfBoundsException
 * 4. класс DynamicArray должен  иметь публичный конструктор по умолчанию
 * 5. работа методов должна соответствовать условию
 */

public class DynArray5115Oliya {
    public static class DynamicArray<T> {
        private Object[] array = {};

        public void add(T el) {
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = el;
        }

        public void remove(int index) {
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
            array = Arrays.copyOf(array, array.length - 1);
        }

        public T get(int index) {
            return (T) this.array[index];
        }
    }
}