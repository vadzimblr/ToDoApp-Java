<%--
  Created by IntelliJ IDEA.
  User: vadim
  Date: 26.05.2024
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>To-Do List</title>
    <link href="resources/static/css/all.min.css" rel="stylesheet">
    <link href="resources/static/css/bootstrap.css" rel="stylesheet">
    <link href="resources/static/css/bootstrap-grid.css" rel="stylesheet">
    <link href="resources/static/css/bootstrap-reboot.css" rel="stylesheet">
    <style>
        .todo-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .todo-item a {
            flex-grow: 1;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1>To-Do List</h1>
        <a href="controller?action=createTask" class="btn btn-success mr-2">Create Task</a>
        <a href="controller?action=logout" class="btn btn-danger">Logout</a>
    </div>
    <div class="list-group">
        <div class="list-group-item todo-item">
            <a href="controller?action=viewTask&id=1">Задача 1</a>
            <div>
                <a href="controller?action=editTask&id=1" class="btn btn-secondary btn-sm">Edit</a>
                <button onclick="deleteTask(1)" class="btn btn-danger btn-sm">Delete</button>
            </div>
        </div>
    </div>
</div>

<script>
    function deleteTask(taskId) {
        if (confirm('Are you sure you want to delete this task?')) {
            window.location.href = 'controller?action=deleteTask&id=' + taskId;
        }
    }
</script>
<script src="${pageContext.request.contextPath}/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.bundle.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>

