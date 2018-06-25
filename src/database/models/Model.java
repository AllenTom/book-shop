package database.models;

import org.apache.commons.dbutils.handlers.BeanHandler;

import java.io.Serializable;
import java.sql.SQLException;

public abstract class Model<T> implements Serializable {
    public abstract void save() throws SQLException;



}
