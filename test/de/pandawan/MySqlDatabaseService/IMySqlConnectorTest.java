package de.pandawan.MySqlDatabaseService;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

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
}