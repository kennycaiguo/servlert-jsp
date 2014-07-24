<%--
  Created by IntelliJ IDEA.
  User: zdsoft
  Date: 14-7-23
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
${firstName}

<c:forEach var="item" items="${userInfoList}">
${item.name}
</c:forEach>
</body>
</html>
