package de.pandawan.MySqlDatabaseService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vuong on 27.03.16.
 */
public class SqlConnectionFactory implements ISqlConnectionFactory {
    private  LoginToken login;
    private String dbType;

    private Connection connection;

    public SqlConnectionFactory(LoginToken login, String dbType) {
        this.login = login;
        this.dbType = dbType;
    }

    @Override
    public Connection getConnection() throws NullPointerException{
        if(this.connection != null) {
            return this.connection;
        }
        return null;
    }

    @Override
    public void prepareSession() throws SQLException{
        if(dbType.matches("MySql")) {
            this.connection = new MySqlConnectorImpl(login).connecionToDatabase();
        }
    }

    @Override
    public void closeSession() throws SQLException{
        if(this.connection != null) {
            this.connection.close();
            this.connection = null;
        }
    }
}
