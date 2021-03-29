package cinema.users;

import cinema.Cinema;
import my.hyperskill.menu.AbstractOption;

abstract class AbstractUser {
    private String userName;
    private String email;
    private String password;
    private final boolean isLoggedIn = false;
    private final AbstractOption userMenu;

    public AbstractUser() {
        this.userName = "Unknown";
        this.userMenu = loadUserMenu();
    }

    public AbstractUser(String email, String password) {
        this.email = email;
        this.password = password;
        this.userMenu = loadUserMenu();
    }

    abstract AbstractOption loadUserMenu();

    public void browseMenu() {
        boolean running;
        do {
            running = !"Exit".equals(this.userMenu
                    .chooseAndCompute(Cinema.getScanner(), false, true)
                    .getOptionName());
        } while (running);
    }

}
