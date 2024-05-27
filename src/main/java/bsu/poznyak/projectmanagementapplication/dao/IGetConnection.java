package bsu.poznyak.projectmanagementapplication.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IGetConnection {
    Connection getConnection() throws SQLException;
}
