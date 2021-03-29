package cinema.actions;

import cinema.Cinema;
import cinema.MovieRoom;
import my.hyperskill.menu.AbstractOption;
import my.hyperskill.menu.OptionAbstractStrategy;

import java.util.Scanner;

public class CreateMovieRoom implements OptionAbstractStrategy {
    int rows;
    int columns;

    @Override
    public void computeStrategy(AbstractOption chosenOption) {
        Scanner scanner = Cinema.getScanner();
        do {
            System.out.println("Enter the number of rows:");
            this.rows = Integer.parseInt(scanner.nextLine());
        } while (rows < 0 || rows > MovieRoom.MAX_ROWS);

        do {
            System.out.println("Enter the number of seats in each row:");
            this.columns = Integer.parseInt(scanner.nextLine());
        } while (columns < 0 || columns > MovieRoom.MAX_COLUMNS);

        MovieRoom room = new MovieRoom("", this.rows, this.columns);
        room.add(room);
    }

    public void computeStrategy() {
        Scanner scanner = Cinema.getScanner();
        do {
            System.out.println("Enter the number of rows:");
            this.rows = Integer.parseInt(scanner.nextLine());
        } while (rows < 0 || rows > MovieRoom.MAX_ROWS);

        do {
            System.out.println("Enter the number of seats in each row:");
            this.columns = Integer.parseInt(scanner.nextLine());
        } while (columns < 0 || columns > MovieRoom.MAX_COLUMNS);

        MovieRoom room = new MovieRoom("Only One room", this.rows, this.columns);
        room.add(room);
    }
}
