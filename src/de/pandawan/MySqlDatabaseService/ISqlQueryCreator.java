package de.pandawan.MySqlDatabaseService;

/**
 * Created by vuong on 27.03.16.
 */
public interface ISqlQueryCreator {
    QueryContextItem createQueryContextItem(String query);
}
