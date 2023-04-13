package academy.kata.educational_process.mod2;

/**
 * Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так, чтобы equals() сравнивал экземпляры
 * ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().
 *
 * Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет
 */
public class Solution2110 {
    public static class ComplexNumber {
        private double re;
        private double im;

        public ComplexNumber() {
        }

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


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            ComplexNumber thereIs = (ComplexNumber) o;

            if (Double.compare(thereIs.re, re) != 0) {
                return false;
            }
            return Double.compare(thereIs.im, im) == 0;
        }

        @Override
        public int hashCode() {
            long temp = Double.doubleToLongBits(re);
            int result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(im);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}
