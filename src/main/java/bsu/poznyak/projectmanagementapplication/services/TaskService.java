package bsu.poznyak.projectmanagementapplication.services;

import bsu.poznyak.projectmanagementapplication.dao.DaoFactory;
import bsu.poznyak.projectmanagementapplication.dao.ITaskDaoRepository;
import bsu.poznyak.projectmanagementapplication.models.Task;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class TaskService implements ITaskService{
    private final ITaskDaoRepository<Task> taskDaoRepository = DaoFactory.getTaskDaoRepository();
    private static class Validator{
        public static boolean validateTaskParameters(String title, String description, Timestamp deadline, int user_id)
        {
            if (title == null || title.trim().isEmpty()) {
                return false;
            }
            if (description == null || description.trim().isEmpty()) {
                return false;
            }
            if (deadline == null || deadline.before(new Timestamp(System.currentTimeMillis()))) {
                return false;
            }
            if (user_id <= 0) {
                return false;
            }
            return true;
        }
    }
    @Override
    public Optional<Task> CreateTask(String title, String description, Timestamp deadline, int user_id) {
        if(!Validator.validateTaskParameters(title,description,deadline,user_id)){
            return Optional.empty();
        }
        Task task = new Task(title,description,deadline,user_id);
        taskDaoRepository.insert(task);
        return Optional.of(task);
    }

    @Override
    public Optional<List<Task>> GetAllTasks(int user_id) {
        return taskDaoRepository.getAllTasksByUserId(user_id);
    }

    @Override
    public Optional<Task> GetTaskByIdAndUserId(int id, int user_id) {
        return taskDaoRepository.GetTaskByIdAndUserId(id,user_id);
    }

    @Override
    public void DeleteTaskByIdAndUserId(int id, int user_id) {
        taskDaoRepository.deleteByIdAndUserId(id,user_id);
    }

    @Override
    public void UpdateTask(String title, String description, Timestamp deadline, int task_id, int user_id) {
        if(!Validator.validateTaskParameters(title,description,deadline,user_id)){
            return;
        }
        Task task = new Task(task_id,title,description,deadline,user_id);
        taskDaoRepository.update(task);
    }

}
