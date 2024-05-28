package bsu.poznyak.projectmanagementapplication.services;

import bsu.poznyak.projectmanagementapplication.models.Task;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ITaskService {
    Optional<Task> CreateTask(String title, String description, Timestamp deadline, int user_id);
    Optional<List<Task>> GetAllTasks(int user_id);
    Optional<Task> GetTaskByIdAndUserId(int id, int user_id);
    void DeleteTaskByIdAndUserId(int id, int user_id);
    void UpdateTask(String title, String description, Timestamp deadline, int task_id, int user_id);
}
