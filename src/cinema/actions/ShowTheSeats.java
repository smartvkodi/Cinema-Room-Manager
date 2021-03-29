package cinema.actions;

import cinema.MovieRoom;
import my.hyperskill.menu.AbstractOption;
import my.hyperskill.menu.OptionAbstractStrategy;


public class ShowTheSeats implements OptionAbstractStrategy {
    @Override
    public void computeStrategy(AbstractOption chosenOption) {

        System.out.println("\nCinema:");
        MovieRoom movieRoom = MovieRoom.getTheRoom(0);
        movieRoom.showTheSeats();
    }
}
