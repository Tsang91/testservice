package de.pandawan.MySqlDatabaseService;

import java.sql.Connection;

/**
 * Created by vuong on 27.03.16.
 */
public interface ISqlConnectionFactory {
    public Connection establishConnection();
}
