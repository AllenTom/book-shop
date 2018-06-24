package Util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class SqlUtil {
    public static String convertDateToSqlString(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
