package academy.kata.educational_process.mod2;

public class catchCat_2_1_6 {
    // Твой код здесь

    public static class Cat {
        public void sayHello() {
            System.out.println("Мяу!");
        }
    }

    public static class Dog {
        public void sayHello() {
            System.out.println("Гав!");
        }
        public void catchCat(Cat cat) {
            System.out.println("Кошка поймана");
            sayHello();
            cat.sayHello();
        }
    }

    public static void main(String[]args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.catchCat(cat);
    }

}