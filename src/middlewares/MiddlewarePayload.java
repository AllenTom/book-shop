package middlewares;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MiddlewarePayload {
    private HttpServletRequest request;
    private HttpServletResponse response;
    public HashMap<String,Object> meta = new HashMap<>();

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

    public MiddlewarePayload(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }
}
