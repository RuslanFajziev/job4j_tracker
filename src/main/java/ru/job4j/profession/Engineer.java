package ru.job4j.profession;

public class Engineer {

    private int experience;

    public Engineer(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return this.experience;
    }

    public static void main(String[] args) {
        Engineer nameEng = new Engineer(10);
        System.out.println(nameEng.getExperience());
    }

    public String getInfo (String txt) {
        return txt + this.experience;
    }
}
