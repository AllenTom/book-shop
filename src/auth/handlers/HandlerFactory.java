package auth.handlers;

import admin.handlers.LoginHandler;
import common.RequestHandler;

public class HandlerFactory {
    public static RequestHandler dispatchRequest(String url) {
        if (url.contains("generate")) {
            return new GenerateTokenHandler();
        }
        throw new IllegalArgumentException("no match handler");
    }
}
