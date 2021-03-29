package cinema.actions;

import cinema.Cinema;
import cinema.MovieRoom;
import my.hyperskill.menu.AbstractOption;
import my.hyperskill.menu.OptionAbstractStrategy;

import java.util.Scanner;

public class BuyOneTicket implements OptionAbstractStrategy {

    @Override
    public void computeStrategy(AbstractOption chosenOption) {

        Scanner scanner = Cinema.getScanner();

        MovieRoom movieRoom = MovieRoom.getTheRoom(0);

        boolean successfullyBooked;
        do {
            int seatRow;
            int seatColumn;
            boolean isWrongInput;
            do {
                System.out.println("\nEnter a row number:");
                seatRow = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter a seat number in that row:");
                seatColumn = Integer.parseInt(scanner.nextLine());

                isWrongInput = seatRow < 0 || seatRow > movieRoom.getRowsNumber()
                        || seatColumn < 0 || seatColumn > movieRoom.getColumnsNumber();

                if (isWrongInput) {
                    System.out.println("Wrong input!");
                }
            } while (isWrongInput);


            successfullyBooked = movieRoom.bookThisSeat(seatRow, seatColumn);
        } while (!successfullyBooked);
    }
}
