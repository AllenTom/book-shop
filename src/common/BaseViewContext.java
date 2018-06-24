package common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.function.BiConsumer;

public abstract class BaseViewContext {
    protected HashMap<String,Object> attributes = new HashMap<>();
    /**
     * set view context template
     *
     * @return template path to render. exp "/template/admin/index.jsp"
     */
    public abstract String getTemplate();

    /**
     * render template
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException
     * @throws IOException
     */
    public  void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        attributes.forEach(request::setAttribute);
        request.getRequestDispatcher(getTemplate()).forward(request, response);
    }

    /**
     * get attributes
     */

}
