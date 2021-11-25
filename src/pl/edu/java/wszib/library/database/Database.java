package pl.edu.java.wszib.library.database;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.java.wszib.library.model.Book;
import pl.edu.java.wszib.library.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    private static final Database instance = new Database();

    private Database() {
        books.add(new Book("Toyota", "Corolla", "KR1", 2005));
        books.add(new Book("Mercedes", "A", "KR2", 2005));
        books.add(new Book("BMW", "3", "KR3", 2005));
        books.add(new Book("Mazda", "5", "KR4", 2005));

        users.add(new User("alex", DigestUtils.md5Hex("alex")));
        users.add(new User("mark", DigestUtils.md5Hex("marek")));
        users.add(new User("carol", DigestUtils.md5Hex("carol")));
    }

    public boolean rentCar(String plate) {
        for (Book book : this.books) {
            if (book.getTitle().equals(plate) && !book.isRent()) {
                book.setRent(true);
                return true;
            }
        }

        return false;
    }
    public boolean authenticate(String login, String pass) {
        for(User user: this.users) {
            if(user.getLogin().equals(login) &&
                    user.getPass().equals(DigestUtils.md5Hex(pass))) {
                return true;
            }
        }

        return false;
    }

    public List<Book> getCars() {
        return books;
    }

    public static Database getInstance() {
        return instance;
    }
}
