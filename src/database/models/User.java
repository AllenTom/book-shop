package database.models;

import Util.DBUtil;

import java.sql.SQLException;

public class User extends Model {
    private Long Id;
    private String username;
    private String password;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public static User findWithUsernamePassword(String username, String password) throws SQLException {
        String sql = "select * from book.user where username = ? and  password = ?";
        return DBUtil.exceQuery(null,User.class, sql, username, password);
    }

    public void changePassword(String newPassword) throws SQLException {
        String sql = "update book.user set book.user.password = ? where book.user.id = ?";
        DBUtil.exceUpdate(sql, newPassword, this.Id);
    }

    @Override
    public void save() {

    }
}
