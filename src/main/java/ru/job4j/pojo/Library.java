package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book code = new Book("Clean code", 481);
        Book economics = new Book("Economics", 328);
        Book physics = new Book("Physics", 421);
        Book mathematics = new Book("Mathematics", 982);
        Book[] books = {code, economics, physics, mathematics};
        for (int i = 0; i < books.length; i++) {
            System.out.format("Name: %s, pages: %d, index: %d%n",
                    books[i].getName(), books[i].getPages(), i);
        }
        swap(books, 0, 3);
        System.out.println();
        for (Book book : books) {
            System.out.println("Name: " + book.getName() + ", pages: " + book.getPages());
        }
        System.out.println();
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println("Name: " + book.getName() + ", pages: " + book.getPages());
            }
        }
    }

    private static void swap(Book[] books, int first, int second) {
        Book tmp = books[first];
        books[first] = books[second];
        books[second] = tmp;
    }
}
