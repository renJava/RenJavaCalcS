package academy.kata.educational_process.mod3;

/**
 * 1. Метод testExp() должен быть публичным и иметь тип возвращаемого значения void.
 * 2. Класс исключения должен иметь модификатор доступа по умолчанию.
 * 3. Метод testExp() расположите вне класса исключения.
 * 4. Имя класса и метода должны быть разделены решеткой
 */
class TestExp315 {
    //Реализуй метод и исключение здесь
    public class MyNewException extends Exception {
            public MyNewException(String message) {
                super(message);
            }
    }

    public void testExp() throws MyNewException {
        throw new MyNewException("\n\nMyNewException: " + getClass());
    }

    public static void main(String[] args) throws MyNewException {
        TestExp315 callTestExp = new TestExp315();
        callTestExp.testExp();
    }
}


/*
    public void testExp() throws MyNewException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        throw new MyNewException("\n\n" + getClass() + "\n#\n" + stackTrace[1] + "\n");
    }
*/
