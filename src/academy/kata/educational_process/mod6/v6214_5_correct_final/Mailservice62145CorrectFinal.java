package academy.kata.educational_process.mod6.v6214_5_correct_final;

import java.util.*;
import java.util.function.Consumer;

public class Mailservice62145CorrectFinal {
    public interface Sendable<T> {
        String getFrom();
        String getTo();
        T getContent();
    }

    public static class MailMessage implements Sendable<String> {
        private final String from;
        private final String to;
        private final String content;

        public MailMessage(String from, String to, String content) {
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
        public String getContent() {
            return content;
        }
    }

    public static class Salary implements Sendable<Integer> {
        private final String from;
        private final String to;
        private final Integer content;

        public Salary(String from, String to, Integer content) {
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
        public Integer getContent() {
            return content;
        }
    }

    public static class MailService<T> implements Consumer<Sendable<T>> {
        private final Map<String, List<T>> mailBox;

        public MailService() {
            mailBox = new HashMap<>() {
                @Override
                public List<T> get(Object key) {
                    return (super.get(key) == null ? Collections.emptyList() : super.get(key));
                }
            };
        }

        public Map<String, List<T>> getMailBox() {
            return mailBox;
        }

        @Override
        public void accept(Sendable<T> message) {
            mailBox.computeIfAbsent(message.getTo(), k -> new ArrayList<>()).add(message.getContent());
        }
    }

}
