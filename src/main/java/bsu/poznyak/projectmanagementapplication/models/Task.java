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
}
