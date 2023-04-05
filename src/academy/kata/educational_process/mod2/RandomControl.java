package academy.kata.educational_process.mod2;

import java.util.Random;

public class RandomControl {
    public static void main(String[] args) {


        for (int i = 0; i <= 50; i++) {
            Random random = new Random();
            int randomDirection = random.nextInt(4) + 1;
            int startX = random.nextInt(20) - 10;
            int startY = random.nextInt(20) - 10;
            int finishX = random.nextInt(20) - 10;
            int finishY = random.nextInt(20) - 10;
            continue;
        }
    }
}
