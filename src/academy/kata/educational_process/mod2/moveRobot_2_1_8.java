package academy.kata.educational_process.mod2;

import java.util.*;

public class moveRobot_2_1_8 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int randomDirection = rnd.nextInt(4) + 1;
        int startX = rnd.nextInt(20) - 10;
        int startY = rnd.nextInt(20) - 10;
        int finishX = rnd.nextInt(20) - 10;
        int finishY = rnd.nextInt(20) - 10;

        System.out.println("Стартовый X: " + startX);
        System.out.println("Финишный X: " + finishX + "\n");
        System.out.println("Стартовый Y: " + startY);
        System.out.println("Финишный Y: " + finishY + "\n");

        Robot robot = switch (randomDirection) {
            case 1 -> new Robot(startX, startY, Direction.DOWN);
            case 2 -> new Robot(startX, startY, Direction.RIGHT);
            case 3 -> new Robot(startX, startY, Direction.UP);
            default -> new Robot(startX, startY, Direction.LEFT);
        };
        moveRobot(robot, finishX, finishY);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        // Код:
        int deltaX = toX - robot.getX();

        if (deltaX != 0) {                                      //Направляем правильно по X

            if (deltaX > 0) {
                while (robot.getDirection() != Direction.RIGHT) {
                    robot.turnRight();
                }
            } else {
                while (robot.getDirection() != Direction.LEFT) {
                    robot.turnLeft();
                }
            }
//            System.out.println("Направление головы робота по X: " + robot.getDirection() + " и dir: " + robot.dir); // TODO: 024 24.03.2023

            while (robot.getX() != toX) {
                robot.stepForward();
                System.out.println("Робот шагает по оси X: " + robot.getX());
            }
            System.out.println();
        }


        int deltaY = toY - robot.getY();

        if (deltaY != 0) {                                      //Направляем правильно по Y

            if (deltaY > 0) {
                while (robot.getDirection() != Direction.UP) {
                    robot.turnRight();
                }
            } else {
                while (robot.getDirection() != Direction.DOWN) {
                    robot.turnLeft();
                }
            }
//            System.out.println("\nНаправление головы робота по Y: " + robot.getDirection() + " и dir: " + robot.dir); // TODO: 024 24.03.2023

            while (robot.getY() != toY) {
                robot.stepForward();
//                System.out.println("Робот шагает по оси Y: " + robot.getY()); // TODO: 024 24.03.2023
            }
            System.out.println();
        }
    }
//        robot.getY() = robot.getY() + deltaY;



//        System.out.println("Случайно оказались в точке финиша по Y");
//
//        System.out.println("Случайно оказались в точке финиша по X");
//
//        System.out.println("\nРобот идёт по оси X до конца. deltaX = " + (toX - robot.getX())); // TODO: 024 24.03.2023
//
//        System.out.println("\nНаправление головы робота по Y: " + robot.getDirection() + " и dir: " + robot.dir); // TODO: 024 24.03.2023
//
//        System.out.println("\nРобот идёт по оси Y до конца deltaX = " + (toY - robot.getY())); // TODO: 024 24.03.2023
//
//        System.out.println("\nРобот пришёл по X: \nX: " + robot.getX() + "\nX: " + robot.getX());// TODO: 024 24.03.2023
//
//        System.out.println("\nРобот пришёл по Y: \nY: " + robot.getY() + "\nY: " + robot.getY());// TODO: 024 24.03.2023

}

//        System.out.println("Дельта X: " + (deltaX));
//        System.out.println("Изначальное направление: " + robot.getDirection());
//        System.out.println((robot.getDirection() == Direction.RIGHT) + "\n");
