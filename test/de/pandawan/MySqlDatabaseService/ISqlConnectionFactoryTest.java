package de.pandawan.MySqlDatabaseService;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by vuong on 27.03.16.
 */
public class ISqlConnectionFactoryTest {

    @Test
    public void testSqlConnectionFactory() throws Exception{
        //arrange
        String url = "jdbc:mysql://localhost:32768";
        String user = "root";
        String password = "root";
        LoginToken login = new LoginToken(url, user, password);
        ISqlConnectionFactory connectionFactory= new SqlConnectionFactory(login, "MySql");

        //act
        Connection connection = connectionFactory.establishConnection();

        //assert
        Assert.assertTrue("Connection shoudln't be null", connection != null);
    }
}