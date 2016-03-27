package de.pandawan.MySqlDatabaseService;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by vuong on 27.03.16.
 */
public class IMySqlConnectorTest {

    @Test
    public void testReturnValueOfConnectionIsNotNull() throws Exception {
        //arrange
        String url = "jdbc:mysql://localhost:32768";
        String user = "root";
        String password = "root";
        IMySqlConnector connector = new MySqlConnectorImpl(url, user, password);

        //act
        Connection connection = connector.connecionToDatabase();

        //assert
        Assert.assertTrue("Connection shouldn't be null", connection != null);
    }

    @Test
    public void testCreateStatement() throws Exception{
        //arrange
        String url = "jdbc:mysql://localhost:32768";
        String user = "root";
        String password = "root";
        Connection connection = new MySqlConnectorImpl(url, user, password).connecionToDatabase();

        //act
        Statement statement = connection.createStatement();

        //assert
        Assert.assertTrue("Statement shoudln't be null", statement != null);
    }

    @Test
    public void testSqlConnectionFactory() throws Exception{
        //arrange
        LoginToken login = new LoginToken();
        ISqlConnectionFactory connectionFactory= new SqlConnectionFactory(login, "MySql");

        //act
        Connection connection = connectionFactory.establishConnection();

        //assert
        Assert.assertTrue("Connection shoudln't be null", connection != null);
    }
}