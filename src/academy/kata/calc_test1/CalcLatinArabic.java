package academy.kata.calc_test1;

/**
*                                 Калькулятор (+-/*) целых арабских  и латинских чисел <= 10
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
          return fullTrimS(expression, false);

      } else if (expression.matches(regexCompositeLatin)) {
          return resultToLatinS(fullTrimS(expression, true));

      }
      return INPUT_ERROR;
    }

    //    Порезать выражение и распределить на арабскую и латинскую ветки вычислений
    private static String fullTrimS(String workExpression, boolean ifLatin) {
        String[] trimExpS = new String[3];
        String trimS = workExpression.trim();                         //Отбросить боковые пробелы и Tabs
        int lengthT = trimS.length();
        String operatorS = detectOperatorS(trimS);
        int intOperatorPos = trimS.indexOf(operatorS);                        //Вырезать поле с пробелами и оператором
        operatorS = trimS.substring(intOperatorPos, intOperatorPos + 1);      //Чистый оператор внутри поля
        trimExpS[0] = operatorS;                                              //Чистый оператор на экспорт
        trimExpS[1] = trimS.substring(0, intOperatorPos).trim();              //1-й строковый операнд
        trimExpS[2] = trimS.substring(intOperatorPos + 1, lengthT).trim();    //2-й строковый операнд
        return (!ifLatin) ? calculator(trimExpS) : calculator(latinToArabicS(trimExpS));
    }

    private static String detectOperatorS(String operator) {
        if (operator.contains("+")) return "+";
        else if (operator.contains("-")) return "-";
        else if (operator.contains("*")) return "*";
        else return "/";
    }

    private static String calculator(String[] operand) {
        String operator = operand[0];
        return String.valueOf(switch (operator) {
            case "+" -> Arithmetic.sAdd(operand[1], operand[2]);
            case "-" -> Arithmetic.sSubtract(operand[1], operand[2]);
            case "*" -> Arithmetic.sMultiply(operand[1], operand[2]);
            default -> Arithmetic.sDivide(operand[1], operand[2]);
        });
    }

    private static String[] latinToArabicS(String[] latinOperandS) {
        String[] latinToArabS = new String[3];
        latinToArabS[0] = latinOperandS[0];
        for (int i = 1; i <= 2; i++) {
            try {
                LatinEnum.valueOf(latinOperandS[i]);
            } catch (IllegalArgumentException e) {
                err.println("!!! Ошибка ввода или латинской цифры нет в заданном диапазоне: " +
                    latinOperandS[i] + " !!!\n");
                exit(0);
            }
            int latinToArabInt = LatinEnum.valueOf(latinOperandS[i]).ordinal() + 1;

            if (latinToArabInt > 10) {
                err.println("\n!!! Ошибка, вводимые операнды должны быть <= 10. " +
                        "А латинская: " + latinOperandS[i] + " больше 10 !!!\n");
                exit(0);
            }
            latinToArabS[i] = String.valueOf(latinToArabInt);
        }
        return latinToArabS;
    }

    private static String resultToLatinS(String resultInArabicS) {
        int resultInArabicInt = Integer.parseInt(resultInArabicS);
        if (resultInArabicInt < 1) {
                err.println("\n!!! Результат операций с латиницей не может быть меньше 1 !!!\n");
                exit(0);
        }
        LatinEnum[] arrayLatinFromEnum = LatinEnum.values();
        return String.valueOf(arrayLatinFromEnum[resultInArabicInt - 1]);  //Конвертировать в латиницу и в строковый вид
    }
}