package admin.handlers.admin;

import common.RequestHandler;
import database.models.User;
import middlewares.AuthMiddleware;
import middlewares.Middleware;

import javax.servlet.ServletException;
import java.io.IOException;

public class DashBoardHandler extends RequestHandler {
    private Middleware[] middlewares = {new AuthMiddleware()};



    @Override
    public Middleware[] getMiddlewares() {
        return middlewares;
    }

    @Override
    public void onGetRequest(RequestContext requestContext) throws ServletException, IOException {
        User user = (User) requestContext.getMeta().get("user");
        if (user == null){
            requestContext.getResponse().sendRedirect("/admin/login");
            return;
        }
        requestContext.getRequest().getRequestDispatcher("/template/admin/index.jsp").forward(requestContext.getRequest(), requestContext.getResponse());
    }

    @Override
    public void onPostRequest(RequestContext requestContext) throws ServletException, IOException {

    }
}
