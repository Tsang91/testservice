package de.pandawan.MySqlDatabaseService;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vuong on 27.03.16.
 */
public class ISqlQueryCreatorTest {

    @Test
    public void testQueryIsNotNull() throws Exception{
        //arrange
        String query = new String("select * from password");
        ISqlQueryCreator queryCreator = new SqlQueryCreator();

        //act
        QueryContextItem contextItem = queryCreator.createQueryContextItem(query);

        //assert
        Assert.assertTrue("QueryObject shouldn't be null", contextItem != null);
    }

}