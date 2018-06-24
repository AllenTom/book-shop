package admin.handlers.common;

import admin.view.Breadcrumb;
import admin.view.contexts.AdminContext;
import admin.view.contexts.AdminTableContext;
import common.RequestHandler;
import common.ViewInjector;
import database.models.Model;
import database.models.User;
import middlewares.AuthMiddleware;
import middlewares.Middleware;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TableHandler extends RequestHandler {
    private Middleware[] middlewares = {new AuthMiddleware()};
    private List<Breadcrumb> breadcrumbList;
    private String title;
    private Model model;
    private String template;

    public TableHandler(Class cls,List<Breadcrumb> breadcrumbList, String title, String template) {
        this.breadcrumbList = breadcrumbList;
        this.title = title;
        this.template = template;

    }

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
        ViewInjector injector = new ViewInjector(
                template,
                requestContext.getRequest(),
                requestContext.getResponse()

        );
        AdminContext adminContext = new AdminContext(breadcrumbList, title);
        injector.addContextProvider(adminContext);
        //set category data

//        try {
//            List<Model> modelList = model.findAll();
//            AdminTableContext<Model> tableContext = new AdminTableContext<Model>(modelList);
//            injector.addContextProvider(tableContext);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        injector.renderTemplate();

    }

    @Override
    public void onPostRequest(RequestHandler.RequestContext requestContext) throws ServletException, IOException {
        User user = (User) requestContext.getMeta().get("user");
        if (user == null) {
            requestContext.getResponse().sendRedirect("/admin/login");
            return;
        }


    }
}
