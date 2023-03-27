package academy.kata.educational_process.mod2;

/**
 * Есть студенты деятельность которых ограничена учением. Как ты мог заметить, этот класс описывает еще не поступившего
 * на конкретное направление студента.
 * <p>
 * Создай на его основе класс JavaStudent, который будет учиться на направлении Java.
 * Требования:
 * 1. класс JavaStudent должен быть public static
 * 2. класс JavaStudent должен быть наследником Student.
 * 3. класс JavaStudent должен иметь только один публичный контруктор - конструктор без параметров.
 * 4. класс JavaStudent не должен иметь новых методов или переопределять существующие.
 * 5. Метод study() вызванный у объектов JavaStudent должен выводить в консоль сообщение "Я очень занят. Прохожу курс по Java."
 */
public class JavaStudent_2_4_9 {
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

    public static class JavaStudent extends Student {
        JavaStudent() {
            super("Прохожу курс по Java.");
        }
    }

    public static void main(String[] args) {
        JavaStudent javaStudent = new JavaStudent();
        javaStudent.study();
    }
}
