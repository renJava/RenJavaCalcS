package academy.kata.educational_process.mod5.DynamicArray5115;

import java.util.Arrays;

public class DynamicArray5115Gokov {
    public static class DynamicArray<T> {
        private T[] arr = (T[]) new Object[10];
        private int size = 0;

        public DynamicArray() {
        }

        public void add(T el) {
            if (size >= arr.length) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
            arr[size++] = el;
        }

        public void remove(int index) {
            System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
            size--;
        }

        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return (T) this.arr[index];
        }
    }
}
