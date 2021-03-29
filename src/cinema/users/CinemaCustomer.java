package cinema.users;

import cinema.actions.BuyOneTicket;
import cinema.actions.Exit;
import cinema.actions.ShowTheSeats;
import cinema.actions.Statistics;
import my.hyperskill.menu.AbstractOption;
import my.hyperskill.menu.Menu;

public class CinemaCustomer extends AbstractUser implements CinemaUserInterface, CinemaCustomerInterface {

    public CinemaCustomer(String email, String password) {
        super(email, password);
    }

    @Override
    AbstractOption loadUserMenu() {
        AbstractOption userMenu = new Menu("Customer Menu");
        userMenu.put(1, new Menu("Show the seats", new ShowTheSeats()));
        userMenu.put(2, new Menu("Buy a ticket", new BuyOneTicket()));
        userMenu.put(3, new Menu("Statistics", new Statistics()));
        userMenu.put(0, new Menu("Exit", new Exit()));

        return userMenu;
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public void buyTicket() {

    }

}
