<%--
  Created by IntelliJ IDEA.
  User: leeco
  Date: 2017/8/15
  Time: 上午11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page isELIgnored ="false" %>
<html>
<head>
    <title>Show Person Detail</title>
</head>
<body>
        用户名： ${person.name}
        <br>
        密码：   ${person.password}
        <br>
        生日：   ${person.birthday}
        <br>
        薪水：   ${person.salay}
        ${person1.name}
</body>
</html>
