package bsu.poznyak.projectmanagementapplication.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class GenericDAO<T> implements IDaoRepository<T>{
    protected IGetConnection connectionPool;

    public GenericDAO(IGetConnection connectionPool) {
        this.connectionPool = connectionPool;
    }
    protected abstract T mapResultSetToEntity(ResultSet resultSet);

    protected void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
