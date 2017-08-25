<%--
  Created by IntelliJ IDEA.
  User: leeco
  Date: 2017/8/24
  Time: 下午5:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register for Spitter</title>
</head>
<body>
    <%-- enctype="multipart/form-data" 开启表单上传功能 --%>
    <sf:form modelAttribute="spitter" action="createSpitter" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>UserName</td>
                <td>
                    <sf:input path="username"/>
                    <sf:errors path="username"/>
                </td>
            </tr>

            <tr>
                <td>Password</td>
                <td>
                    <sf:password path="password"/>
                    <sf:errors path="password"/>
                </td>
            </tr>

            <tr>
                <td>FullName</td>
                <td>
                    <sf:input path="fullname"/>
                    <sf:errors path="fullname"/>
                </td>
            </tr>

            <tr>
                <td>Email</td>
                <td>
                    <sf:input path="email"/>
                    <sf:errors path="email"/>
                </td>
            </tr>

            <tr>
                <td>
                    <sf:checkbox path="updateByEmail"/>
                    <sf:label path="updateByEmail"
                    >Send me email updates!</sf:label>

                </td>
            </tr>

            <tr>
                <th><label for="image">Profile Image:</label></th>
                <td><input name="image" type="file"/></td>
            </tr>
            <tr>
                <td>
                    <input name="commit" type="submit" value="I Accept. Create My Count"/>
                </td>
            </tr>
        </table>
    </sf:form>
</body>
</html>
