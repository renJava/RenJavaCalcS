package academy.kata.calc_test1;

import java.util.Scanner;

import static java.lang.System.*;

public class CalcLatinArabic {
    static final String INPUT_ERROR = "!!!Некорректный ввод!!!";

    public static void main(String[] args) throws Exception {
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

    static String isValidate(String expression) throws Exception {          //Проверка корректности ввода

      final String beginer = "^";
      final String reOperandAr = "[ \t]*(?:[1-9]|10)[ \t]*"; //Цифра [1-10] вокруг пробелы и Tabs
      final String reOperandL = "[ \t]*[IVX]{1,4}[ \t]*"; //Любой набор до 10-ти сим. в "", в пробелах и Tab
      final String reOperators = "[-+*/]";

      final String regexCompositeAr = beginer + reOperandAr + reOperators + reOperandAr;//Регулярка +- в "" <= 10 симв.
      final String regexCompositeL = beginer + reOperandL + reOperators + reOperandL;   //Регулярка */ в "" <= 10 симв.


      if (expression.matches(regexCompositeAr)) {
          return fullTrim(expression, false);
      }
          else if (expression.matches(regexCompositeL)) {
          return fullTrim(expression, true);

      }
      return INPUT_ERROR;
    }

    //    Порезать выражение и вернуть результат
    private static String fullTrim(String workExpression, boolean ifLatin) throws Exception {
        String[] trimEx = new String[3];
        String trimS = workExpression.trim();                         //Отбрасываем боковые пробелы и Tabs
        int lengthT = trimS.length();
        String operator = detectOperator(trimS);
        int operatorPos = trimS.indexOf(operator);
        operator = trimS.substring(operatorPos, operatorPos+1);       //Чистый оператор внутри
        trimEx[0] = operator;
        trimEx[1] = trimS.substring(0, operatorPos).trim();           //1-й строковый операнд
        trimEx[2] = trimS.substring(operatorPos+1, lengthT).trim();   //2-й строковый операнд
        return (!ifLatin)? calculator(trimEx) : calculator(toArabic(trimEx));
    }

    private static String[] toArabic(String[] convert) throws Exception {
        String[] hasConverted = new String[3];
        hasConverted[0] = convert[0];
        for (int i = 1; i <= 2; i++) {
            try {
                LatinEnum.valueOf(convert[i]);
            } catch (IllegalArgumentException e) {
                out.println("Числа нет в латинском: " + convert[i] + " !!!");
            }
            hasConverted[i] = String.valueOf(LatinEnum.valueOf(convert[i]).ordinal() + 1);

            if (Integer.parseInt(hasConverted[i]) > 10) {
                throw new Exception("\n\n\n!!! " +
                    "Внимание вводимые операнды должны быть <= 10. А латинская " + convert[i] + " больше 10 !!!\n\n");
            }
        }

        return hasConverted;
    }

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




