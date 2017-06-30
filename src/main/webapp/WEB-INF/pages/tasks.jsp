<%--
  Created by IntelliJ IDEA.
  User: smatveev
  Date: 26.06.2017
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Task list</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<c:if test="${!empty allTasks}">
    <table>
        <tr>
            <th width="80">ID</th>
            <th width="120">TASK_NAME</th>
            <th width="120">isDone</th>
        </tr>
        <c:forEach items="${allTasks}" var="task">
            <tr>
                <td>${task.id}</td>
                <td>${task.name}</td>
                <td>${task.done}</td>
                <td><a href="<c:url value='/edit/${task.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${task.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<a href="/tasks/next5">--Next 5 tasks--  </a>
<a href="/tasks/previous5">--Previous 5 task--  </a>
<a href="/alltasks">--All--  </a>
<a href="/alldonetasks">--AllDone--  </a>
<a href="/allnotdonetasks">--AllNotDone--  </a>

<h2>Add a Task</h2>

<c:url var="addAction" value="/tasks/add"/>

<form:form action="${addAction}" commandName="task">
    <table>
        <c:if test="${!empty task.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Task name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="done">
                    <spring:message text="idDone?"/>
                </form:label>
            </td>
            <td>
                    <form:select path="done">
                        <form:option value="false" lable="false"/>
                        <form:option value="true" label="true"/>
                    </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty task.name}">
                    <input type="submit" value="<spring:message text="Edit Task"/>"/>
                </c:if>
                <c:if test="${empty task.name}">
                    <input type="submit"
                           value="<spring:message text="Add Task"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>


</body>
</html>
