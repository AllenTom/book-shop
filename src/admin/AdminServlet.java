package admin;

import admin.handlers.HandlerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Takay
 */
@WebServlet(
        name = "AdminServlet",
        urlPatterns = "/admin/*"
)
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HandlerFactory.dispatchRequest(request.getRequestURI()).dispatch(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getRequestURI());
        HandlerFactory.dispatchRequest(request.getRequestURI()).dispatch(request, response);

    }


}
