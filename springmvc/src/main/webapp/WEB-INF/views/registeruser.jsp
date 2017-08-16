<%--
  Created by IntelliJ IDEA.
  User: leeco
  Date: 2017/8/14
  Time: 下午9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Register</title>
    <style>.errorClass{color: red}</style>
</head>
<body>
    <h2>欢迎进行注册</h2>
    <%--@elvariable id="user" type="cn.meijunjie.dao.User"--%>
    <mvc:form modelAttribute="user" action="/springmvc/createUser.html" method="post">
        <%--<mvc:errors path="*"/>--%>

        <table>
            <tr>
                <td>用户名:</td>
                <td>
                   <mvc:input path="userName"/>
                    <mvc:errors cssClass="errorClass" path="userName"/>
                </td>
            </tr>

            <tr>
                <td>密码:</td>
                <td>
                    <mvc:password path="password"/>
                    <mvc:errors path="password" cssClass="errorClass"/>
                </td>
            </tr>

            <tr>
                <td>邮箱:</td>
                <td>
                    <mvc:input path="email"/>
                    <mvc:errors path="email" cssClass="errorClass"/>
                </td>
            </tr>

            <tr>
                <td>姓名:</td>
                <td>
                    <mvc:input path="realName"/>
                    <mvc:errors path="realName" cssClass="errorClass"/>
                </td>
            </tr>

            <tr>
                <td>生日:</td>
                <td>
                    <mvc:input path="birthday"/>
                    <mvc:errors path="birthday" cssClass="errorClass"/>
                </td>
            </tr>
            <tr>
                <td>薪水:</td>
                <td>
                    <mvc:input path="salary"/>
                    <mvc:errors path="salary" cssClass="errorClass"/>
            </tr>

            <tr>
                <td colspan="2"><input type="submit" name="提交"></td>
            </tr>
        </table>
    </mvc:form>
</body>
</html>
