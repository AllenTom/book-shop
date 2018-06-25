package database.models;

import Util.AuthUtil;
import Util.DBUtil;

import java.sql.SQLException;

public class Token extends Model {
    private Long id;
    private String tokenKey;
    private Long userId;

    public Token(String tokenKey, Long userId) {
        this.tokenKey = tokenKey;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Token() {
    }

    public static Token createToken(Long userId) {
        return new Token(AuthUtil.generateTokenKey(), userId);
    }

    @Override
    public void save() throws SQLException {
        String sql = "insert into book.token values (null ,?,?)";
        DBUtil.exceInsert(Token.class, sql, tokenKey, userId);
    }

    public static User readUserFromKey(String tokenKey) throws SQLException {
        String sql = "SELECT user.* FROM user INNER JOIN token ON user.id = token.user_id where token.token_key = ? limit 1";
        return DBUtil.exceQuery(null,User.class,sql,tokenKey);
    }
}
