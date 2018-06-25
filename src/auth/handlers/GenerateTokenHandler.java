package auth.handlers;

import common.RequestHandler;
import common.WebConfig;
import database.models.Token;
import database.models.User;
import middlewares.Middleware;
import services.user.UserService;
import services.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.sql.SQLException;

public class GenerateTokenHandler extends RequestHandler {


    @Override
    public Middleware[] getMiddlewares() {
        return new Middleware[0];
    }

    @Override
    public void onGetRequest(RequestContext requestContext) throws ServletException, IOException {


    }

    @Override
    public void onPostRequest(RequestContext requestContext) throws ServletException, IOException {
        String username = requestContext.getRequest().getParameter("username");
        String password = requestContext.getRequest().getParameter("password");
        String redirectURL = requestContext.getRequest().getParameter("redirect-path");
        UserService service = new UserServiceImpl();
        Token token = service.login(username, password);

        // add cookie to response
        Cookie tokenCookie = new Cookie("token", token.getTokenKey());
        tokenCookie.setPath("/");
        tokenCookie.setMaxAge(WebConfig.TOKEN_EXPIRE);
        requestContext.getResponse().addCookie(tokenCookie);

        requestContext.getResponse().sendRedirect(redirectURL);

    }
}
