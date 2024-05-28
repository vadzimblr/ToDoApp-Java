package bsu.poznyak.projectmanagementapplication.models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Task {
    private Integer id;
    private String title;
    private String description;
    private Timestamp deadline;
    private int user_id;
    public Task(){

    }
    public Task(String title, String description, Timestamp deadline, int user_id) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.user_id = user_id;
    }
}
