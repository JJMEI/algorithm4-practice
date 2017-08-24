<%--
  Created by IntelliJ IDEA.
  User: leeco
  Date: 2017/8/24
  Time: 下午3:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<div>
<head>
    <title>spittle-list</title>
</head>
<body>
    <h2>正在发生的新鲜事</h2>
    <ol class="spittle-list">
        <c:forEach var="spittle" items="${spittles}"> <!--<co id="cp_foreach_spittles"/>-->

            <s:url value="/spitters/{spitterName}"
                   var="spitter_url" >    <!--<co id="cp_spitter_url"/>-->
                <s:param name="spitterName"
                         value="${spittle.spitter.username}" />
            </s:url>

            <li><span class="spittleListImage">
        <img src=
                     "http://s3.amazonaws.com/spitterImages/${spittle.spitter.id}.jpg"
             width="48"
             border="0"
             align="middle"
             onError=
                     "this.src='<s:url value="/resources/images"/>/spitter_avatar.png';"/>
      </span>
                <span class="spittleListText">
        <a href="${spitter_url}">              <!--<co id="cp_spitter_properties"/>-->
          <c:out value="${spittle.spitter.username}" /></a>
          - <c:out value="${spittle.spittleText}" /><br/>
         <small><fmt:formatDate value="${spittle.postedTime}"
                                pattern="yyyy-MM-dd:ss" /></small>
      </span></li>
        </c:forEach>
    </ol>
</body>
</html>
</div>
