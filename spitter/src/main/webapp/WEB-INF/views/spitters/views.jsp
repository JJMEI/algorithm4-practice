<%--
  Created by IntelliJ IDEA.
  User: leeco
  Date: 2017/8/24
  Time: 下午6:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>WelCome Back Home</title>
</head>
<body>
        欢迎你您 ${spitter.username}
        <br/>
        主要动态
        <c:forEach var="spittle" items="${spittles}">
            ${spittle.spittleText}
            <br>
            创建时间：<small><fmt:formatDate value="${spittle.postedTime}" pattern="yyyy-MM-dd:ss" /></small>
            <br/>
        </c:forEach>
</body>
</html>
