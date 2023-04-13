package academy.kata.educational_process.mod3;

import java.util.Objects;

/**
 * Есть класс BankClient - это класс, описывающий клиента банка.

 * Есть интерфейс BankWorker. Объект класса, который реализует этот интерфейс является работником банка,
 * в задачу которого входит одобрение или отклонение заявок на кредиты.

 * У него есть метод checkClientForCredit, который на вход принимает экземпляр BankClient и возвращает true,
 * если всё в порядке и кредит переданному клиенту можно выдавать, или false - если клиент не подходит под условия
 * кредита. Также, этот метод может выбросить исключение BadCreditHistoryException, если у клиента плохая кредитная
 * история. Или ProblemWithLawException, если у клиента есть проблемы с законом.
 *
 * Реализовать метод getCreditForClient, который принимает работника банка и клиента, который хочет получить кредит.
 * Метод должен возвращать true - если кредит выдать можно и все условия соблюдены и false если есть какие-то проблемы.
 * Если клиенту отказали в выдаче кредита по причине плохой банковской истории - метод должен выводить в консоль сообщение
 * "Проблемы с банковской историей", если клиенту отказали по причине проблем с законом то ничего выводить на экран не нужно.
 */

// throws ProblemWithLawException, BadCreditHistoryException
public class GetCreditForClient324 {
    public static boolean getCreditForClient(BankWorker bankWorker, BankClient bankClient) {
        //Твой код здесь
        try {
            return bankWorker.checkClientForCredit(bankClient);
        } catch (BadCreditHistoryException e) {
            System.out.println("Проблемы с банковской историей");
        } catch (ProblemWithLawException e) {
            // Ничего не выводим на экран
        }
        return false;
    }

    interface BankWorker {
        boolean checkClientForCredit(BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException;
    }


    public static void main(String[] args) throws BadCreditHistoryException, ProblemWithLawException {
        GetCreditForClient324 getCreditForClient = new GetCreditForClient324();
        BankClient client1 = new BankClient("Good");
        BankClient client2 = new BankClient("Проблемы с законом");
        BankClient client3 = new BankClient("Проблемы с банковской историей");
        BankWorker rabotnik = new BankRabotnik();
        System.out.println(getCreditForClient(rabotnik, client1) + "\n"); //true

        System.out.println(getCreditForClient(rabotnik, client2) + "\n"); //false

        System.out.println(getCreditForClient(rabotnik, client3) + "\n"); // "Проблемы с банковской историей" false
    }

    public static class ProblemWithLawException extends Exception {
    }

    public static class BadCreditHistoryException extends Exception {
    }

    static class BankClient {
        public String status;

        public BankClient(String status) {
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BankClient that = (BankClient) o;
            return Objects.equals(status, that.status);
        }

        @Override
        public int hashCode() {
            return Objects.hash(status);
        }
    }

    static class BankRabotnik implements BankWorker {
        @Override
        public boolean checkClientForCredit(BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException {
            if (bankClient.status.equals("Проблемы с банковской историей")) {
                throw new BadCreditHistoryException();
            } else if (bankClient.status.equals("Проблемы с законом")) {
                throw new ProblemWithLawException();
            }
            return true;
        }
    }
}
