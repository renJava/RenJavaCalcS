package academy.kata.educational_process;

/**
 * Реализовать метод calcCircleRaduis(double area), который вычисляет радиус окружности по заданной площади и выводит его
 * на экран. Точность - 3 знака после запятой.
 * Для указания количества знаков после запятой используйте метод для форматированного вывода System.out.printf
 * метод должен быть public static
 * сигнатура метода calcCircleRaduis(double area)
 * выводить на экран число с тремя знаками после запятой
 */
public class CircleRadius_1_2_13 {
    public static void calcCircleRadius(double area) {
        //Твой код тут
        final double Pi = 3.1415926536;
        area = 6;
        double r = Math.sqrt(area / Pi);
        System.out.printf("\nРадиус круга: %s" + "%-5.3f", r);
    }

}
