<%--
  Created by IntelliJ IDEA.
  User: leeco
  Date: 2017/8/24
  Time: 下午4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page isELIgnored ="false" %>--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    ${spitter.toString()}
    <br/>
    <c:forEach var="spittle" items="${spittles}">
        ${spittle.spittleText}
        <br/>
        ${spittle.postedTime}
        <br/>
    </c:forEach>
</body>
</html>
