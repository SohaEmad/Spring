<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05/04/2019
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <jsp:include page="include.jsp" />
</head>
<body>

<div class="container">
    <h2>Bordered Table</h2>
    <p>The .table-bordered class adds borders on all sides of the table and the cells:</p>
    <table class="table table-bordered table-dark">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${alluser}" var="temp">
            <tr>
                <td>${temp.firstname}</td>
                <td>${temp.address}</td>
                <td>${temp.email}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
</html>
