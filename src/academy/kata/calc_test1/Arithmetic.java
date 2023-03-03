package academy.kata.calc_test1;

public class Arithmetic {                                     //Сложение
        static String sAdd(String a, String b) {              //Сложение
            return String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
        }

        static String sSubtract(String a, String b) {         //Вычитание
            return String.valueOf(Integer.parseInt(a) - Integer.parseInt(b));
        }

        static String sMultiply(String a, String b) {         //Умножение
            return String.valueOf(Integer.parseInt(a) * Integer.parseInt(b));
        }

        static String sDivide(String a, String b) {           //Деление
            return String.valueOf(Integer.parseInt(a) / Integer.parseInt(b));
        }
}
