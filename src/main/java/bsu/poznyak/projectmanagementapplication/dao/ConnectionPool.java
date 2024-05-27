package bsu.poznyak.projectmanagementapplication.dao;


import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool implements IGetConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/tododb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private DataSource dataSource;

    public ConnectionPool() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(URL);
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASSWORD);
        dataSource = basicDataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
