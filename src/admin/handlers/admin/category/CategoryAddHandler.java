package admin.handlers.admin.category;

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

public class CategoryAddHandler extends RequestHandler {
    private Middleware[] middlewares = {new AuthMiddleware()};


    @Override
    public Middleware[] getMiddlewares() {
        return middlewares;
    }

    @Override
    public void onGetRequest(RequestHandler.RequestContext requestContext) throws ServletException, IOException {
        User user = (User) requestContext.getMeta().get("user");
        if (user == null) {
            requestContext.getResponse().sendRedirect("/admin/login");
            return;
        }
        List<Breadcrumb> breadcrumbList = Arrays.asList(
                new Breadcrumb("设置", "/admin/dashboard"),
                new Breadcrumb("分类", "/admin/dashboard"),
                new Breadcrumb("添加分类", "/admin/dashboard")
        );
        AdminContext adminContext = new AdminContext(breadcrumbList, "分类");
        ViewInjector injector = new ViewInjector(
                "/template/admin/category/category-create.jsp",
                requestContext.getRequest(),
                requestContext.getResponse(),
                adminContext
        );
        injector.renderTemplate();

    }

    @Override
    public void onPostRequest(RequestHandler.RequestContext requestContext) throws ServletException, IOException {
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
            requestContext.getResponse().sendRedirect("/admin/category/table");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
