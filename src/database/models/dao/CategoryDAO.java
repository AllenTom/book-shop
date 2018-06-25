package database.models.dao;

import Util.DBUtil;
import Util.SqlUtil;
import database.models.Category;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class CategoryDAO {
    public void save(Category category) throws SQLException {
        String sql = "insert into category values (NULL,?,?,?)";
        Date now = Calendar.getInstance().getTime();
        String nowStr = SqlUtil.convertDateToSqlString(now);
        DBUtil.exceInsert(Category.class, sql, category.getCategoryName(), nowStr, nowStr);
    }
}
