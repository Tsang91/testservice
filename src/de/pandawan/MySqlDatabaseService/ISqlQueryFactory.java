package de.pandawan.MySqlDatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by vuong on 27.03.16.
 */
public interface ISqlQueryFactory {
    PreparedStatement generatePreparedStatement(
            Connection connection,
            ArrayList<String> selectColumns,
            ArrayList<String> selectTables
    ) throws SQLException;
}
