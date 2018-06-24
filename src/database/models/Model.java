package database.models;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public abstract class Model implements Serializable {
    public abstract void save() throws SQLException;

}
