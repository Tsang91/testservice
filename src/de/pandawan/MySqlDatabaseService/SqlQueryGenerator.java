package de.pandawan.MySqlDatabaseService;

/**
 * Created by vuong on 27.03.16.
 */
public class SqlQueryGenerator implements ISqlQueryGenerator {
    @Override
    public QueryBuilder createQueryContextItem(String query) {
        return new QueryBuilder(query);
    }
}
