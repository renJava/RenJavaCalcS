package academy.kata.educational_process;

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
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            stringBuilder.append(roles[i]).append(":").append('\n');
            for (int j = 0; j < textLines.length; j++) {
                String string = textLines[j];
                if (string.startsWith(roles[i] + ":")) {
                    String string1 = string.replaceFirst(roles[i] + ":", (j + 1) + ")");
                    stringBuilder.append(string1).append('\n');
                }
            }
            stringBuilder.append('\n');

//            Сообщение от ментора:
//            Не создавай переменные в цикле, используй foreach replace лучше заменить на substring
        }
        return String.valueOf(stringBuilder);
    }

    public static void main(String[] args) {
        String[] roles = new String[] {"Городничий","Аммос Федорович","Артемий Филиппович","Лука Лукич"};
        String[] textLines = new String[]{"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор."
                ,"Аммос Федорович: Как ревизор?"
                ,"Артемий Филиппович: Как ревизор?"
                ,"Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем."
                ,"Аммос Федорович: Вот те на!","Артемий Филиппович: Вот не было заботы, так подай!"
                ,"Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.println(printTextPerRole(roles,textLines));
    }
}
