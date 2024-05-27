<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>To-Do App</title>
    <link href="${pageContext.request.contextPath}/resources/static/css/all.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap-grid.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap-reboot.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .card {
            width: 100%;
            max-width: 400px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-body text-center">
            <h1 class="card-title">Добро пожаловать</h1>
            <p class="card-text">Пожалуйста, авторизируйтесь или зарегистрируйтесь, чтобы продолжить.</p>
            <a href="${pageContext.request.contextPath}/controller?action=login" class="btn btn-primary btn-block">Авторизоваться</a>
            <a href="${pageContext.request.contextPath}/controller?action=register" class="btn btn-secondary btn-block">Зарегистрироваться</a>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.bundle.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>
