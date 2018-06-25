package database.models.dao;

import Util.DBUtil;
import Util.SqlUtil;
import database.handlers.AliasBeanListHandler;
import database.models.Book;
import database.models.Category;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BookDAO {


    public static void save(Book book) {
        String sql = "insert into book.book values (NULL,?,?,?,?,?,?,?,?)";
        Date now = Calendar.getInstance().getTime();
        String nowStr = SqlUtil.convertDateToSqlString(now);
        try {
            DBUtil.exceInsert(
                    Book.class,
                    sql,
                    book.getName(),
                    book.getPrices(),
                    book.getCount(),
                    book.getOrder(),
                    book.isHidden(),
                    book.getBooktypeid(),
                    nowStr,
                    nowStr
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
        BeanListHandler handler = new AliasBeanListHandler(Book.class,getAliasMap());
        String sql = "SELECT * FROM book.book";
        return DBUtil.exceQueryMultiple(handler,Book.class,sql);
    }
    private HashMap<String,String> getAliasMap(){
        return new HashMap<String, String>(){{
            this.put("id","id");
            this.put("prices","prices");
            this.put("count","count");
            this.put("order","order");
            this.put("hidden","hidden");
            this.put("booktypeid","booktypeid");
            this.put("create_at","createAt");
            this.put("update_at","updateAt");
        }};
    }
}
