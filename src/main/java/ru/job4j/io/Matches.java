package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int match = 11;
        String name = "Andrey";
        int hod = 1;
        System.out.println("Это игра спички.");
        System.out.println("1 - взять одну спичку");
        System.out.println("2 - взять две спички");
        System.out.println("3 - взять три спички");
        while (match != 0) {
            name = hod++ % 2 == 0 ? "Stepan" : "Andrey";
            System.out.println("Осталось " + match + " спич(ек)(ка).");
            System.out.println(name + " введи число от 1 до 3.");
            String number = input.nextLine();
            int matchGamer = Integer.valueOf(number);
            if (matchGamer <= match && matchGamer > 0 && matchGamer < 4) {
                match -= matchGamer;
            } else {
                hod--;
                System.out.println(name + ", ты ввел неправильное число.");
            }
        }
        System.out.println("Уррааа " + name + ", ты выграл!");
    }
}
