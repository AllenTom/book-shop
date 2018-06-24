package database.models;


import Util.DBUtil;
import Util.SqlUtil;
import database.handlers.CategoryModelHandler;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Category extends Model implements Serializable {
    private int id;
    private String categoryName;
    private Date createAt;
    private Date updateAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public void save() throws SQLException {
        String sql = "insert into category values (NULL,?,?,?)";
        Date now = Calendar.getInstance().getTime();
        this.updateAt = now;
        this.createAt = now;
        String nowStr = SqlUtil.convertDateToSqlString(now);
        DBUtil.exceInsert(Category.class, sql, this.categoryName, nowStr, nowStr);
    }

    public void updateName(String categoryName) throws SQLException {
        Date now = Calendar.getInstance().getTime();
        String nowStr = SqlUtil.convertDateToSqlString(now);
        String sql = "update category set category_name = ?,update_at = ? where category.id = ?";
        DBUtil.exceUpdate(sql, categoryName, nowStr, this.id);
    }

    public static List<Category> findAll() throws SQLException {
        ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
        String sql = "SELECT * FROM  category";
        return DBUtil.exceQueryMultiple(new CategoryModelHandler(), Category.class, sql);
    }

    public static Category queryById(){
        String sql = "SELECT * FROM  category WHERE id = ?";
        return DBUtil.exceQuery(new CategoryModelHandler(),Category.class,new CategoryModelHandler(), Category.class, sql);
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category() {

    }
}
