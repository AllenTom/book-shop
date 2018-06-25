package database;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;

public class ConnectionPool {
    private static ConnectionPool ourInstance = new ConnectionPool();
    public ComboPooledDataSource dataSource;

    public static ConnectionPool getInstance() {
        return ourInstance;
    }

    private ConnectionPool() {
        dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setJdbcUrl("jdbc:mysql://localhost/book?useSSL=false&&serverTimezone=Hongkong");
        dataSource.setUser("root");
        dataSource.setPassword("dzh17217");

    }
}
