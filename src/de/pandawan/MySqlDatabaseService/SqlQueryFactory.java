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
        try {
            ArrayList<String> aliasValuesForPreparedStatement = aliasValuesForPreparedStatement(columns, tables);
            QueryBuilder builder = new QueryBuilder();

            statement = connection.prepareStatement(
                builder.buildSelect(columns.size(),
                    tables.size()));

            for (String aliasValue : aliasValuesForPreparedStatement) {
                statement.setString(aliasValuesForPreparedStatement.indexOf(aliasValue) + 1, aliasValue);
            }
        }
        catch (SQLException exp){
            exp.getCause();
        }

        return  statement;
    }

    private ArrayList<String> aliasValuesForPreparedStatement(
        ArrayList<String> columns,
        ArrayList<String> tables)
    {
        ArrayList<String> aliasValues = new ArrayList<>();
        aliasValues.addAll(columns);
        aliasValues.addAll(tables);
        return aliasValues;
    }
}
