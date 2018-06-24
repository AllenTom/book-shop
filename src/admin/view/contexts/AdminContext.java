package admin.view.contexts;

import admin.view.Breadcrumb;
import common.ContextProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminContext implements ContextProvider {

    private List<Breadcrumb> breadcrumbList;
    private String title;
    private Map<String, Object> contextAttriblutes = new HashMap<>();

    public Map<String, Object> getContextAttriblutes() {
        return contextAttriblutes;
    }

    public void setContextAttriblutes(Map<String, Object> contextAttriblutes) {
        this.contextAttriblutes = contextAttriblutes;
    }

    public AdminContext() {
    }

    public void setBreadcrumbList(List<Breadcrumb> breadcrumbList) {
        this.breadcrumbList = breadcrumbList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Breadcrumb> getBreadcrumbList() {
        return breadcrumbList;
    }

    public String getTitle() {
        return title;
    }

    public AdminContext(List<Breadcrumb> breadcrumbList, String title) {
        this.breadcrumbList = breadcrumbList;
        this.title = title;
    }

    @Override
    public HashMap<String, Object> getAttributes() {
        HashMap<String, Object> viewAttAttribute = new HashMap<>(contextAttriblutes);
        viewAttAttribute.put("breadcrumbList", breadcrumbList);
        viewAttAttribute.put("title", title);
        return viewAttAttribute;
    }

}
