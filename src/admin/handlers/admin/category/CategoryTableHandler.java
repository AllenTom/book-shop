package admin.handlers.admin.category;

import admin.view.Breadcrumb;
import admin.view.contexts.AdminContext;
import admin.view.contexts.AdminTableContext;
import common.RequestHandler;
import common.ViewInjector;
import database.models.Category;
import database.models.User;
import middlewares.AuthMiddleware;
import middlewares.Middleware;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class CategoryTableHandler extends RequestHandler {
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
                new Breadcrumb("分类", "/admin/dashboard")
        );
        ViewInjector injector = new ViewInjector(
                "/template/admin/category/category-table.jsp",
                requestContext.getRequest(),
                requestContext.getResponse()

        );
        AdminContext adminContext = new AdminContext(breadcrumbList, "分类");
        injector.addContextProvider(adminContext);
        //set category data

        try {
            List<Category> categoryList = Category.findAll();
            AdminTableContext<Category> tableContext = new AdminTableContext<>(categoryList);
            injector.addContextProvider(tableContext);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        injector.renderTemplate();

    }

    @Override
    public void onPostRequest(RequestContext requestContext) throws ServletException, IOException {
        User user = (User) requestContext.getMeta().get("user");
        if (user == null) {
            requestContext.getResponse().sendRedirect("/admin/login");
            return;
        }


    }
}
