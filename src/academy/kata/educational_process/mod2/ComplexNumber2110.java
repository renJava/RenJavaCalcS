package academy.kata.educational_process.mod2;

/**
 * Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так, чтобы equals() сравнивал экземпляры
 * ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().

 * Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет
 * Класс ComplexNumber должен переопределять public boolean equals(Object o) и public int hashCode()

 * Подсказка 1. Поищите в классе java.lang.Double статический метод, который поможет в решении задачи.
 */
public class ComplexNumber2110 {
    public static class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }
    }
}