package academy.kata.educational_process.mod3;

public class review31 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0\n");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1\n");
        } catch(Error e) {
            System.err.print(" 2\n");
        } finally {
            System.err.print(" 3\n");
        }
        System.err.print(" 4\n");
    }
}
