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
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BookPicHandler extends RequestHandler {
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
                new Breadcrumb("添加书籍封面", "/admin/dashboard")
        );
        AdminContext adminContext = new AdminContext(breadcrumbList, "书籍");
        ViewInjector injector = new ViewInjector(
                "/template/admin/book/book-add-pic.jsp",
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
        Collection<Part> parts = requestContext.getRequest().getParts();
        Part filePart = requestContext.getRequest().getPart("cover"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        filePart.write("test.jpg");



    }
}
