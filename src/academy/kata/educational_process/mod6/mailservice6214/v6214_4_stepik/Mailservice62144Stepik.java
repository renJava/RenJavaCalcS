package academy.kata.educational_process.mod6.mailservice6214.v6214_4_stepik;

import java.util.*;
import java.util.function.Consumer;

public class Mailservice62144Stepik {
    // MailMessage и Salary имеют практически идентичный интерфейс
// за исключением типа поля content. Давайте абстрагируем это знание в интерфейс.
    public interface Sendable<T> {
        String getFrom();

        String getTo();

        T getContent();
    }


    // Абстрагируем логику хранения всех элементов класса во внутренних полях класса,
// создав класс SimpleSendable. Не забудем указать реализуемый интерфейс.
    public static class SimpleSendable<T> implements Sendable<T> {
        private final String from;
        private final String to;
        private final T content;

        public SimpleSendable(String from, String to, T content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public T getContent() {
            return content;
        }
    }


    // Теперь объявим MailMessage и Salary, отнаследовавшись от SimpleSendable
// с конкретным параметром типа.
    public static class MailMessage extends SimpleSendable<String> {
        public MailMessage(String from, String to, String content) {
            super(from, to, content);
        }
    }


    public static class Salary extends SimpleSendable<Integer> {
        public Salary(String from, String to, Integer content) {
            super(from, to, content);
        }
    }


    // forEachOrdered и forEach ожидают в качестве аргумента класс,
// реализующий интерфейс Consumer.
// Судя по исходному коду, Consumer потребляет письма с содержимым,
// соответствующим параметру класса MailService.
    public static class MailService<T> implements Consumer<Sendable<T>> {

        // Если внимательно посмотреть на исходный код задания, можно заметить,
        // что логика метода get у получаемого в getMailBox Map'а при отсутствующем элементе
        // отличается от логики стандартных коллекций. Переназначим эту логику в анонимном
        // наследнике HashMap.
        private final Map<String, List<T>> messagesMap = new HashMap<>() {
            @Override
            public List<T> get(Object key) {
                if (this.containsKey(key)) {
                    // Возвращать изменяемый список во внешний мир – не очень хорошая идея
                    // по причине того, что его изменение может испортить внутреннее состояние
                    // словаря. Лучше оборачивать подобный вывод в
                    //  Collections.unmodifiableList.
                    // Однако здесь мы не можем так поступить по причине того,
                    // что добавлять новые элементы в списки из accept будет неудобно.
                    // Нужно реализовать дополнительный метод getMutable, который возвращал
                    // бы изменяемый список, удобный для модификации.
                    // Но добавить новый метод мы можем только в именованный класс.
                    return super.get(key);
                } else {
                    // Collections.emptyList() возвращает один и тот же экземпляр
                    // неизменяемого списка. Если бы мы возвращали здесь, допустим,
                    // new ArrayList<>(), то множество вызовов get по отсутствующему
                    // элементу создавало бы множество лишних объектов.
                    return Collections.emptyList();
                }
            }
        };

        @Override
        public void accept(Sendable<T> sendable) {
            List<T> ts = messagesMap.get(sendable.getTo());
            if (ts.isEmpty()) {
                ts = new ArrayList<>();
            }
            ts.add(sendable.getContent());
            messagesMap.put(sendable.getTo(), ts)
        }

        public Map<String, List<T>> getMailBox() {
            return messagesMap;
        }
    }

    public static void main(String[] args) {
// Random variables
        String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

// Создание списка из трех почтовых сообщений.
        final String toChrNolan = "Christopher Nolan";
        final String toLovecraft = "H.P. Lovecraft";
        Mailservice62144Stepik.MailMessage firstMessage = new Mailservice62144Stepik.MailMessage(
                "Robert Howard",
                toLovecraft,
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard"): "Wrong firstMessage from address";
        assert firstMessage.getTo().equals(toLovecraft): "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!"): "Wrong firstMessage content ending";

        Mailservice62144Stepik.MailMessage secondMessage = new Mailservice62144Stepik.MailMessage(
                "Jonathan Nolan",
                toChrNolan,
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        Mailservice62144Stepik.MailMessage thirdMessage = new Mailservice62144Stepik.MailMessage(
                "Stephen Hawking",
                toChrNolan,
                "Я так и не понял Интерстеллар."
        );

        List<Mailservice62144Stepik.MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

// Создание почтового сервиса.
        Mailservice62144Stepik.MailService<String> mailService = new Mailservice62144Stepik.MailService<>();

// Обработка списка писем почтовым сервисом
        messages.forEach(mailService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get(toLovecraft).equals(
                List.of(
                        "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                )
        ): "wrong mailService mailbox content (1)";

        assert mailBox.get(toChrNolan).equals(
                Arrays.asList(
                        "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
                        "Я так и не понял Интерстеллар."
                )
        ): "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()): "wrong mailService mailbox content (3)";


// Создание списка из трех зарплат.
        Mailservice62144Stepik.Salary salary1 = new Mailservice62144Stepik.Salary("Facebook", "Mark Zuckerberg", 1);
        Mailservice62144Stepik.Salary salary2 = new Mailservice62144Stepik.Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Mailservice62144Stepik.Salary salary3 = new Mailservice62144Stepik.Salary(randomFrom, randomTo, randomSalary);

// Создание почтового сервиса, обрабатывающего зарплаты.
        Mailservice62144Stepik.MailService<Integer> salaryService = new Mailservice62144Stepik.MailService<>();

// Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(List.of(1)): "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(List.of(Integer.MAX_VALUE)): "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(List.of(randomSalary)): "wrong salaries mailbox content (3)";
    }
}
