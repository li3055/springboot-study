<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
login.jsp
       错误信息：<h4 th:text="${msg}"></h4>
       <form action="" method="post">
           <p>账号：<input type="text" name="username" value="admin"/></p>
           <p>密码：<input type="text" name="password" value="123456"/></p>
           <p><input type="submit" value="登录"/></p>
       </form>
</body>
</html>