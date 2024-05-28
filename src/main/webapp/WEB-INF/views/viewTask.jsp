<jsp:useBean id="task" scope="request" type="java.util.Optional"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Просмотр задачи</title>
  <link href="${pageContext.request.contextPath}/resources/static/css/all.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap-grid.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap-reboot.css" rel="stylesheet">
  <style>
    .task-view .card {
      max-width: 800px;
      margin: 0 auto;
      padding: 20px;
    }
    .task-view .card-title {
      font-size: 2rem;
      margin-bottom: 20px;
    }
    .task-view .card-text {
      font-size: 1.2rem;
      margin-bottom: 10px;
    }
    .task-view .btn-group {
      display: flex;
      gap: 10px;
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
<div class="container mt-5 task-view">
  <div class="card">
    <h1 class="card-title">${task.get().title}</h1>
    <p class="card-text"><strong>Description:</strong> ${task.get().description}</p>
    <p class="card-text"><strong>Deadline:</strong> ${task.get().deadline}</p>
    <div class="btn-group">
      <a href="${pageContext.request.contextPath}/controller?action=editTask&id=${task.get().id}" class="btn btn-secondary">Edit</a>
      <button onclick="deleteTask(${task.get().id})" class="btn btn-danger">Delete</button>
      <a href="${pageContext.request.contextPath}/controller?action=todo" class="btn btn-primary">Back to To-Do List</a>
    </div>
  </div>
</div>

<script>
  function deleteTask(taskId) {
    if (confirm('Вы уверены, что хотите удалить эту задачу?')) {
      window.location.href = 'controller?action=deleteTask&id=' + taskId;
    }
  }
</script>
<script src="${pageContext.request.contextPath}/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.bundle.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>
