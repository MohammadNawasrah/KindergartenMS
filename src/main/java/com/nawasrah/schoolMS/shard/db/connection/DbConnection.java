package com.nawasrah.schoolMS.shard.db.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {
    Connection connection();

//    static abstract void closeConnection() throws SQLException;
}