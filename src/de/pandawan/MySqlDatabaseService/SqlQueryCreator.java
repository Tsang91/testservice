package de.pandawan.MySqlDatabaseService;

/**
 * Created by vuong on 27.03.16.
 */
public class SqlQueryCreator implements ISqlQueryCreator {
    @Override
    public QueryContextItem createQueryContextItem(String query) {
        return new QueryContextItem(query);
    }
}
