package academy.kata.educational_process;

/**
 * Для удаления из строки всех символов, не являющихся буквами и цифрами,
 * можно воспользоваться регулярным выражением "[^a-zA-Z0-9]".
 * Найдите в классе String метод, выполняющий замену по регулярному выражению и воспользуйтесь им.
 * Was it a cat I saw?
 */
public class isPalindrome_1_6_9 {
    public static boolean isPalindrome(String text) {
        //Твой код здесь

        String regexForDefinePalindrom = "[^a-zA-Z0-9]";
        String truncatedText = text.replaceAll(regexForDefinePalindrom, "").toLowerCase();

        StringBuilder sbText = new StringBuilder(truncatedText);
        String sbTextS = String.valueOf(sbText);

        String reversedSbTextS = String.valueOf(sbText.reverse());

        return (sbTextS.equals(reversedSbTextS));
    }
    public static void main(String[] args) {
//        System.out.print("\nВведите день недели по-английски с большой буквы: ");
//        Scanner scanner = new Scanner(System.in);
//        String dayNumber = scanner.nextLine();
        String contropForPalindrom = "Was it a cat I('v) saw?";
        System.out.println("\nСтрока палиндром? " + isPalindrome(contropForPalindrom));
    }

}
