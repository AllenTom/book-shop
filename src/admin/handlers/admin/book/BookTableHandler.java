package admin.handlers.admin.book;

import admin.view.Breadcrumb;
import admin.view.contexts.AdminContext;
import admin.view.contexts.AdminTableContext;
import common.RequestHandler;
import common.ViewInjector;
import database.models.Book;
import database.models.Category;
import database.models.User;
import middlewares.AuthMiddleware;
import middlewares.Middleware;
import services.book.BookService;
import services.book.BookServiceImpl;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class BookTableHandler extends RequestHandler {
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
                new Breadcrumb("书籍", "/admin/dashboard")
        );
        ViewInjector injector = new ViewInjector(
                "/template/admin/book/book-table.jsp",
                requestContext.getRequest(),
                requestContext.getResponse()

        );
        AdminContext adminContext = new AdminContext(breadcrumbList, "书籍");
        injector.addContextProvider(adminContext);
        //set category data

        try {
            BookService service = new BookServiceImpl();
            AdminTableContext<Book> tableContext = new AdminTableContext<>(service.findAll());
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
        Book book = new Book();



    }
}
