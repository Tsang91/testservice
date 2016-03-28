package de.pandawan.MySqlDatabaseService;

import java.util.ArrayList;

/**
 * Created by vuong on 27.03.16.
 */
public class QueryBuilder {
    public String buildSelect(int columnNamesCount){
        String result = new String();
        result += createSelectSubString(columnNamesCount);
        return result;
    }

    public String addFrom(ArrayList<String> tableNameList){
        String result = "from ";
        result += tableNameList.get(0);

        if(tableNameList.size() > 1)
            for(String tableName : tableNameList)
                result += String.format(" AND %1$s", tableName);

        return result;
    }

    private String createSelectSubString(int columnNamesCount){
        String result = "select ";

        result = addAlias(columnNamesCount, result);

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
