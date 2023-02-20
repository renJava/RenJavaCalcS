package academy.kata;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

//  "654Ъiё~gh" + "e47#@&rgj"     //            //   "5/*ё~gh" + "/*"     //
//    "$Yj@rgЁ1Ыi" - "^ej%rgЁ1"     //          //    "" - "^ej%rgЁ1"     //
//    "Yej!~Ё 2Ыы" - "ej!~Ё 2"    //
//    "&(jrg&)" *   10             //            //    ""    *   9         //
//         "<Ёёe2^!`~V" / 10      //            //         "<Ёёe2^+-Vы" / 10      //
//      "47rgЫЁё" /      2           //         //      "00" /      2           //

public class SCalc {
    static final String INPUT_ERROR = "!!!Некорректный ввод!!!";
    public static void main(String[] args) {
        String expression;
        String validateIn;
        do {
            Scanner scanner = new Scanner(in);
            String announcement = """

                        Правила ввода:
                                                    
                    Вводите строчные операнды (не более 10 символов каждый). Начинайте ввод операнда строго с двойных
                    кавычек. Количество пробелов до, после, между, внутри операндов и операторов не лимитруется.
                    1-й операнд - всегда строчный - любая последовательность символов, c пробелами, но только без
                    трех управляющих символов:  " + *  и не более 10 символов между кавычками. Например: "e47#@&rgj~"
                    
                    2-й операнд, как первый, но только при сложении и вычитании (+,-) и также обернут в кавычки,
                    например: "$Yj@rgЁ1Ыi"

                    При умножении и делении (*,/) второй операнд - натуральное число <=10 - БЕЗ КАВЫЧЕК!!!.
                                        
                    При ошибке в выражении будет выполнен повторный цикл ввода!!!:
                                        
                                          """;
            out.println(announcement);
            expression = scanner.nextLine();
            validateIn = isValidate(expression);
            out.println("\n\"" + validateIn + "\"");
            if (validateIn.equals(INPUT_ERROR)) {
                out.println("\nПовторите, пожалуйста, ввод.\n");
            }
        }
        while (validateIn.equals(INPUT_ERROR));
    }

    //    Задаем все переменные метода.
    static String isValidate(String expression) {

//                                      Сложение и вычитание

//     Регулярное выражение для + и - 1 : *\"[a-zA-Z_0-9а-яА-ЯёЁ]{0,10}\" *[+,-] *\"[a-zA-Z_0-9а-яА-ЯёЁ]{0,10}\" *
//                                      :^ *\"[^\"-+/*]{0,10}\" *[+,-] *\"[^\"-+/*]{0,10}" *

        if (expression.matches(
                "^ *\"[^\"+]{0,10}\" *[+,-] *\"[^\"+]{0,10}\" *")) {

            return (expression.indexOf('+') > -1) ?
                    Pm.sAdd(cutOperand(expression, 1), (cutOperand(expression, 2))) :
                    Pm.sSubtract(cutOperand(expression, 1), (cutOperand(expression, 2)));
        }
//                                      Умножение и деление

//     Регулярное выражение для * и / : ^ *\"[a-zA-Z_0-9а-яА-ЯёЁ]{0,10}\"\s*[*,\/]\s*(?:[1-9]|10) *$
//                                    : ^ *\"[^\"]{0,10}\" *[*,/] *(?:[1-9]|10) *$

        if (expression.matches(
                "^ *\"[^\"*]{0,10}\" *[*,/] *(?:[1-9]|10) *$")) {

            return (expression.indexOf('*') > -1) ?
                    Md.sMultiply(cutOperand(expression, 1), cutOperand(expression, 3)) :
                    Md.sDivide(cutOperand(expression, 1), cutOperand(expression, 3));
        }
        return INPUT_ERROR;
    }

    //        Метод в case возвращает все операнды классов
    static String cutOperand(String workingExpression, int pick) {
        String trimExpressionPM = workingExpression.trim();

        String cutToFindQuote = trimExpressionPM.substring(1);
        int quotePosition0 = cutToFindQuote.indexOf('\"');
        int lengthCt = cutToFindQuote.length();

        switch (pick) {
            case 1 -> {return cutToFindQuote.substring(0, quotePosition0);}                 // Первый операнд
            case 2 -> {                                                                     // Второй операнд
                int quotePosition1 = cutToFindQuote.substring(0, lengthCt - 1).lastIndexOf('\"');
                return cutToFindQuote.substring(quotePosition1 + 1, lengthCt - 1);
            }
            default -> {return cutToFindQuote.substring(lengthCt - 2, lengthCt).trim();}    // Числовой операнд
        }
    }
    //            В 2-х классах по 2 метода
    //          Блок сложения и вычитания
    private static class Pm {                                  //Сложение - конкатенация
        static String sAdd(String a, String b) {
            return a + b;
        }

        static String sSubtract(String a, String b) {               //Вычитание
//      При Вычетании - вырезаем найденное слово из строки или возвращаем уменьшаемое обратно
            int substringBegin = a.indexOf(b);
            return (substringBegin > -1) ? a.substring(0, substringBegin) +
                    a.substring(substringBegin + b.length()) : a;
        }
    }
    //          Блок умножения и деления
    private static class Md {
        static String sMultiply(String a, String b) {          //Умножение
//      При Умножении - повторяем заданное слово b раз и обрезаем результат после 40-го символа
            String sMultiple = a.repeat(Integer.parseInt(b));
            return (sMultiple.length() <= 40) ? sMultiple : sMultiple.substring(0, 40) + "...";
        }

        static String sDivide(String a, String b) {          //Деление
            int d = Integer.parseInt(b);
            return (a.length() >= d) ? a.substring(0, a.length() / d) : "Делитель больше делимого";
        }
    }
}