<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Login</title>
  <!-- Bootstrap CSS -->
  <link href="${pageContext.request.contextPath}/resources/static/css/all.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap-grid.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/static/css/bootstrap-reboot.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card">
        <div class="card-header">
          <h3 class="text-center">User Login</h3>
        </div>
        <div class="card-body">
          <form action="controller" method="post">
            <div class="form-group">
              <label for="username">Username</label>
              <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
              <label for="password">Password</label>
              <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <input type="hidden" name="action" value="login">
            <button type="submit" class="btn btn-primary btn-block">Login</button>
          </form>
        </div>
        <div class="card-footer text-center">
          <p>Нет аккаунта? <a href="${pageContext.request.contextPath}/controller?action=register">Зарегистрироваться</a></p>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Bootstrap JS and dependencies -->
<script src="${pageContext.request.contextPath}/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.bundle.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.js"></script>
</body>
</html>
