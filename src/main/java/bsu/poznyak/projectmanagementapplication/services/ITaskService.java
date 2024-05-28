package bsu.poznyak.projectmanagementapplication.services;

import bsu.poznyak.projectmanagementapplication.models.Task;

import java.sql.Timestamp;
import java.util.Optional;

public interface ITaskService {
    Optional<Task> CreateTask(String title, String description, Timestamp deadline, int user_id);

}
