package de.pandawan.MySqlDatabaseService;

/**
 * Created by vuong on 27.03.16.
 */
public interface ISqlQueryFactory {
    QueryBuilder generateQuery(String query);
}
