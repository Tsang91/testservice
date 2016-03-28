package de.pandawan.MySqlDatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by vuong on 27.03.16.
 */
public class SqlQueryFactory implements ISqlQueryFactory {

    @Override
    public PreparedStatement generatePreparedStatement(
        Connection connection,
        ArrayList<String> columns,
        ArrayList<String> tables
    ) throws SQLException
    {
        PreparedStatement statement = null;
        String queryString = new String();
        try {
            QueryBuilder builder = new QueryBuilder();
            queryString += builder.buildSelect(columns.size());
            queryString += builder.addFrom(tables);
            statement = connection.prepareStatement(queryString);

            for(String column : columns){
                statement.setString(columns.indexOf(column) + 1, column);
            }
        }
        catch (SQLException exp){
            exp.getCause();
        }

        return  statement;
    }
}
