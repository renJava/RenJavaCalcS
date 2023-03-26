package academy.kata.educational_process.mod1;

/**
 * Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать результат в виде
 * готового текста (см. пример). Каждая группа распечатывается в следующем виде:
 * Роль:
 * i) текст
 * j) текст2
 * ...
 * ==перевод строки==
 */
public class printTextPerRole_1_6_12 {
    public static String printTextPerRole(String[] roles, String[] textLines) {
        //Твой код здесь

        int textLinesL = textLines.length;
        StringBuilder stringBuilder = new StringBuilder();
        String speechFor;
        String speechNumber;
        String roleForWithColon;
        int roleWithColonLength;

        for (String roleFor : roles) {

            roleForWithColon = roleFor + ":";
            roleWithColonLength = roleForWithColon.length();

            stringBuilder.append(roleForWithColon).append('\n');

            for (int j = 0; j < textLinesL; j++) {

                speechFor = textLines[j];

                if (speechFor.startsWith(roleForWithColon)) {
                    speechNumber = (j + 1) + ")" + speechFor.substring(roleWithColonLength);

                    stringBuilder.append(speechNumber).append('\n');
                }
            }
            stringBuilder.append('\n');

        }
        return String.valueOf(stringBuilder);
    }

    public static void main(String[] args) {
        String[] roles = new String[]{"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
        String[] textLines = new String[]{"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное" +
                " известие: к нам едет ревизор."
                , "Аммос Федорович: Как ревизор?"
                , "Артемий Филиппович: Как ревизор?"
                , "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем."
                , "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!"
                , "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles, textLines));
    }
}
//            Сообщение от ментора:
//            Не создавай переменные в цикле, используй foreach replace лучше заменить на substring
