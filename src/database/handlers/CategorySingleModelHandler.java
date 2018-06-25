package database.handlers;

import database.models.Category;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.util.HashMap;
import java.util.Map;

public class CategorySingleModelHandler extends BeanHandler<Category> {


    public CategorySingleModelHandler() {
        super(Category.class, new BasicRowProcessor(new BeanProcessor(getColumnsToFieldsMap())));
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
