<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Demo - JSP</title>
</head>


<body>
<center>
    <h1 id="title">springboot使用jsp成功跳转</h1>
</center>

<table>
    <c:forEach items="${userList}" var="user">
        <tr>
            <th>姓名</th>
            <td>${user.name}</td>
            <th>年龄</th>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>