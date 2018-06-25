package services.user;

import database.models.Token;

public interface UserService {
    public Token login(String username, String password);
}
