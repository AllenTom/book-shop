package common;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ViewInjector extends BaseViewContext {
    private ContextProvider[] providers;
    private String template;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public ViewInjector(String template, HttpServletRequest request, HttpServletResponse response, ContextProvider... providers) {
        this.providers = providers;
        this.template = template;
        this.request = request;
        this.response = response;
    }

    public void addContextProvider(ContextProvider... providers) {
        Arrays.stream(providers).forEach(provider -> attributes.putAll(provider.getAttributes()));
    }

    @Override
    public String getTemplate() {
        return template;
    }

    public void renderTemplate() throws ServletException, IOException {
        Arrays.stream(providers).forEach(provider -> attributes.putAll(provider.getAttributes()));
        super.render(request, response);
    }
}
