package lesson3;

import java.util.Arrays;

public class HomeWorkApp3 {
    public static void main(String[] args) {
        System.out.println("Homework Лобачева Елена");
        System.out.println("Задание 1");
        invertArray();
        System.out.println("Задание 2");
        hundredArray();
        System.out.println("Задание 3");
        changeArray();
        System.out.println("Задание 4");
        elementsDiagonal ();

    }

    public static void invertArray () {
        int [] arr = {1,0,1,0,0,1,0,1};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "-" + arr[i] + " ");
        }
    }
    public static void hundredArray () {
        int [] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "-" + arr[i] + " ");
        }
    }
    public static void changeArray () {
        int[] mas = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 6) mas[i] = mas[i] * 2;
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.println(i + "-" + mas[i] + " ");
        }
    }
    public static void elementsDiagonal () {
    int [] [] arr = new int[6][6];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
            }
        }
    }

