package middlewares;

import database.models.Token;
import database.models.User;

import javax.servlet.http.Cookie;
import java.sql.SQLException;

public class AuthMiddleware implements Middleware {
    @Override
    public MiddlewarePayload handle(MiddlewarePayload payload) {
        String tokenKey = readAuthToken(payload.getRequest().getCookies());
        if (tokenKey == null) {
            payload.meta.put("user", null);
            return payload;
        }

        try {
            User user = Token.readUserFromKey(tokenKey);
            payload.meta.put("user", user);
            return payload;

        } catch (SQLException e) {
            e.printStackTrace();
            payload.meta.put("user", null);
            return payload;
        }

    }

    private String readAuthToken(Cookie[] cookies) {
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
