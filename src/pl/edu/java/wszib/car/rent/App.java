package pl.edu.java.wszib.car.rent;

import pl.edu.java.wszib.car.rent.model.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Toyota", "Corolla", "KR1", 2005));
        cars.add(new Car("Mercedes", "A", "KR2", 2005));
        cars.add(new Car("BMW", "3", "KR3", 2005));
        cars.add(new Car("Mazda", "5", "KR4", 2005));

        System.out.println("1. Lista aut");
        System.out.println("2. Wypożycz auto");
        System.out.println("3. Wyjdź");

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String choose = br.readLine();

            switch (choose) {
                case "1":
                    //
                    break;
                case  "2":
                    //
                    break;
                case "3":
                    break;
                default:
                    // ??
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
