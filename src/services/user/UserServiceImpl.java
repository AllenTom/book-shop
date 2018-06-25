package services.user;

import database.models.Token;
import database.models.User;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public Token login(String username, String password) {
        try {
            User user = User.findWithUsernamePassword(username, password);
            if (user != null) {
                Token token = Token.createToken(user.getId());
                token.save();
                return token;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
