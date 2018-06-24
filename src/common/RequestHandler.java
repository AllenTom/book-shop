package common;

import middlewares.Middleware;
import middlewares.MiddlewarePayload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public abstract class RequestHandler {

    public class RequestContext {
        private HttpServletRequest request;
        private HttpServletResponse response;
        private HashMap<String, Object> meta;

        public RequestContext(HttpServletRequest request, HttpServletResponse response, HashMap<String, Object> meta) {
            this.request = request;
            this.response = response;
            this.meta = meta;
        }

        public HttpServletRequest getRequest() {
            return request;
        }

        public void setRequest(HttpServletRequest request) {
            this.request = request;
        }

        public HttpServletResponse getResponse() {
            return response;
        }

        public void setResponse(HttpServletResponse response) {
            this.response = response;
        }

        public HashMap<String, Object> getMeta() {
            return meta;
        }

        public void setMeta(HashMap<String, Object> meta) {
            this.meta = meta;
        }
    }

    abstract public Middleware[] getMiddlewares();

    private MiddlewarePayload applyMiddleware(HttpServletRequest request, HttpServletResponse response) {
        MiddlewarePayload payload = new MiddlewarePayload(request, response);
        for (Middleware middleware: getMiddlewares()) {
            middleware.handle(payload);
        }
        return payload;
    }

    public void dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MiddlewarePayload middlewarePayload = applyMiddleware(request, response);
        RequestContext requestContext = new RequestContext(request, response, middlewarePayload.meta);
        System.out.println(request.getMethod());
        if ("GET".equals(request.getMethod())) {
            onGetRequest(requestContext);
        } else if ("POST".equals(request.getMethod())) {
            onPostRequest(requestContext);
        }
    }

    abstract public void onGetRequest(RequestContext requestContext) throws ServletException, IOException;

    abstract public void onPostRequest(RequestContext requestContext) throws ServletException, IOException;
}
