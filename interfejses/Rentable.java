package interfejses;

import users.User;
import exceptions.NoAvailableResourceException;

public interface Rentable {
    void rent(User user) throws NoAvailableResourceException;
    User getUser();
}

