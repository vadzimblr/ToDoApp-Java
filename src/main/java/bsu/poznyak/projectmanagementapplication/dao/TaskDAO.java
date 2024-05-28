package bsu.poznyak.projectmanagementapplication.dao;

import bsu.poznyak.projectmanagementapplication.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class TaskDAO extends GenericDAO<Task> implements ITaskDaoRepository<Task> {


    public TaskDAO(IGetConnection connectionPool) {
        super(connectionPool);
    }

    @Override
    public void insert(Task task) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO tasks (id, title, description, deadline, user_id) VALUES (?, ?, ?, ?, ?)")) {
            statement.setObject(1, task.getId());
            statement.setString(2, task.getTitle());
            statement.setString(3, task.getDescription());
            statement.setTimestamp(4, task.getDeadline());
            statement.setObject(5, task.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks")) {
            while (resultSet.next()) {
                Task task = mapResultSetToEntity(resultSet);
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public Task getById(int id) {
        Task task = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM tasks WHERE id = ?")) {
            statement.setObject(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    task = mapResultSetToEntity(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public void update(Task task) {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE tasks SET title = ?, description = ?, deadline = ?, user_id = ? WHERE id = ?")) {
            statement.setString(1, task.getTitle());
            statement.setString(2, task.getDescription());
            statement.setTimestamp(3, task.getDeadline());
            statement.setObject(4, task.getUser_id());
            statement.setObject(5, task.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Task mapResultSetToEntity(ResultSet resultSet){
        Task task = new Task();
        try {
            task.setId(Integer.valueOf(resultSet.getString("id")));
            task.setTitle(resultSet.getString("title"));
            task.setDescription(resultSet.getString("description"));
            task.setDeadline(resultSet.getTimestamp("deadline"));
            task.setUser_id(Integer.parseInt(resultSet.getString("user_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }


    @Override
    public Optional<List<Task>> getAllTasksByUserId(int userId) {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM tasks WHERE user_id = ?")) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Task task = mapResultSetToEntity(resultSet);
                    tasks.add(task);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks.isEmpty() ? Optional.empty() : Optional.of(tasks);
    }

    @Override
    public Optional<Task> GetTaskByIdAndUserId(int id, int userId) {
        Task task = null;
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM tasks WHERE id = ? AND user_id = ?")) {
            statement.setInt(1, id);
            statement.setInt(2, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    task = mapResultSetToEntity(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(task);
    }

}
