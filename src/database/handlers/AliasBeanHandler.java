package database.handlers;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.util.Map;

public class AliasBeanHandler<T> extends BeanHandler<T> {
    private Map<String, String> aliasMap;

    public AliasBeanHandler(Class<? extends T> type) {
        super(type);
    }

    public AliasBeanHandler(Class<? extends T> type, Map<String, String> aliasMap) {
        super(type, new BasicRowProcessor(new BeanProcessor(aliasMap)));
    }
}
