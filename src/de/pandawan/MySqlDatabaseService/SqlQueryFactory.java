package de.pandawan.MySqlDatabaseService;

/**
 * Created by vuong on 27.03.16.
 */
public class SqlQueryFactory implements ISqlQueryFactory {
    @Override
    public QueryBuilder generateQuery(String query) {
        return new QueryBuilder(query);
    }
}
