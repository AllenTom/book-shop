package admin.handlers.admin.account;

import admin.view.Breadcrumb;
import admin.view.contexts.AdminContext;
import common.RequestHandler;
import common.ViewInjector;
import database.models.User;
import middlewares.AuthMiddleware;
import middlewares.Middleware;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ChangePasswordHandler extends RequestHandler {

    private Middleware[] middlewares = {new AuthMiddleware()};



    @Override
    public Middleware[] getMiddlewares() {
        return middlewares;
    }

    @Override
    public void onGetRequest(RequestContext requestContext) throws ServletException, IOException {
        User user = (User) requestContext.getMeta().get("user");
        if (user == null) {
            requestContext.getResponse().sendRedirect("/admin/login");
            return;
        }
        List<Breadcrumb> breadcrumbList = Arrays.asList(
                new Breadcrumb("设置", "/admin/dashboard"),
                new Breadcrumb("账户", "/admin/dashboard"),
                new Breadcrumb("密码设置", "/admin/account/password")
        );

        AdminContext context = new AdminContext(breadcrumbList, "密码设置");
        context.setBreadcrumbList(breadcrumbList);
        ViewInjector injector = new ViewInjector(
                "/template/admin/account/change-password.jsp",
                requestContext.getRequest(),
                requestContext.getResponse(),
                context
        );
        injector.renderTemplate();


    }

    @Override
    public void onPostRequest(RequestContext requestContext) throws ServletException, IOException {
        User user = (User) requestContext.getMeta().get("user");
        if (user == null) {
            requestContext.getResponse().sendRedirect("/admin/login");
            return;
        }

        String originPassword = requestContext.getRequest().getParameter("origin-password");
        String newPassword = requestContext.getRequest().getParameter("new-password");

        if (user.getPassword().equals(originPassword)) {
            try {
                user.changePassword(newPassword);
                requestContext.getResponse().sendRedirect("/admin/account/password?succeed=true");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }


}
