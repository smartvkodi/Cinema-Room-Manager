package cinema;

import cinema.actions.CreateMovieRoom;
import cinema.users.CinemaCustomer;

import java.util.Scanner;

public class Cinema {

    private static Scanner scanner;

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            setScanner(scanner);

//            AnonymousUser user = new AnonymousUser();
//            user.browseMenu();

//            CinemaManager manager = new CinemaManager("manager@cinema.net", "password");
//            manager.browseMenu();

//            computeStrategy(AbstractOption chosenOption)
            new CreateMovieRoom().computeStrategy();

            CinemaCustomer customer = new CinemaCustomer("customer@gmail.com", "password");
            customer.browseMenu();
        }
    }

    private static void setScanner(Scanner scanner) {
        Cinema.scanner = scanner;
    }

    public static Scanner getScanner() {
        return Cinema.scanner;
    }

}