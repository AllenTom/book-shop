package admin.handlers.admin.book;

import admin.view.Breadcrumb;
import admin.view.contexts.AdminContext;
import admin.view.forms.CreateCategoryForm;
import common.RequestHandler;
import common.ViewInjector;
import common.view.form.FormView;
import common.view.form.FormViewUtil;
import database.models.Category;
import database.models.User;
import middlewares.AuthMiddleware;
import middlewares.Middleware;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class BookAddHandler extends RequestHandler {
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
                new Breadcrumb("书籍", "/admin/dashboard"),
                new Breadcrumb("添加书籍", "/admin/dashboard")
        );
        AdminContext adminContext = new AdminContext(breadcrumbList, "书籍");
        ViewInjector injector = new ViewInjector(
                "/template/admin/book/book-app-pic.jsp",
                requestContext.getRequest(),
                requestContext.getResponse(),
                adminContext
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

        String categoryName = requestContext.getRequest().getParameter("categoryName");
        FormView form = new CreateCategoryForm();
        Category category = new Category();
        try {
            FormViewUtil.bindFormToBean(category, requestContext.getRequest(), form, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            category.save();
            requestContext.getResponse().sendRedirect("/admin/book/table");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
