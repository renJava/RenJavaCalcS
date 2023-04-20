package academy.kata.educational_process.mod4;

import java.util.logging.Logger;

/**
 * Создайте в статичном публичном методе logging логгер с именем com.javamentor.logging.Test,
 * залогируйте им два сообщения: первое "Все хорошо" с уровнем INFO и второе "Произошла ошибка" с уровнем WARNING.
 */
public class Logging448 {
    public static void logging() {
        //Твой код здесь
            Logger logger = Logger.getLogger("com.javamentor.logging.Test");
            logger.info("Все хорошо");
            logger.warning("Произошла ошибка");
    }

}
