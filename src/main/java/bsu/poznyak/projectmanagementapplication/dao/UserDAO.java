package bsu.poznyak.projectmanagementapplication.dao;

import bsu.poznyak.projectmanagementapplication.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO extends GenericDAO<User> implements IUserDaoRepository<User>{
    public UserDAO(IGetConnection connectionPool) {
        super(connectionPool);
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                users.add(mapResultSetToEntity(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(int id) {
        User user = null;
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setObject(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = mapResultSetToEntity(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public Optional<User> getByUsername(String username) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = mapResultSetToEntity(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }
    @Override
    public void update(User user) {
        String sql = "UPDATE users SET username = ?, password = ? WHERE id = ?";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    protected User mapResultSetToEntity(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
