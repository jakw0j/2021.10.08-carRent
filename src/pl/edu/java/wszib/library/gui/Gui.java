package pl.edu.java.wszib.library.gui;
import pl.edu.java.wszib.library.model.Book;

import java.util.List;

public class Gui {

    private static final Gui instance = new Gui();

    private Gui() {
    }

    public void showMenu() {
        System.out.println("1. List of books");
        System.out.println("2. Rent a book");
        System.out.println("3. Exit");
    }

    public void listCars(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static Gui getInstance() {
        return instance;
    }
}
