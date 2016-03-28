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
        ArrayList<String> selectColumns,
        ArrayList<String> selectTables
    ) throws SQLException
    {
        PreparedStatement statement = null;
        ArrayList<String> aliasValues = new ArrayList<>();
        aliasValues.addAll(selectColumns);
        aliasValues.addAll(selectTables);
        QueryBuilder builder = new QueryBuilder();

        statement = connection.prepareStatement(
            builder.buildSelect(selectColumns.size(),
                selectTables.size()));

        for(String aliasValue : aliasValues){
            statement.setString(aliasValues.indexOf(aliasValue)+1, aliasValue);
        }

        return  statement;
    }
}
