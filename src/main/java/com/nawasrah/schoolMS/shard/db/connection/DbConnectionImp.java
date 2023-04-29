package com.nawasrah.schoolMS.shard.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionImp implements DbConnection {

    private Connection connection;

    public DbConnectionImp(String connectionString) throws SQLException {
        connection = DriverManager.getConnection(connectionString);
    }

    @Override
    public Connection connection() {
        return connection;
    }

    @Override

    public void closeConnection() throws SQLException {
        connection.close();
    }
}