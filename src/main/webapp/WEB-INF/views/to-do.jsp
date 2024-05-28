<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>To-Do List</title>
    <link href="${pageContext.request.contextPath}/resources/static/css/all.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap-grid.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap-reboot.css" rel="stylesheet">
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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Task Manager</a>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/">Welcome Page</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/controller?action=logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <a href="controller?action=createTask" class="btn btn-success mr-2">Create Task</a>
    </div>
    <div class="list-group">

        <jsp:useBean id="tasks" scope="request" type="java.util.Optional"/>
        <c:forEach var="task" items="${tasks.get()}">
            <div class="list-group-item todo-item">
                <a href="controller?action=viewTask&id=${task.getId()}">${task.title}</a>
                <div>
                    <a href="controller?action=editTask&id=${task.getId()}" class="btn btn-secondary btn-sm">Edit</a>
                    <button onclick="deleteTask(1)" class="btn btn-danger btn-sm">Delete</button>
                </div>
            </div>
        </c:forEach>
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

