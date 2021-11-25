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
        books.add(new Book("Coaching", "Mark Newton", "Smile", 2005));
        books.add(new Book("Productivity", "Andrew Jax", "Being here and now", 2005));
        books.add(new Book("Autobiography", "Barack Obama", "Yes, we can", 2005));
        books.add(new Book("True crime", "Donald Tusk", "My life as F1 driver", 2005));

        users.add(new User("alex", DigestUtils.md5Hex("alex")));
        users.add(new User("mark", DigestUtils.md5Hex("marek")));
        users.add(new User("carol", DigestUtils.md5Hex("carol")));
    }

    public boolean rentBook(String title) {
        for (Book book : this.books) {
            if (book.getTitle().equals(title) && !book.isRent()) {
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

    public List<Book> getBooks() {
        return books;
    }

    public static Database getInstance() {
        return instance;
    }
}
