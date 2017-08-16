<%--
  Created by IntelliJ IDEA.
  User: leeco
  Date: 2017/8/15
  Time: 下午6:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <mvc:form modelAttribute="person" action="registerBean.html" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td>
                    <mvc:input path="name"/>
                </td>
            </tr>

            <tr>
                <td>密码：</td>
                <td>
                    <mvc:password path="password"/>
                </td>
            </tr>

            <tr>
                <td>生日：</td>
                <td>
                    <mvc:input path="birthday"/>
                </td>
            </tr>

            <tr>
                <td>薪水：</td>
                <td>
                    <mvc:input path="salay"/>
                </td>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" name="提交"></td>
            </tr>
        </table>
    </mvc:form>
</body>
</html>
