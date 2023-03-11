package academy.kata.educational_process;

/**
 * Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a.
 * В качестве примера написано заведомо неправильное выражение. Исправьте его.
 */
public class CharExpression_1_3_2 {
    public static char charExpression(int a) {
        //Твой код здесь
        return (char) ('\\' + a);
    }

}
