package admin.handlers;

import admin.handlers.admin.DashBoardHandler;
import admin.handlers.admin.account.ChangePasswordHandler;
import admin.handlers.admin.book.BookAddHandler;
import admin.handlers.admin.book.BookPicHandler;
import admin.handlers.admin.book.BookTableHandler;
import admin.handlers.admin.category.CategoryAddHandler;
import admin.handlers.admin.category.CategoryTableHandler;
import admin.handlers.common.TableHandler;
import admin.view.Breadcrumb;
import common.RequestHandler;
import database.models.Category;

import java.util.Arrays;

public class HandlerFactory {
    public static RequestHandler dispatchRequest(String url) {
        System.out.println(url);
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
        } else if (url.contains("/book/table")) {
            return new BookTableHandler();
        } else if (url.contains("/book/create")) {
            return new BookAddHandler();
        } else if (url.contains("/book/pic/add")) {
            return new BookPicHandler();
        } else {
            throw new IllegalArgumentException("no match handler");
        }

    }
}
