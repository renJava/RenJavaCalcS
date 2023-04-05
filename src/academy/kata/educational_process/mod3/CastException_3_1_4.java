package academy.kata.educational_process.mod3;

public class CastException_3_1_4 {
    public static void main(String[] args) {
        B b = new B();
        A a = (A) b;
        System.out.println("Приведение к другому типу: ");

//            Object obj = new java.util.Date();
//            Integer int1 = (Integer) obj;
    }

    public static class A {
    }

    public static class B extends A{
    }
}
