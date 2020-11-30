package ru.job4j.profession;

public class Programmer extends Engineer {
    private String languageCode;
    private Engineer engineer;
    private String info;

    public Bytecode heal(CodeJava code) {
    }

    public static void main(String[] args) {
        Engineer engineer = new Engineer(25);
        String message = engineer.getInfo("This character has experience: ");
        System.out.println(message);
    }
}
