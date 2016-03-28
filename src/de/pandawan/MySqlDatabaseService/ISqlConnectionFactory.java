package de.pandawan.MySqlDatabaseService;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by vuong on 27.03.16.
 */
public interface ISqlConnectionFactory {
    public void prepareSession() throws SQLException;
    public void closeSession() throws SQLException;

    public Connection getConnection() throws NullPointerException;
}
