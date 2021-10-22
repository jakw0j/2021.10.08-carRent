package pl.edu.java.wszib.car.rent.database;

import org.apache.commons.codec.digest.DigestUtils;
import pl.edu.java.wszib.car.rent.model.Car;
import pl.edu.java.wszib.car.rent.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Car> cars = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    private static final Database instance = new Database();

    private Database() {
        cars.add(new Car("Toyota", "Corolla", "KR1", 2005));
        cars.add(new Car("Mercedes", "A", "KR2", 2005));
        cars.add(new Car("BMW", "3", "KR3", 2005));
        cars.add(new Car("Mazda", "5", "KR4", 2005));

        users.add(new User("janusz", DigestUtils.md5Hex("janusz")));
        users.add(new User("arek", DigestUtils.md5Hex("arek")));
        users.add(new User("karol", DigestUtils.md5Hex("karol")));
    }

    public boolean rentCar(String plate) {
        for (Car car : this.cars) {
            if (car.getPlate().equals(plate) && !car.isRent()) {
                car.setRent(true);
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

    public List<Car> getCars() {
        return cars;
    }

    public static Database getInstance() {
        return instance;
    }
}
