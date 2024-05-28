package bsu.poznyak.projectmanagementapplication.dao;

import bsu.poznyak.projectmanagementapplication.models.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskDaoRepository<T> extends IDaoRepository<T>{
    Optional<List<Task>> getAllTasksByUserId(int userId);
    Optional<Task> GetTaskByIdAndUserId(int id, int userId);
}
