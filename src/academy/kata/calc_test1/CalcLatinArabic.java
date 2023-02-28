package academy.kata.calcLatinArabic;

import academy.kata.scalc.SCalc;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class calcLAndAr {
    static final String INPUT_ERROR = "!!!Некорректный ввод!!!";

    public static void main(String[] args) {
        String expression;
        String validateIn;
        do {
            Scanner scanner = new Scanner(in);
            String announcement = """

                            Правила ввода:
                    Введите выражение с целыми латинскими или арабскими числами >0, на <=10.
                                        
                    В одной строке одновременно допускаются либо арабские, либо латинские цифры.
                                        
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

        final String reOperandAr = "^[ \t]*(?:[1-9]|10)[ \t]*$"; //Цифра [1-10] вокруг пробелы и Tabs
        final String reOperandL = "^[ \t]*[IVX]{1,8}[ \t]*$"; //Любой набор до 10-ти сим. в "", в пробелах и Tab
        final String reOperators = "[-+*/]";

        final String regexCompositeAr = reOperandAr + reOperators + reOperandL;     //Регулярка +- в "" <= 10 симв.
        final String regexCompositeL = reOperandL + reOperators + reOperandL;   //Регулярка */ в "" <= 10 симв.


        if (expression.matches(regexCompositeAr)) {//|| (expression.matches(regexCompositeL))) {

            String[] cutEx = fullTrim(expression);
            String operator = cutEx[0];

            return switch (operator) {
                case "+" -> SCalc.Pm.sAdd(cutEx[1], cutEx[2]);
                case "-" -> SCalc.Pm.sSubtract(cutEx[1], cutEx[2]);
                case "*" -> SCalc.Md.sMultiply(cutEx[1], cutEx[2]);
                default -> SCalc.Md.sDivide(cutEx[1], cutEx[2]);
            };
        }


        return INPUT_ERROR;
    }

    //    Вырезать и вернуть операнды и оператор
    private static String[] fullTrim(String workExpression) {
        String[] trimEx = new String[3];
        String localTrim = workExpression.trim();                                   //Отбрасываем боковые пробелы
        int lengthT = localTrim.length();
        int quote2 = localTrim.indexOf("[+-*/]");
        trimEx[1] = localTrim.substring(0, quote2);                                   //1-й строковый операнд
        int quoteLast = localTrim.lastIndexOf("\"");
        int quote3 = localTrim.indexOf("\"", quote2 + 1);
        if (quote2 != quoteLast) {
            trimEx[2] = localTrim.substring(quote3 + 1, lengthT - 1);                 //2-й строковый операнд
            trimEx[0] = localTrim.substring(quote2 + 1, quote3 - 1).trim();           //Чистый оператор
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
            return String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
        }

        static String sSubtract(String a, String b) {         //Вычитание
//      При Вычетании - вырезаем найденное слово из строки или возвращаем уменьшаемое обратно
                return Integer.parseInt(a) - Integer.parseInt(b);
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
