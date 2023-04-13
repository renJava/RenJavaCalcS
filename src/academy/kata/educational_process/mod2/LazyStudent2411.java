package academy.kata.educational_process.mod2;

/**
 * Создай на основе класса Student класс LazyStudent, которому лень учится.
 * Требования:
 * 1. класс LazyStudent должен быть public static
 * 2. класс LazyStudent должен быть наследником Student.
 * 3. класс LazyStudent должен иметь только один публичный контруктор - конструктор без параметров.
 * 4. класс LazyStudent должен переопределять метод study.
 * 5. Метод study() вызванный у объектов LazyStudent должен выводить в консоль сообщение "Сегодня не учусь, мне лень."
 */
public class LazyStudent2411 {
    public static class Student {
        protected final String studying; //final

        protected Student(String work) {
            this.studying = work;
        }

        public Student() {
            this.studying = "Прохожу тестовое задание.";
        }

        public void study() {
            System.out.println("Я очень занят. " + studying);
        }
    }

    public static class LazyStudent extends Student {
        @Override
        public void study() {
            System.out.println("Сегодня не учусь, мне лень.");
        }
    }

    public static void main(String[] args) {
        LazyStudent lazyStudent = new LazyStudent();
        lazyStudent.study();
    }
}


