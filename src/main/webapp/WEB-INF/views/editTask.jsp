<jsp:useBean id="task" scope="request" type="java.util.Optional"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit task</title>
    <link href="${pageContext.request.contextPath}/resources/static/css/all.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap-grid.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap-reboot.css" rel="stylesheet">
    <style>
        .task-edit .card {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        .task-edit .card-title {
            font-size: 2rem;
            margin-bottom: 20px;
        }
        .task-edit .form-group label {
            font-size: 1.2rem;
        }
        .task-edit .btn-group {
            display: flex;
            gap: 10px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Task Manager</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/controller?action=todo">Todo List</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/controller?action=logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container mt-5 task-edit">
    <div class="card">
        <h1 class="card-title">Edit Task</h1>
        <form action="${pageContext.request.contextPath}/controller?action=editTask&id=${task.get().id}" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" class="form-control" id="title" name="title" value="${task.get().title}" required>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" id="description" name="description" rows="3" required>${task.get().description}</textarea>
            </div>
            <div class="form-group">
                <label for="deadline">Old deadline:</label>
                <p class="card-text"> ${task.get().deadline}</p>
                <input type="hidden" name="oldDeadline" value="${task.get().deadline}" required>
            </div>
            <div class="form-group">
                <label for="deadline">Deadline</label>
                <input type="datetime-local" class="form-control" id="deadline" name="deadline">
            </div>
            <div class="btn-group">
                <button type="submit" class="btn btn-primary">Save</button>
                <a href="${pageContext.request.contextPath}/controller?action=todo" class="btn btn-secondary">Cancel</a>
            </div>
        </form>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.bundle.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>
