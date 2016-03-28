package de.pandawan.MySqlDatabaseService;

import org.junit.Assert;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by vuong on 27.03.16.
 */
public class ISqlQueryFactoryTest {

    @Test
    public void testQueryReturnValueIsNotNull() throws Exception{
        //arrange
        ArrayList<String> selectColumns = new ArrayList();
        ArrayList<String> selectTables = new ArrayList<>();
        selectColumns.add("*");
        selectTables.add("passwordTable");

        ISqlQueryFactory queryFactory = new SqlQueryFactory();
        ISqlConnectionFactory connectionFactory = new SqlConnectionFactory(
            new LoginToken(
                "jdbc:mysql://localhost:32768/PasswordDB",
                "root",
                "root"
                ),
            "MySql"
        );
        connectionFactory.prepareSession();

        PreparedStatement statement = queryFactory
            .generatePreparedStatement(connectionFactory.getConnection(), selectColumns, selectTables);

        //act
        ResultSet set = statement.executeQuery();
        connectionFactory.closeSession();
        set.close();

        //assert
        Assert.assertTrue("ResultSet shouldnt be null", set != null);
    }

}