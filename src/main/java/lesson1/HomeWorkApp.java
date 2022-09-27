package lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
     System.out.println("Homework Лобачева Елена");
     printThreeWords();
     checkSumSign();
     printColor();
     compareNumbers();
        System.out.println("Homework is done!");
    }

    public static void printThreeWords() {
        System.out.println("Задание № 2");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        System.out.println("Задание № 3");
        int a = 5;
        int b = -2;

        if (a + b >= 0){
            System.out.println("Сумма положительная");
        } else if (a + b < 0){
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(){
        System.out.println("Задание № 4");
        int value = 45;

        if (value <= 0){
            System.out.println("Красный");
        } else if (value > 0 && value <= 100){
            System.out.println("Желтый");
        } else if (value > 100){
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(){
        System.out.println("Задание № 5");
        int a = 5, b = 3;
        if (a >= b){
            System.out.println( "a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
