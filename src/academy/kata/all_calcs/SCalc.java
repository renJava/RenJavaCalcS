package academy.kata.all_calcs;

/**
*       Строковый калькулятор до 10 символов включ. (+-/*), принимающий числа только в качестве 2-го операнда (<= 10)
*             и только при умножении и делении. В остальном операнды - строковые, строго в кавычках.
*/

import java.util.Scanner;

import static java.lang.System.*;

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
                    Вводите строчные операнды (не более 10 символов каждый). После начальных пробелов и табуляций
                    начинайте ввод операнда строго с двойных кавычек. Количество пробелов и табуляций до, после, между,
                    внутри операндов и операторов не лимитируется.
                                        
                    1-й операнд - всегда строчный - любая последовательность символов, c пробелами, кроме управляющего
                    символа см. в скобках: (") и не более 10 символов между кавычками.
                    Например: "e47#@+*/-~"
                    
                    2-й операнд, как первый, но только при сложении и вычитании (+,-) и также обернут в кавычки.
                    Например: "$Yj@rgЁ1Ыi".
                    При умножении и делении (*,/) 2-й операнд - натуральное число <=10 - БЕЗ КАВЫЧЕК!!!.
                                        
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

        final String reOperandS = "[ \t]*\"[^\"]{0,10}\"[ \t]*"; //Любой набор до 10-ти сим. в "", в пробелах и Tab
        final String reOperatorGroupPm = "[+-]";
        final String reOperatorGroupMd = "[*/]";
        final String reOperandInt = "[ \t]*(?:[1-9]|10)[ \t]*$"; //Цифра [1-10] вокруг пробелы и Tabs

        final String regexCompositePm = reOperandS + reOperatorGroupPm + reOperandS;     //Регулярка +- в "" <= 10 симв.
        final String regexCompositeMd = reOperandS + reOperatorGroupMd + reOperandInt;   //Регулярка */ в "" <= 10 симв.

        if (expression.matches(regexCompositePm) || (expression.matches(regexCompositeMd))) {

            String[] cutEx = fullTrim(expression);
            String operator = cutEx[0];

            return switch (operator) {
                case "+" -> Pm.sAdd(cutEx[1], cutEx[2]);
                case "-" -> Pm.sSubtract(cutEx[1], cutEx[2]);
                case "*" -> Md.sMultiply(cutEx[1], cutEx[2]);
                default -> Md.sDivide(cutEx[1], cutEx[2]);
            };
        }
        return INPUT_ERROR;
    }

    //    Вырезать и вернуть операнды и оператор
    private static String[] fullTrim(String workExpression) {
        String[] trimEx = new String[3];
        String localTrim = workExpression.trim().substring(1);  //Отбрасываем боковые пробелы и первую кавычку
        int lengthT = localTrim.length();
        int quote2 = localTrim.indexOf("\"");
        trimEx[1] = localTrim.substring(0, quote2);                                   //1-й строковый операнд
        int quoteLast = localTrim.lastIndexOf("\"");
        int quote3 = localTrim.indexOf("\"", quote2 + 1);
        if (quote2 != quoteLast) {
            trimEx[2] = localTrim.substring(quote3 + 1, lengthT - 1);                 //2-й строковый операнд
            trimEx[0] = localTrim.substring(quote2 + 1, quote3).trim();           //Чистый оператор
        } else {
            String operatorWithIntS = localTrim.substring(quote2 + 1, lengthT).trim();//Поле оператора с числовым операндом/
            trimEx[0] = String.valueOf(operatorWithIntS.charAt(0));                   //Чистый оператор
            trimEx[2] = operatorWithIntS.substring(1).trim();                //2-й строковый операнд с числом
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
            int substringBeginIn = a.indexOf(b);
            return (substringBeginIn > -1) ? a.substring(0, substringBeginIn) +
                    a.substring(substringBeginIn + b.length()) : a;
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