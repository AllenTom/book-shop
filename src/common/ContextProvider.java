package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public interface ContextProvider {
    public HashMap<String,Object> getAttributes();
}
