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
    private Statement statement;

    public SqlConnectionFactory(LoginToken login, String dbType) {
        this.login = login;
        this.dbType = dbType;
    }
    @Override
    public Statement getStatement() throws NullPointerException{
        if(this.statement != null) {
            return this.statement;
        }
        return null;
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
            if(connection != null)
                this.statement = connection.createStatement();
        }
    }

    @Override
    public void closeSession() throws SQLException{
        if(this.connection != null) {
            this.connection.close();
            this.connection = null;
        }

        if(this.statement != null) {
            this.statement.close();
            this.statement = null;
        }

    }
}
