<%--
  Created by IntelliJ IDEA.
  User: leeco
  Date: 2017/8/10
  Time: 下午11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>register page</title>
</head>
<body>
    <form action="<c:url value="/Request.html"/>" method="post">

        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="userName"></td>
            </tr>

            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>

            <tr>
                <td>邮箱：</td>
                <td><input type="text" name="email"></td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" name="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
