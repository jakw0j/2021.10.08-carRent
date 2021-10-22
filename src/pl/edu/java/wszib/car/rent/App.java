package pl.edu.java.wszib.car.rent;

import pl.edu.java.wszib.car.rent.database.Database;
import pl.edu.java.wszib.car.rent.gui.Gui;
import pl.edu.java.wszib.car.rent.model.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {

        boolean success = false;
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            for(int i = 0; i < 3; i++) {
                System.out.println("Podaj login:");
                String login = br.readLine();
                System.out.println("Podaj haslo:");
                String pass = br.readLine();

                success = Database.getInstance().authenticate(login, pass);

                if(success) {
                    success = true;
                    break;
                } else {
                    System.out.println("Nie prawidłowe dane !!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (success) {
            Gui.getInstance().showMenu();

            try {
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(System.in));
                switch (br.readLine()) {
                    case "1":
                        Gui.getInstance().listCars(Database.getInstance().getCars());
                        break;
                    case "2":
                        System.out.println("Podaj rejestrację:");
                        if(Database.getInstance().rentCar(br.readLine())) {
                            System.out.println("Wypożyczono auto !!");
                        } else {
                            System.out.println("Nieprawidłowa rejestracja lub auto jest zajęte !!");
                        }
                        break;
                    case "3":
                        return;
                    default:
                        System.out.println("Nieprawidłowy wybór !!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
