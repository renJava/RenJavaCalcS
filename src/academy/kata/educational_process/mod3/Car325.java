package academy.kata.educational_process.mod3;

/**
 * Создайте статический класс Car, чтобы объекты этого типа можно было использовать в try-with-resources.
 * Метод close() должен выводить на экран фразу "Машина закрывается...".
 * Try должен ловить все непроверяемые исключения и игнорировать их.
 * В методе main в блоке try вызови метод drive(). Метод drive должен выводить на экран сообщение "Машина поехала."
 *
 * Требования:
 * 1. Решение должно содержать статический класс Car.
 * 2. Решение должно содержать метод main.
 * 3. В решение должен использоваться try с ресурсами.
 */
public class Car325 {

    //Твой код здесь
    public static class Car implements AutoCloseable {
        //Твой код здесь
        @Override
        public void close() throws Exception {
            System.out.println("Машина закрывается...");
        }

        public void drive() {
            System.out.println("Машина поехала.");
        }
    }

    public static void main(String... args) { // Выброс исключения, если машина не закрылась или, вероятно, ещё и не поехала
        //Твой код здесь
        try (Car car = new Car()) {
            car.drive();
        } catch (Exception e) {}
    }
}

// Ловим все непроверяемые исключения и игнорируем их
