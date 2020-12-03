package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int match = 11;
        System.out.println("Это игра спички.");
        System.out.println("1 - взять одну спичку");
        System.out.println("2 - взять две спички");
        System.out.println("3 - взять три спички");
        while (match != 0) {
            System.out.println("Осталось " + match + " спич(ек)(ка).");
            System.out.println("Введи число от 1 до 3.");
            String number = input.nextLine();
            int matchGamer = Integer.valueOf(number);
            if (matchGamer <= match && matchGamer > 0 && matchGamer < 4) {
                match -= matchGamer;
            } else {
                System.out.println("Вы ввели неправильное число.");
            }
        }
        System.out.println("Уррааа, ты выграл чувак!");
    }
}
