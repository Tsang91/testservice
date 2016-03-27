package de.pandawan.MySqlDatabaseService;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vuong on 27.03.16.
 */
public class ISqlQueryCreatorTest {

    @Test
    public void testQueryIsNotNull(){
        //arrange
        String query = new String("select * from password");
        ISqlQueryCreator queryCreator = new SqlQueryCreator();

        //act
        QueryContextItem contextItem = queryCreator.getQueryFromStatement(query);

        //assert
        Assert.assertTrue("QueryObject shouldn't be null", contextItem != null);
    }

}