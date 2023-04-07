package academy.kata.educational_process.mod3;

/**
 * Ваша задача - реализовать метод который устанавливает соединение с роботом, отдает ему команду на перемещение в
 * заданную точку и затем закрывает соединение, выполняя при необходимости повтор этой последовательности до трех раз.
 *
 * При этом:
 * Попытка отдать команду роботу считается успешной, если удалось установить соединение и выполнить метод
 * RobotConnection.moveRobotTo() без исключений. Ошибка закрытия соединения не важна и должна игнорироваться.
 *
 * Если первая попытка подключиться и отдать команду оказалась неуспешной, то закрываем соединение и выполняем вторую попытку.
 * Если вторая тоже не удалась, то выполняется третья.
 * После третьей неудачи метод должен бросить исключение RobotConnectionException.
 *
 * Метод отвечает за открытие и закрытие соединения. Если соединение удалось установить, то оно обязательно должно
 * быть закрыто несмотря на возможные исключения, случившиеся в дальнейшем во время работы метода.
 *
 * Если во время работы метода случилось исключение любого типа, отличного от RobotConnectionException,
 * метод должен завершиться и выбросить это исключение, не выполняя повторных попыток пообщаться с роботом.
 * Единственное, что метод должен сделать перед выбросом этого исключения — закрыть открытое соединение RobotConnection.
 *
 * В решение должен использоваться классический try-catch.
 */
public class MoveRobot_3_2_6 {
    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);
        @Override
        void close();
    }

    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) throws RobotConnectionException {
        //Твой код здесь
        for (int i = 0; i < 3; i++) {
            RobotConnection robotConnection = null;
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                return;
            } catch (RobotConnectionException e) {  //3 неудачных попытки соединения! Баста!
                if (i == 2) {
                    throw e;
                }
            } finally {
                if (robotConnection != null) {      //при других проблемах со связью - отрубить связь
                    try {
                        robotConnection.close();
                    } catch (Exception e) {
                    e.printStackTrace();            //getMessage()
                    }
                }
            }
        }
    }
}
// ignore any exceptions during closing connection

//                    throw new RobotConnectionException("Failed to establish connection after 3 attempts", e);
