package database.handlers;

import database.models.Category;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class CategorySingleModelHandler extends BeanHandler<Category> {


    public CategorySingleModelHandler(Class<? extends Category> type, RowProcessor convert) {
        super(Category.class, convert);
    }
}
