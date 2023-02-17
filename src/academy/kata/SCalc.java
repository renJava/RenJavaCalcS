package academy.kata;

import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;

//  "654Ъiёtgh" + "e47и4ergj"     //
//    "YejrgЁ1Ыi7" - "ejrgЁ1"     //
//    "ЫkegjЫ12Йы" - "kegjЫ12"    //
//    "ehjrg12" *   9             //
//    "ehjrg12" *   10             //
//      "1e47и4erg" / 10          //
//      "47игrgЫЁё" / 2          //

//Правильный push

public class SCalc {
    public static final String INPUTERROR = "!!!Некорректный ввод!!!";

    public static void main(String[] args) {
        String expn;
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
            expn = scanner.nextLine(); // Сканируем всю строку с выражением целиком в expn
            validateInOut = isValidate(expn);
            out.println("\n\"" + validateInOut + "\"");
            if (validateInOut.equals(INPUTERROR)) {
                out.println("\nПовторите, пожалуйста, ввод.\n");
            }
        }
        while (validateInOut.equals(INPUTERROR));
    }

    //    Задаем все переменные метода.
    static String isValidate(String exprn) {

//                                      Сложение и вычитание

//     Регулярное выражение для + и - : ^ *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\" *[+,-] *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\" *

        if (exprn.matches(
                "^ *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\" *[+,-] *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\" *")) {

            return (exprn.indexOf('+') > -1) ? PM.sPlus(operand(exprn, 1), (operand(exprn, 2)))
                    : PM.sCut(operand(exprn, 1), (operand(exprn, 2)));
        }

//                                      Умножение и деление

//     Регулярное выражение для * и / : ^ *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\"\s*[*,\/]\s*(?:[1-9]|10) *$

        if (exprn.matches(
                "^ *\"[a-zA-Z_0-9а-яА-ЯёЁ]{1,10}\" *[*,/] *(?:[1-9]|10) *$")) {

            return (exprn.indexOf('*') > -1) ? MD.sMultiple(operand(exprn, 1), operand(exprn, 3))
                    : MD.sDivision(operand(exprn, 1), operand(exprn, 3));
        }
        return INPUTERROR;
    }


    //        Метод возвращает оба операнда
    static String operand(String workingExpression, int choise) {
        String trimExpressionPM = workingExpression.trim();

        String cutToFindQuote = trimExpressionPM.substring(1);
        int quotePosition0 = cutToFindQuote.indexOf('\"');
        int lengthCt = cutToFindQuote.length();

        switch (choise) {
            case 1 -> {return cutToFindQuote.substring(0, quotePosition0);}
            case 2 -> {
                int quotePosition1 = cutToFindQuote.substring(0, lengthCt - 1).lastIndexOf('\"');
                return cutToFindQuote.substring(quotePosition1 + 1, lengthCt - 1);
            }
            default -> {return cutToFindQuote.substring(lengthCt - 2, lengthCt).trim();}
        }
    }

    //            Методы в 2-х классах
    //          Блок сложения и вычитания
    private static class PM {                               //Сложение - конкатенация
        static String sPlus(String a, String b) {
            return a + b;
        }

        static String sCut(String a, String b) {            //Вычитание
//      При Вычетании - вырезаем найденное слово из строки или возвращаем уменьшаемое обратно
            int substringBegin = a.indexOf(b);
            return (substringBegin > -1) ? a.substring(0, substringBegin) +
                    a.substring(substringBegin + b.length()) : a;
        }
    }

    //          Блок умножения и деления
    private static class MD {
        static String sMultiple(String a, String b) {          //Умножение
//      При Умножении - повторяем заданное слово b раз и обрезаем результат после 40-го символа
            String sMultiple = a.repeat(Integer.parseInt(b));
            return (sMultiple.length() <= 40) ? sMultiple : sMultiple.substring(0, 40) + "...";
        }

        static String sDivision(String a, String b) {          //Деление
            int d = Integer.parseInt(b);
            return (a.length() >= d) ? a.substring(0, a.length() / d) : "Делитель больше делимого";
        }
    }
}