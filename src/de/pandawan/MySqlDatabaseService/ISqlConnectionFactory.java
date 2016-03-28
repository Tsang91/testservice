package de.pandawan.MySqlDatabaseService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vuong on 27.03.16.
 */
public interface ISqlConnectionFactory {
    public void prepareSession() throws SQLException;
    public void closeSession() throws SQLException;

    public Statement getStatement() throws NullPointerException;
    public Connection getConnection() throws NullPointerException;
}
