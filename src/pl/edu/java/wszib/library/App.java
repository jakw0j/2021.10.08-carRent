package pl.edu.java.wszib.library;

import pl.edu.java.wszib.library.database.Database;
import pl.edu.java.wszib.library.gui.Gui;

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
                System.out.println("Login:");
                String login = br.readLine();
                System.out.println("Password:");
                String pass = br.readLine();

                success = Database.getInstance().authenticate(login, pass);

                if(success) {
                    success = true;
                    break;
                } else {
                    System.out.println("Incorrect data!");
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
                        Gui.getInstance().listBooks(Database.getInstance().getBooks());
                        break;
                    case "2":
                        System.out.println("Title:");
                        if(Database.getInstance().rentBook(br.readLine())) {
                            System.out.println("Currently unavailable");
                        } else {
                            System.out.println("Invalid title or currenty unavailable");
                        }
                        break;
                    case "3":
                        return;
                    default:
                        System.out.println("Incorrect choice");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
