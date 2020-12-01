package ru.job4j.profession;

public class Programmer extends Engineer {
    private String languageCode;
    private String info;
    private Engineer engineer;

    public Programmer(int experience, String languageCode, String info, Engineer engineer) {
        super(experience);
        this.languageCode = languageCode;
        this.info = info;
        this.engineer = engineer;
    }

    public Bytecode heal(CodeJava code) {
        Bytecode bytecode = new Bytecode("BlaBla");
        return bytecode;
    }

    public static void main(String[] args) {
//        Engineer engineer = new Engineer(25);
//        String message = engineer.getInfo("This character has experience: ");
//        System.out.println(message);
    }
}
