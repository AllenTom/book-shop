package admin.handlers;

import admin.handlers.admin.DashBoardHandler;
import admin.handlers.admin.account.ChangePasswordHandler;
import admin.handlers.admin.category.CategoryAddHandler;
import admin.handlers.admin.category.CategoryTableHandler;
import admin.handlers.common.TableHandler;
import admin.view.Breadcrumb;
import common.RequestHandler;
import database.models.Category;

import java.util.Arrays;

public class HandlerFactory {
    public static RequestHandler dispatchRequest(String url) {
        if (url.contains("login")) {
            return new LoginHandler();
        } else if (url.contains("dashboard")) {
            return new DashBoardHandler();
        } else if (url.contains("/account/password")) {
            return new ChangePasswordHandler();
        } else if (url.contains("/category/table")) {
            return new CategoryTableHandler();
        } else if (url.contains("/category/create")) {
            return new CategoryAddHandler();
        }
        throw new IllegalArgumentException("no match handler");
    }
}
