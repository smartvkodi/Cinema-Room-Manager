package cinema.users;

import cinema.actions.Exit;
import cinema.actions.Login;
import cinema.actions.ShowMovieRooms;
import cinema.actions.SignUp;
import my.hyperskill.menu.AbstractOption;
import my.hyperskill.menu.Menu;

public class AnonymousUser extends AbstractUser {

    public AnonymousUser() {
        super();
    }

    @Override
    AbstractOption loadUserMenu() {
        AbstractOption userMenu = new Menu("User Menu");
        userMenu.put(1, new Menu("Show Movie Rooms", new ShowMovieRooms()));
        userMenu.put(2, new Menu("Login", new Login()));
        userMenu.put(3, new Menu("Don't have an account? Sign Up", new SignUp()));
        userMenu.put(0, new Menu("Exit", new Exit()));

        return userMenu;
    }

}
