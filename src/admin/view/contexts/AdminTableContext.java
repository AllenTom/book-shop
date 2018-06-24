package admin.view.contexts;

import common.ContextProvider;

import java.util.HashMap;
import java.util.List;

public class AdminTableContext<T> implements ContextProvider {
    private List<T> dataList;
    private HashMap<String, Object> contextAttributes = new HashMap<>();

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
        contextAttributes.put("datas", dataList);
    }

    public AdminTableContext(List<T> dataList) {
        this.setDataList(dataList);
    }

    public AdminTableContext() {
    }

    @Override
    public HashMap<String, Object> getAttributes() {
        return contextAttributes;
    }
}
