package academy.kata.educational_process.mod3;

/**
 * Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
 *
 * Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший данный
 * утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName()
 * является точкой входа в программу, т.е. его никто не вызывал.
 * При запуске эта программа должна вывести:
 * null
 * org.your.project.Test#main
 */
public class GetCallerClassAndMethodName_3_1_6 {
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
        return (stackTraceElements.length > 2) ? stackTraceElements[0].getClassName() + "#" +
                stackTraceElements[2].getMethodName() : null;
    }


    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }


    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }
}

//        System.out.println("\n\nДлина StackTraceElement: " + stackTraceElements.length);
//        System.out.println("\nStackTraceElement[0]: " + stackTraceElements[0]);
//        System.out.println("\nStackTraceElement[1]: " + stackTraceElements[1]);
//        System.out.println("\nStackTraceElement[2]: " + stackTraceElements[2]);
