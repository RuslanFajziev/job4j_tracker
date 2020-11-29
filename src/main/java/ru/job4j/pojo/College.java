package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Pupkin Vasa Batkovich");
        student.setGroup("Enykey");
        student.setReceiptDate(new Date());
        System.out.print("FIO: " + student.getFio() + System.lineSeparator() + "Group: " + student.getGroup() + System.lineSeparator());
        System.out.println("ReceiptDate: " + student.getReceiptDate());
    }
}
