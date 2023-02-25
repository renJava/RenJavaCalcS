package academy.kata.scalc;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

//  "654Ъiё~+h" + "e47#@&+gj"     //             //   "5/*ё~gh" + "/*"     //
//    "$Yj@rgЁ1Ыi" - "^ej%rgЁ1"   //             //    "" - "^ej%rgЁ1"     //
//    "Yej!~Ё 2Ыы" - "ej!~Ё 2"    //
//    "&(jrg&)" *   10            //             //    ""    *   9         //
public class SCalc {
    static final String INPUT_ERROR = "!!!Некорректный ввод!!!";
    public static void main(String[] args) {
        String expression;
        String validateIn;
        do {
            Scanner scanner = new Scanner(in);
            String announcement = """

                        Правила ввода:
                                                    
                    Вводите строчные операнды (не более 10 символов каждый). После пробелов и табуляций начинайте ввод
                    операнда строго с двойных кавычек. Количество пробелов и табуляций до, после, между, внутри
                    операндов и операторов не лимитируется.
                    1-й операнд - всегда строчный - любая последовательность символов, c пробелами, кроме управляющего
                    символа см. в скобках: (") и не более 10 символов между кавычками.
                    Например: "e47#@+*/-~"
                    2-й операнд, как первый, но только при сложении и вычитании (+,-) и также обернут в кавычки.
                    Например: "$Yj@rgЁ1Ыi".

                    При умножении и делении (*,/) второй операнд - натуральное число <=10 - БЕЗ КАВЫЧЕК!!!.
                                        
                    При ошибке в выражении будет выполнен повторный цикл ввода!!!:
                                        
                                          """;
            out.println(announcement);
            expression = scanner.nextLine();
            validateIn = isValidate(expression);
            out.println("\n\"" + validateIn + "\"");
            if (validateIn.equals(INPUT_ERROR)) {
                out.println("\nПовторите, пожалуйста, ввод.");
            }
        }
        while (validateIn.equals(INPUT_ERROR));
    }

    static String isValidate(String expression) {          //Проверка корректности ввода
//     Регулярное выражение для + и -   : *\"[a-zA-Z_0-9а-яА-ЯёЁ]{0,10}\" *[+,-] *\"[a-zA-Z_0-9а-яА-ЯёЁ]{0,10}\" *
//   :^ *\"[^\"]{0,10}\" *[+,-] *\"[^\"]{0,10}\" *"    :^[ \t]*"[^"]{0,10}"[ \t]*[+,-][ \t]*"[^"]{0,10}"[ \t]*
//     Регулярное выражение для * и / : ^ *\"[a-zA-Z_0-9а-яА-ЯёЁ]{0,10}\"\s*[*,\/]\s*(?:[1-9]|10) *$
//    : ^ *"[^"]{0,10}" *[*,/] *(?:[1-9]|10) *$    : ^[ \t]*\"[^\"]{0,10}\"[ |\t]*[*,/][ \т](?:[1-9]|10)[ \t]*$"

        String regexPm = "^[ \t]*\"[^\"]{0,10}\"[ \t]*[+,-][ \t]*\"[^\"]{0,10}\"[ \t]*"; //Регулярка +- в "" <= 10 симв.
        String regexMd = "^[ \t]*\"[^\"]{0,10}\"[ \t]*[*,/][ \t]*(?:[1-9]|10)[ \t]*$";   //Регулярка */ в "" <= 10 симв.

        if (expression.matches(regexPm) || (expression.matches(regexMd))) {

            String[] cutEx = fullTrim(expression);
            String operator = cutEx[3];

            return switch (operator) {
                case "+" -> Pm.sAdd(cutEx[1], cutEx[2]);                case "-" -> Pm.sSubtract(cutEx[1], cutEx[2]);
                case "*" -> Md.sMultiply(cutEx[1], cutEx[2]);           default -> Md.sDivide(cutEx[1], cutEx[2]);
            };
        }
        return INPUT_ERROR;
    }

    //    Вырезать и вернуть операнды и оператор
    private static String[] fullTrim(String workExpression) {
        String[] trimEx = new String[4];
        trimEx[0] = workExpression.trim().substring(1);         //Отбрасываем боковые пробелы и первую кавычку
        int lengthT = trimEx[0].length();
        int quote1 = trimEx[0].indexOf("\"");
        trimEx[1] = trimEx[0].substring(0, quote1);                                      //Первый операнд
        int quoteLast = trimEx[0].lastIndexOf("\"");
        int quote2 = trimEx[0].indexOf("\"", quote1+1);
        if (quote1 != quoteLast) {
            trimEx[2] = trimEx[0].substring(quote2+1, lengthT-1);                        //Второй операнд
            trimEx[3] = trimEx[0].substring(quote1+1, quote2-1).trim();                  //Оператор
        } else {
            String operatorAndInt = trimEx[0].substring(quote1+1, lengthT).trim();       //Поле оператора с числом/
            trimEx[3] = String.valueOf(operatorAndInt.charAt(0));                        //Чистый оператор * или /
            trimEx[2] = operatorAndInt.substring(1).trim();                     //Числовой оператор
        }
        return trimEx;
    }

    //            В 2-х классах по 2 метода
    //          Блок сложения и вычитания
    private static class Pm {                                 //Сложение - конкатенация
        static String sAdd(String a, String b) {
            return a + b;
        }

        static String sSubtract(String a, String b) {         //Вычитание
//      При Вычетании - вырезаем найденное слово из строки или возвращаем уменьшаемое обратно
            int substringBegin = a.indexOf(b);
            return (substringBegin > -1) ? a.substring(0, substringBegin) +
                    a.substring(substringBegin + b.length()) : a;
        }
    }
    //          Блок умножения и деления
    private static class Md {
        static String sMultiply(String a, String b) {         //Умножение
//      При Умножении - повторяем заданное слово b раз и обрезаем результат после 40-го символа
            String sMultiple = a.repeat(Integer.parseInt(b));
            return (sMultiple.length() <= 40) ? sMultiple : sMultiple.substring(0, 40) + "...";
        }

        static String sDivide(String a, String b) {           //Деление
            int d = Integer.parseInt(b);
            return (a.length() >= d) ? a.substring(0, a.length() / d) : "Делитель больше делимого";
        }
    }
}