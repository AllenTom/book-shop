package database.handlers;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.Map;

public class AliasBeanListHandler<T> extends BeanListHandler<T> {
    private Map<String, String> aliasMap;

    public AliasBeanListHandler(Class<? extends T> type) {
        super(type);
    }

    public AliasBeanListHandler(Class<? extends T> type, Map<String, String> aliasMap) {
        super(type, new BasicRowProcessor(new BeanProcessor(aliasMap)));
    }
}
