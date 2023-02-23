package academy.kata.test;

import java.util.Scanner;

public class TestJM {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String argS = scanner.nextLine();
        int argInt = scanner.nextInt();

        sMultiply(argS, argInt);

    }

    static void sMultiply (String a, int b){
        String result = a.repeat(b);
        System.out.println("Результат умножения: " + result);
    }
}
