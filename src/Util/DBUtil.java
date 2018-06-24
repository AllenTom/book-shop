package Util;

import database.ConnectionPool;
import database.models.Model;
import database.models.User;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Database util
 *
 * @author TakayamaAren
 */
public class DBUtil {
    /**
     * @param tClass  output model
     * @param sql     sql string
     * @param objects sql query param
     * @param <T>     model type
     * @return type of T model
     * @throws SQLException
     */
    public static <T extends Model> T exceQuery(BeanHandler processor,Class<T> tClass, String sql, Object... objects) throws SQLException {
        Connection conn = ConnectionPool.getInstance().dataSource.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        if (processor == null){
            processor = new BeanHandler<>(tClass);
        }
        T result = queryRunner.query(conn, sql, new BeanHandler<>(tClass), objects);
        conn.close();
        return result;
    }

    /**
     * @param tClass  output model
     * @param sql     sql string
     * @param objects sql query param
     * @param <T>     model type
     * @return type of T model
     * @throws SQLException
     */
    public static <T extends Model> List<T> exceQueryMultiple(BeanListHandler processor,Class<T> tClass, String sql, Object... objects) throws SQLException {
        Connection conn = ConnectionPool.getInstance().dataSource.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        if (processor == null){
            processor = new BeanListHandler<>(tClass);
        }
        List<T> results = (List<T>) queryRunner.query(conn, sql, processor, objects);
        conn.close();
        return results;
    }


    public static <T extends Model> T exceInsert(Class<T> tClass, String sql, Object... objects) throws SQLException {
        Connection conn = ConnectionPool.getInstance().dataSource.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        T result = queryRunner.insert(conn, sql, new BeanHandler<>(tClass), objects);
        conn.close();
        return result;
    }

    public static void exceUpdate(String sql, Object... objects) throws SQLException {
        Connection conn = ConnectionPool.getInstance().dataSource.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(conn, sql, objects);
        conn.close();

    }
}
