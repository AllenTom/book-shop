package database.handlers;

import database.models.Category;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.HashMap;
import java.util.Map;

public class CategoryModelHandler extends BeanListHandler<Category> {
    public CategoryModelHandler() {
        super(Category.class,new BasicRowProcessor(new BeanProcessor(getColumnsToFieldsMap())));
    }


    private static Map<String, String> getColumnsToFieldsMap() {
        Map<String, String> columnsToFieldsMap = new HashMap<>();
        columnsToFieldsMap.put("id", "id");
        columnsToFieldsMap.put("category_name", "categoryName");
        columnsToFieldsMap.put("create_at", "createAt");
        columnsToFieldsMap.put("update_at", "updateAt");
        return columnsToFieldsMap;
    }
}
