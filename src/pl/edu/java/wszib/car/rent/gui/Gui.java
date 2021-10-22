package pl.edu.java.wszib.car.rent.gui;

import pl.edu.java.wszib.car.rent.model.Car;

import java.util.List;

public class Gui {

    private static final Gui instance = new Gui();

    private Gui() {
    }

    public void showMenu() {
        System.out.println("1. Lista aut");
        System.out.println("2. Wypożycz auto");
        System.out.println("3. Wyjdź");
    }

    public void listCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public static Gui getInstance() {
        return instance;
    }
}
