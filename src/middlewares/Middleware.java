package middlewares;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Middleware {
    public MiddlewarePayload handle(MiddlewarePayload payload);

}
