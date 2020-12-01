package ru.job4j.profession;

public class Engineer extends Profession {
    private int experience;
    private Profession profession;

    public Engineer(String name, String surname, String education, String birthday, int experience, Profession profession) {
        super(name, surname, education, birthday);
        this.experience = experience;
        this.profession = profession;
    }

    public Engineer(int experience) {
    }

    public int getExperience() {
        return this.experience;
    }

    public static void main(String[] args) {
        Profession profession = new Profession();
        Engineer nameEng = new Engineer("Vasay", "Pupkin", "highest", "01.01.1945", 40, profession);
        System.out.println(nameEng.getExperience());
    }

    public String getInfo(String txt) {
        return txt + this.experience;
    }
}
