package de.pandawan.MySqlDatabaseService;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by vuong on 27.03.16.
 */
public class ISqlQueryGeneratorTest {

    @Test
    public void testQueryIsNotNull() throws Exception{
        //arrange
        String query = new String("select * from password");
        ISqlQueryGenerator queryCreator = new SqlQueryGenerator();

        //act
        QueryBuilder contextItem = queryCreator.createQueryContextItem(query);

        //assert
        Assert.assertTrue("QueryObject shouldn't be null", contextItem != null);
    }

    @Test
    public void testQueryReturnValueIsNotNull() throws Exception{
        //arrange
        String query = new String("select * from passwordTable");
        ISqlQueryGenerator queryCreator = new SqlQueryGenerator();
        QueryBuilder contextItem = queryCreator.createQueryContextItem(query);
        Connection connection = new SqlConnectionFactory(
            new LoginToken(
                "jdbc:mysql://localhost:32768/PasswordDB",
                "root",
                "root"
                ),
            "MySql"
        ).establishConnection();

        //act
        ResultSet set = connection.createStatement()
            .executeQuery(queryCreator.createQueryContextItem(query).getQuery());

        //assert
        Assert.assertTrue("ResultSet shouldnt be null", set != null);
    }

}