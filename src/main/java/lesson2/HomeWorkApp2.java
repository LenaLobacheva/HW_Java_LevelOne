package lesson2;

public class HomeWorkApp2 {

    public static void main(String[] args) {
        System.out.println("Homework Лобачева Елена");
        System.out.println("Задание 1");
        System.out.println(sumReturn(7, 6));
        System.out.println("Задание 2");
        pozitivOrnegativ();
        System.out.println("Задание 3");
        System.out.println(returnNumber(6));
        System.out.println("Задание 4");
        stringNumber ();
        System.out.println("Homework is done");
    }

    public static boolean sumReturn (int a, int b) {
        int sum = a + b;
        if (sum >= 10 & sum <= 20){
            return true;
        } else {
            return false;
        }
        }
    public static void pozitivOrnegativ (){
        int a = 5;
        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }
        public static boolean returnNumber (int a) {
        if (a <= 0){
            return true;
        } else {
            return false;
        }
        }
        public static void stringNumber (){
            for (int i = 0; i < 7; i++) {
                System.out.println("Я помню чудное мгновенье...");
            }
        }
    }


