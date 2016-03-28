package de.pandawan.MySqlDatabaseService;

/**
 * Created by vuong on 27.03.16.
 */
public interface ISqlQueryGenerator {
    QueryBuilder createQueryContextItem(String query);
}
