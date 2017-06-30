<%--
  Created by IntelliJ IDEA.
  User: smatveev
  Date: 27.06.2017
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>TaskData</title>



</head>
<body>
<h1>Task Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">TaskName</th>

    </tr>
    <tr>
        <td>${task.id}</td>
        <td>${task.name}</td>
        <td>${task.done}</td>
    </tr>
</table>
</body>
</html>
