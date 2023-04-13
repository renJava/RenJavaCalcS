package academy.kata.educational_process.mod1;


/**
 * Реализовать метод calcCircleRaduis(double area), который вычисляет радиус окружности по заданной площади и выводит его
 * на экран. Точность - 3 знака после запятой.
 * Для указания количества знаков после запятой используйте метод для форматированного вывода System.out.printf
 * метод должен быть public static
 * сигнатура метода calcCircleRaduis(double area)
 * выводить на экран число с тремя знаками после запятой
 */
public class CircleRadius1213 {
    public static void calcCircleRadius(double area) {
        //Твой код тут
//        double r = Math.sqrt(area / Math.PI);
        System.out.printf("%10.3f", Math.sqrt(area / Math.PI));
    }
    public static void main(String[] args) {
//        System.out.print("\n\nВведите площадь круга: ");
//        Scanner scanner = new Scanner(System.in);
//        double s = scanner.nextDouble();
        System.out.println();
        System.out.print("Радиус круга: ");
        calcCircleRadius(6);
        System.out.println();
    }

}
