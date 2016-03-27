package de.pandawan.MySqlDatabaseService;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by vuong on 27.03.16.
 */
public class MySqlConnectorImpl implements IMySqlConnector {
    private String url;
    private String user;
    private String password;

    public MySqlConnectorImpl(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public Connection connecionToDatabase() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(this.url, this.user, this.password);
        }
        catch (Exception exp){
            exp.getCause();
        }

        return connection;
    }
}
