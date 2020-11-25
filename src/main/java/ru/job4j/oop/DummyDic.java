package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизсвестное слово - " + eng;
    }

    public static void main(String[] args) {
        DummyDic print = new DummyDic();
        String messege = print.engToRus("unknown word");
        System.out.println(messege);
    }
}
