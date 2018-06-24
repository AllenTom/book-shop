package admin.handlers;

import common.RequestHandler;
import middlewares.Middleware;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author Takay
 */
public class LoginHandler extends RequestHandler {


    @Override
    public Middleware[] getMiddlewares() {
        return new Middleware[0];
    }

    @Override
    public void onGetRequest(RequestContext requestContext) throws ServletException, IOException {
        requestContext.getRequest().getRequestDispatcher("/template/admin/login.jsp").forward(requestContext.getRequest(), requestContext.getResponse());
    }

    @Override
    public void onPostRequest(RequestContext requestContext) {

    }
}
