package fr.bts.sio.desktop.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {
    private final String jdbcUrl;

    public ConnectionFactory(String databasePath) {
        this.jdbcUrl = "jdbc:sqlite:" + databasePath;
    }

    public Connection open() throws SQLException {
        Connection connection = DriverManager.getConnection(jdbcUrl);
        try (var statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON");
        }
        return connection;
    }
}
