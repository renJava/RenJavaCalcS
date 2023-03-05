package academy.kata.calc_test1;

/**
*                                 Калькулятор (+-/*) целых арабских  и латинский чисел <= 10
*/


import java.util.Scanner;

import static java.lang.System.*;

public class CalcLatinArabic {
    static final String INPUT_ERROR = "!!!Некорректный ввод!!!";

    public static void main(String[] args) {
        String expression;
        String validateIn;
        boolean isValidateInput;
        do {
            Scanner scanner = new Scanner(in);
            String announcement = """

                            Правила ввода:
                    Введите выражение или только с латинскими или только с целыми арабскими числами >0, но <=10.
                    В одной строке одновременно допускаются либо только арабские, либо только латинские цифры.
                                        
                    При ошибке в выражении будет выполнен повторный цикл ввода!!!:
                                        
                                          """;
            out.println(announcement);
            expression = scanner.nextLine();
            out.println();
            validateIn = isValidate(expression);
            out.println("\nРезультат: " + validateIn);
            isValidateInput = validateIn.equals(INPUT_ERROR);
            if (isValidateInput) {
                out.println("\nПовторите, пожалуйста, ввод.");
            }
        }
        while (isValidateInput);
    }

            //Входная проверка выражения и подготовка к распределению на арабскую и латинскую ветки вычислений
    static String isValidate(String expression) {            //Проверить корректности ввода

      final String startRegex = "^";
      final String reOperandAr = "[ \t]*(?:[1-9]|10)[ \t]*"; //Цифра [1-10], а вокруг пробелы и Tabs
      final String reOperandL = "[ \t]*[IVX]{1,4}[ \t]*";    //Набор для латыни <=10, в пробелах и Tabs
      final String reOperators = "[-+*/]";

      final String regexCompositeArabic = startRegex + reOperandAr + reOperators + reOperandAr; //Регулярка араб.<= 10
      final String regexCompositeLatin = startRegex + reOperandL + reOperators + reOperandL;    //Регулярка лат.<= 4 зн.

      if (expression.matches(regexCompositeArabic)) {
          return fullTrim(expression, false);

      } else if (expression.matches(regexCompositeLatin)) {
          return resultToLatin(fullTrim(expression, true));

      }
      return INPUT_ERROR;
    }

    //    Порезать выражение и распределить на арабскую и латинскую ветки вычислений
    private static String fullTrim(String workExpression, boolean ifLatin) {
        String[] trimEx = new String[3];
        String trimS = workExpression.trim();                         //Отбросить боковые пробелы и Tabs
        int lengthT = trimS.length();
        String operator = detectOperator(trimS);
        int locOperator = trimS.indexOf(operator);                    //Вырезать поле с пробелами и оператором
        operator = trimS.substring(locOperator, locOperator + 1);     //Чистый оператор внутри поля
        trimEx[0] = operator;                                         //Чистый оператор на экспорт
        trimEx[1] = trimS.substring(0, locOperator).trim();           //1-й строковый операнд
        trimEx[2] = trimS.substring(locOperator + 1, lengthT).trim(); //2-й строковый операнд
        return (!ifLatin) ? calculator(trimEx) : calculator(latinToArabic(trimEx));
    }

    private static String detectOperator(String operator) {
        if (operator.contains("+")) return "+";
        else if (operator.contains("-")) return "-";
        else if (operator.contains("*")) return "*";
        else return "/";
    }

    private static String calculator(String[] operand) {
        String operator = operand[0];
        return switch (operator) {
            case "+" -> Arithmetic.sAdd(operand[1], operand[2]);
            case "-" -> Arithmetic.sSubtract(operand[1], operand[2]);
            case "*" -> Arithmetic.sMultiply(operand[1], operand[2]);
            default -> Arithmetic.sDivide(operand[1], operand[2]);
        };
    }

    private static String[] latinToArabic(String[] latinOperandS) {
        String[] latinToArab = new String[3];
        latinToArab[0] = latinOperandS[0];
        for (int i = 1; i <= 2; i++) {
            try {
                LatinEnum.valueOf(latinOperandS[i]);
            } catch (IllegalArgumentException e) {
                err.println("!!! Ошибка ввода или латинской цифры нет в заданном диапазоне: " +
                    latinOperandS[i] + " !!!\n");
                exit(0);
            }
            latinToArab[i] = String.valueOf(LatinEnum.valueOf(latinOperandS[i]).ordinal() + 1);

            if (Integer.parseInt(latinToArab[i]) > 10) {
                err.println("\n!!! Ошибка, вводимые операнды должны быть <= 10. " +
                        "А латинская: " + latinOperandS[i] + " больше 10 !!!\n");
                exit(0);
            }
        }
        return latinToArab;
    }

    private static String resultToLatin(String resultInArabicS) {
        int resultInArabicInt = Integer.parseInt(resultInArabicS);
        if (resultInArabicInt < 1) {
                err.println("\n!!! Результат операций с латиницей не может быть меньше 1 !!!\n");
                exit(0);
        }
        LatinEnum[] arrayLatinFromEnum = LatinEnum.values();
        return String.valueOf(arrayLatinFromEnum[resultInArabicInt - 1]);   //Конвертировать в латиницу
    }
}