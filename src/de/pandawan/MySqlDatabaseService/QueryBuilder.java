package de.pandawan.MySqlDatabaseService;

/**
 * Created by vuong on 27.03.16.
 */
public class QueryBuilder {
    public String buildSelect(int columnNamesCount, int tableNamesCount){
        String result = new String();
        result += createSelectSubString(columnNamesCount);
        result += createFromSubString(tableNamesCount);
        return result;
    }

    private String createSelectSubString(int columnNamesCount){
        String result = "select ";

        result = addAlias(columnNamesCount, result);

        return result;
    }

    private  String createFromSubString(int tableNamesCount){
        String result = "from ";

        result = addAlias(tableNamesCount, result);

        return result;
    }

    private String addAlias(int aliasCount, String target){
        for (int i = 0; i < aliasCount; ++i)
        {
            if(i == aliasCount - 1)
                target += "? ";
            else
                target += "?, ";
        }
        return target;
    }
}
