package academy.kata.calc_test1;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class CalcLatinArabic {
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
            out.println("\nРезультат: " + validateIn);
            if (validateIn.equals(INPUT_ERROR)) {
                out.println("\nПовторите, пожалуйста, ввод.");
            }
        }
        while (validateIn.equals(INPUT_ERROR));
    }

    static String isValidate(String expression) {          //Проверка корректности ввода

        final String beginer = "^";
        final String reOperandAr = "[ \t]*(?:[1-9]|10)[ \t]*"; //Цифра [1-10] вокруг пробелы и Tabs
        final String reOperandL = "[ \t]*[IVX]{1,4}[ \t]*"; //Любой набор до 10-ти сим. в "", в пробелах и Tab
        final String reOperators = "[-+*/]";

        final String regexCompositeAr = beginer + reOperandAr + reOperators + reOperandAr;     //Регулярка +- в "" <= 10 симв.
        final String regexCompositeL = reOperandL + reOperators + reOperandL;   //Регулярка */ в "" <= 10 симв.


        if (expression.matches(regexCompositeAr)) {
            boolean isLatin = false;
            return fullTrim(expression, isLatin);
        }
//            else if (expression.matches(regexCompositeL)) {
//        }
        return INPUT_ERROR;
    }

    //    Порезать выражение и вернуть результат
    private static String fullTrim(String workExpression, boolean ifLatin) {
        String[] trimEx = new String[3];
        String trimS = workExpression.trim();                         //Отбрасываем боковые пробелы и Tabs
        int lengthT = trimS.length();
        String operator = detectOperator(trimS);
        int operatorPos = trimS.indexOf(operator);
        operator = trimS.substring(operatorPos, operatorPos+1);       //Чистый оператор внутри
        trimEx[0] = operator;
        trimEx[1] = trimS.substring(0, operatorPos).trim();           //1-й строковый операнд
        trimEx[2] = trimS.substring(operatorPos+1, lengthT).trim();   //2-й строковый операнд
        return calculator(trimEx);                                 //(!ifLatin)? calculator(trimEx) : toArabic(trimEx);
    }

//    private static String[] toArabic(String[] trimEx) {
//    return calculator();
//    }

    private static String detectOperator(String isOperator) {
        if (isOperator.contains("+")) return "+";
        else if (isOperator.contains("-")) return "-";
        else if (isOperator.contains("*")) return "*";
        else return "/";
    }


    private static String calculator (String[] toSwitch){
        String locOperator = toSwitch[0];
        return switch (locOperator) {
            case "+" -> Operations.sAdd(toSwitch[1], toSwitch[2]);
            case "-" -> Operations.sSubtract(toSwitch[1], toSwitch[2]);
            case "*" -> Operations.sMultiply(toSwitch[1], toSwitch[2]);
            default -> Operations.sDivide(toSwitch[1], toSwitch[2]);
        };
    }
}




