package academy.kata.educational_process.mod2;

/**
 * Класс AsciiCharSequence должен:
 * реализовывать интерфейс java.lang.CharSequence;
 * иметь конструктор, принимающий массив байт;
 * определять методы length(), charAt(), subSequence() и toString()
 */
public class AsciiCharSequence256 {
    public static class AsciiCharSequence implements CharSequence {
        //Твой код здесь
            private final byte[] byteSeq;

            public AsciiCharSequence(byte[] bytesSeq) {
                this.byteSeq = bytesSeq;
            }

            @Override
            public int length() {
                return byteSeq.length;
            }

            @Override
            public char charAt(int i) {
                return (char) byteSeq[i];
            }

            @Override
            public CharSequence subSequence(int pos0, int end) {
                return new AsciiCharSequence(java.util.Arrays.copyOfRange(byteSeq, pos0, end));
            }

            @Override
            public String toString() {
                return new String(byteSeq);
            }
    }
}


