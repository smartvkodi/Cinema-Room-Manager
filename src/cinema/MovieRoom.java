package cinema;

import my.hyperskill.menu.AbstractOption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRoom extends AbstractOption {
    public static final int MAX_ROWS = 9;
    public static final int MAX_COLUMNS = 9;

    private static final int PRICE_FRONT_ROW = 10;
    private static final int PRICE_BACK_ROW = 8;
    private static final int THRESHOLD = 60;
    private int lastFrontRow = MAX_ROWS;

    private static final List<MovieRoom> movieRoomList = new ArrayList<>();
    private final char[][] roomSeats;


    public MovieRoom(String name, int rows, int columns) {
        super(name);

        this.roomSeats = new char[rows][columns];
        if (rows * columns > THRESHOLD) {
            this.lastFrontRow = roomSeats.length / 2;
        }
        resetTheRoom();
        movieRoomList.add(this);
    }

    public static MovieRoom getTheRoom(int idx) {
        return movieRoomList.get(idx);
    }

    private void resetTheRoom() {
        for (char[] place : this.roomSeats) {
            Arrays.fill(place, 'S');
        }
    }

    public boolean bookThisSeat(int placeRow, int placeColumn) {
        if ('S' == roomSeats[placeRow - 1][placeColumn - 1]) {
            System.out.printf("\nTicket price: $%d", calculateSeatPrice(placeRow));
            roomSeats[placeRow - 1][placeColumn - 1] = 'B';
            System.out.println();
            return true;
        } else {
            System.out.println("\nThat ticket has already been purchased!");
            return false;
        }
    }

    private int calculateSeatPrice(int row) {
        if (row <= lastFrontRow) {
            return PRICE_FRONT_ROW;
        } else {
            return PRICE_BACK_ROW;
        }
    }

    public int getRowsNumber() {
        return roomSeats.length;
    }

    public int getColumnsNumber() {
        return roomSeats[0].length;
    }

    public void showTheSeats() {
        System.out.print("  ");
        for (int j = 0; j < roomSeats[0].length; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < roomSeats.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < roomSeats[i].length; j++) {
                System.out.print(roomSeats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getPurchasedTickets() {
        int purchaseTickets = 0;
        for (char[] seatsRow : roomSeats) {
            for (char seat : seatsRow) {
                if (seat == 'B') {
                    purchaseTickets++;
                }
            }
        }
        return purchaseTickets;
    }

    public int getCurrentIncome() {
        int currentIncome = 0;
        for (int row = 0; row < roomSeats.length; row++) {
            for (int column = 0; column < roomSeats[0].length; column++) {
                if ('B' == roomSeats[row][column]) {
                    currentIncome += calculateSeatPrice(row + 1);
                }
            }
        }
        return currentIncome;
    }

    public int getTotalIncome() {
        int totalIncome = 0;
        for (int row = 1; row <= roomSeats.length; row++) {
            totalIncome += roomSeats[0].length * calculateSeatPrice(row);
        }
        return totalIncome;
    }
}