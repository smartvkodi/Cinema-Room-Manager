package cinema.actions;

import cinema.MovieRoom;
import my.hyperskill.menu.AbstractOption;
import my.hyperskill.menu.OptionAbstractStrategy;

public class Statistics implements OptionAbstractStrategy {
    @Override
    public void computeStrategy(AbstractOption chosenOption) {

        MovieRoom movieRoom = MovieRoom.getTheRoom(0);

        int numberOfPurchasedTickets = movieRoom.getPurchasedTickets();
        double percentage = (double) (numberOfPurchasedTickets * 100)
                / (movieRoom.getRowsNumber() * movieRoom.getColumnsNumber());

        System.out.printf("\nNumber of purchased tickets: %d" +
                        "\nPercentage: %.2f%" + "%" +
                        "\nCurrent income: $%d" +
                        "\nTotal income: $%d",
                numberOfPurchasedTickets,
                percentage,
                movieRoom.getCurrentIncome(),
                movieRoom.getTotalIncome());
        System.out.println();
    }

}
