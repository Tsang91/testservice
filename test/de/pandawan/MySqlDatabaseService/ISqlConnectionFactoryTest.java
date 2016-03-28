package de.pandawan.MySqlDatabaseService;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vuong on 27.03.16.
 */
public class ISqlConnectionFactoryTest {

    @Test
    public void testPrepareSession() throws Exception {
        //arrange
        ISqlConnectionFactory factory= new SqlConnectionFactory(
                new LoginToken(
                        "jdbc:mysql://localhost:32768/PasswordDB",
                        "root",
                        "root"
                ),
                "MySql"
        );

        //act
        factory.prepareSession();

        //assert
        Assert.assertTrue("Connection shouldn't be null", factory.getConnection() != null);
        Assert.assertTrue("Statement shouldn't be null", factory.getStatement() != null);
        factory.closeSession();
    }

    @Test
    public void testCloseSession() throws Exception {
        //arrange
        ISqlConnectionFactory factory= new SqlConnectionFactory(
                new LoginToken(
                        "jdbc:mysql://localhost:32768/PasswordDB",
                        "root",
                        "root"
                ),
                "MySql"
        );
        factory.prepareSession();

        //act
        factory.closeSession();

        //assert
        Assert.assertTrue("Connection should be null", factory.getConnection() == null);
        Assert.assertTrue("Statement should be null", factory.getStatement() == null);
    }
}