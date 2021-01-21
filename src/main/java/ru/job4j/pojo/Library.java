package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book childhood = new Book("Сhildhood", 50);
        Book buratino = new Book("Buratino", 25);
        Book viy = new Book("Viy", 100);
        Book warAndPeace = new Book("War and peace", 50);
        Book[] books = new Book[4];
        books[0] = childhood;
        books[1] = buratino;
        books[2] = viy;
        books[3] = warAndPeace;
        for (int index = 0; index < books.length; index++) {
            Book postulate = books[index];
            System.out.println(postulate.getName() + " - " + postulate.getQuantity());
        }
        System.out.println();
        Book clrCode = new Book("Clean code", 150);
        books[3] = clrCode;
        for (int index = 0; index < books.length; index++) {
            Book postulate = books[index];
            System.out.println(postulate.getName() + " - " + postulate.getQuantity());
        }
        System.out.println();
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int index = 0; index < books.length; index++) {
            Book postulate = books[index];
            System.out.println(postulate.getName() + " - " + postulate.getQuantity());
        }
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            Book postulate = books[index];
            if (postulate.getName().equals("Clean code")) {
                System.out.println(postulate.getName() + " - " + postulate.getQuantity());
            }
        }
    }
}
