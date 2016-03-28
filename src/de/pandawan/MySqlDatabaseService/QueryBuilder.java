package de.pandawan.MySqlDatabaseService;

/**
 * Created by vuong on 27.03.16.
 */
public class QueryBuilder {
    private String query;

    public QueryBuilder(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
