package academy.kata.educational_process.mod1;

/**
 * Реализовать метод, который будет принимать целочисленное строку, и отвечать соответствует ли эта строка почтовому
 * ящику сервисов google (gmail.com) или майкрософт (outlook.com).
 * Будем считать, что в корректном почтовом ящике можно использовать только цифры и буквы.
 * ^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$
 */
public class IsGmailOrOutlook1611 {
    public static boolean isGmailOrOutlook(String email) {
        //Твой код тут
        String regexBegin = "^";
        String regexLocAndDomain = "[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

        String regexEMail = regexBegin + regexLocAndDomain;

        return (email.matches(regexEMail));
    }

    public static void main(String[] args) {
        System.out.print("\nВведите электронную почту: ");
        String emailInput = "rendg68@gmail.com";
//        String contropForPalindrom = "Was it a cat I() saw?";
        System.out.println(isGmailOrOutlook(emailInput));
    }
}
//        String regexDomain = "+[@[a-zA-Z0-9.-]+$]";
//        String regexDomain = "[@((gmail.com)|(outlook.com))]";
//        String regexZone = "[(.com)$]";

//        String regexEMail = regexBegin + regexLoc + regexDomain + regexZone;
//        String regexEMail = regexDomain + regexZone;
//        String regexEMail = regexDomain + regexZone;
