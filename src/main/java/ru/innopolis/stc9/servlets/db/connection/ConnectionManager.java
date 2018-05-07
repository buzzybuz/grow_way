package ru.innopolis.stc9.servlets.db.connection;

import java.sql.Connection;

public interface ConnectionManager {
    public Connection getConnection();
}