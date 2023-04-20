
        package academy.kata.educational_process.mod5.DynamicArray5115;

import java.util.Arrays;

/**
 *Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение. Создайте класс DynamicArray, который хранит
 * в себе массив, и имеет методы для добавления void add(T el), void remove(int index) удаления и извлечения
 * T get(int index) из него элементов, при переполнении текущего массива, должен создаваться новый, большего размера.
 *
 * Для возможности работы с различными классами DynamicArray должен быть дженериком. Для решения задачи можно
 * воспользоваться методами из класса java.util.Arrays.
 * Импорт этого класса уже объявлен в тестирующей системе. Добавлять его явно не нужно
 *
 * Требования:
 * 1. должен быть класс public static class DynamicArray
 * 2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
 * 3. В случае подбора некорректного индекса ожидается, что метод get выбросит ArrayIndexOutOfBoundsException
 * 4. класс DynamicArray должен  иметь публичный конструктор по умолчанию
 * 5. работа методов должна соответствовать условию
 */
public class DynamicArray5115 {
    public static class DynamicArray<T> {
        private static final int DEFAULT_CAPACITY = 10;
        private Object[] elements;
        private int size;

        public DynamicArray() {
            elements = new Object[DEFAULT_CAPACITY];
        }

        public void add(T el) {
            ensureCapacity(size + 1);
            elements[size++] = el;
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds!");
            }
            return (T) elements[index];
        }

        public void remove(int index) {
            if (index < 0 || index >= size) {
                throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds!");
            }
            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(elements, index + 1, elements, index, numMoved);
            }
            elements[--size] = null;
        }

        private void ensureCapacity(int minCapacity) {
            if (minCapacity - elements.length > 0) {
                int oldCapacity = elements.length;
                int newCapacity = oldCapacity + (oldCapacity >> 1);
                if (newCapacity - minCapacity < 0) {
                    newCapacity = minCapacity;
                }
                elements = Arrays.copyOf(elements, newCapacity);
            }
        }

    }
}