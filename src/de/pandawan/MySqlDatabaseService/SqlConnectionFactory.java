package de.pandawan.MySqlDatabaseService;

import java.sql.Connection;

/**
 * Created by vuong on 27.03.16.
 */
public class SqlConnectionFactory implements ISqlConnectionFactory {
    private  LoginToken login;
    private String dbType;

    public SqlConnectionFactory(LoginToken login, String dbType) {
        this.login = login;
        this.dbType = dbType;
    }

    @Override
    public Connection establishConnection() {
        Connection connection = null;

        if(dbType.matches("MySql")) {
            try {
                connection = new MySqlConnectorImpl(login).connecionToDatabase();
            } catch (Exception exp) {
                exp.getCause();
            }
        }

        return connection;
    }
}
