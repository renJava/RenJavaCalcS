package academy.kata;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

//  "654Ъiёtgh" + "e47и4ergj"     //
//    "YejrgЁ1Ыi7" - "ejrgЁ1"     //
//    "ЫkegjЫ12Йы" - "kegjЫ12"    //
//    "ehjrg12" *   9             //
//    "ehjrg12" *   10             //
//      "1e47и4ergj" / 10          //
//      "47игrgЫЁё" / 2          //


class SCalc {
    static String inputError = "!!!Некорректный ввод!!!";

    public static void main(String[] args) {
        String expression;
        String validateInOut;
        do {
            Scanner scanner = new Scanner(in);
            String announcement = """

                        Правила ввода:
                                                    
                    Вводите строчные операнды (не более 10 символов каждый). Начинайте ввод строго с двойных кавычек.
                    Первый операнд - всегда строчный, не более 10 символов, например, "jbBЪ5678Ёю".
                    Второй операнд, как первый, но только при сложении и вычитании (+,-), а второй операнд - также в кавычках.

                    При умножении и делении (*,/) второй операнд - натуральное число <=10 - БЕЗ КАВЫЧЕК!!!.
                                        
                    При ошибке в выражении будет выполнен повторный цикл ввода!!!:
                                        
                        """;

            out.println(announcement);
            expression = scanner.nextLine(); // Сканируем всю строку с выражением целиком в expression
            validateInOut = isValidate(expression);
            out.println("\n\"" + validateInOut + "\"");
            if (validateInOut.equals(inputError)) {
                out.println("\nПовторите, пожалуйста, ввод.\n");
            }
        }
        while (validateInOut.equals(inputError));
    }

    //    Задаем все переменные метода.
    public static String isValidate(String expression) {

//                                      Сложение и вычитание

//     Регулярное выражение для + и - : ^ *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\" *[+,-] *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\" *

        if (expression.matches(
                "^ *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\" *[+,-] *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\" *")) {

            var trimExpressionPM = expression.trim();

            var cutToFindQuotes = trimExpressionPM.substring(1);
            int lengthCt = cutToFindQuotes.length();

            var quotePosition1 = cutToFindQuotes.substring(0, lengthCt-1).lastIndexOf('\"');
            var bPM = cutToFindQuotes.substring(quotePosition1 + 1, lengthCt - 1);

            return (trimExpressionPM.indexOf('+') > -1) ? PM.sPlus(operand(expression), bPM) :
                    PM.sCut(operand(expression), bPM);
        }

//                                      Умножение и деление

//     Регулярное выражение для * и / : ^ *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\"\s*[*,\/]\s*(?:[1-9]|10) *$

        if (expression.matches(
                "^ *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\" *[*,/] *(?:[1-9]|10) *$")) {

            var trimExpressionMD = expression.trim();

            var cutToFindOneQuote = trimExpressionMD.substring(1);
            var lengthCt = cutToFindOneQuote.length();

            var bMD = Integer.parseInt(cutToFindOneQuote.substring(lengthCt - 2, lengthCt).trim());

            return (trimExpressionMD.indexOf('*') > -1) ? MD.sMultiple(operand(expression), bMD) :
                    MD.sDivision(operand(expression), bMD);
        }

//                Отладка: контроль ввода и промежуточных вычислений:

        return inputError;

    }


//        Метод возвращает первый операнд
    public static String operand(String workingExpression) {
        var trimExpressionPM = workingExpression.trim();

        var cutToFindQuotes = trimExpressionPM.substring(1);
        var quotePosition0 = cutToFindQuotes.indexOf('\"');

        return cutToFindQuotes.substring(0, quotePosition0);
    }


//            Методы в 2-х классах

    private static class PM {                               //Сложение - конкатенация
        static String sPlus(String a, String b) {        //Сложение
            return a + b;
        }
        // При Сложении - Конкатенация строк

        static String sCut(String a, String b) {            //Вычитание
            var substringBegin = a.indexOf(b);
            return (substringBegin > -1) ? a.substring(0, substringBegin) +
                    a.substring(substringBegin + b.length()) : a;
        }
        // При Вычетании - вырезаем найденное слово из строки или возвращаем уменьшаемое обратно
    }

    //          Блок умножения и деления
    private static class MD {
        static String sMultiple(String a, int b) {          //Умножение
            String sMultiple = a.repeat(b);
            return (sMultiple.length() <= 40) ? sMultiple : sMultiple.substring(0, 40) + "...";
        }
        // При Умножении - повторяем заданное слово b раз и обрезаем результат после 40-го символа

        static String sDivision(String a, int b) {          //Деление
            return (a.length() >= b) ? a.substring(0, a.length() / b) : "Делитель больше делимого";
        }
    }
}
