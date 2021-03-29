package cinema.users;

import cinema.actions.CreateMovieRoom;
import cinema.actions.Exit;
import my.hyperskill.menu.AbstractOption;
import my.hyperskill.menu.Menu;

public class CinemaManager extends AbstractUser implements CinemaUserInterface {

    public CinemaManager(String email, String password) {
        super(email, password);
    }

    @Override
    AbstractOption loadUserMenu() {
        AbstractOption userMenu = new Menu("Cinema Manager Menu");
        userMenu.put(1, new Menu("Create Movie Room:", new CreateMovieRoom()));
        userMenu.put(0, new Menu("Exit", new Exit()));

        return userMenu;
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    public void createMovieRoom(String name, int rows, int columns) {

    }

}
