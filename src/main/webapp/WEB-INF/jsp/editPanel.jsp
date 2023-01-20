<%--
  Created by IntelliJ IDEA.
  User: Evgeniy Nechaev
  Date: 06.11.2022
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>

<%--<% if (session.getAttribute("login") == null &&--%>
<%--        session.getAttribute("password") == null &&--%>
<%--        session.getAttribute("role") == null) {--%>

<%--    response.sendRedirect(request.getContextPath() + "/login");--%>
<%--} else {--%>
<%--    if (session.getAttribute("role").toString().equals("USER")) {--%>
<%--        response.sendRedirect(request.getContextPath() + "/welcome");--%>
<%--    }--%>
<%--}--%>
<%--%>--%>

<html>
<head>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.5/css/bootstrap-select.min.css">
    <t:add/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <title>Edit-Users</title>
<body style="overflow-x: hidden">
<div class="d29">
    <h1 class="logo-title">Edit User</h1>
    <form:form action="editPanel" method="post" modelAttribute="user">
    <input type="hidden" name="userLogin" value="${login}"/>
    <div class="form-dts">
        <div>
            <form:input cssClass="window-write" path="login" placeholder="Login" value="${login}"/>
            <form:errors cssClass="red__error" path="login"/>
        </div>
        <div>
            <form:input cssClass="window-write" path="password" placeholder="Password" value="${password}"/>
            <form:errors cssClass="red__error" path="password"/>
        </div>
        <div>
            <form:input cssClass="window-write" path="salary" placeholder="Salary" value="${salary}"/>
            <form:errors cssClass="red__error" path="salary"/>
        </div>
        <div>
            <form:input cssClass="window-write" path="name" placeholder="Name" value="${name}"/>
            <form:errors cssClass="red__error" path="name"/>
        </div>
        <div>
            <form:input cssClass="window-write" path="birthday" placeholder="Birthday: dd.mm.yyyy"
                        value="${birthday}"/>
            <form:errors cssClass="red__error" path="birthday"/>
        </div>

        <div class="icon-item">

            <select class="selectpicker" name="roles" multiple data-width="50%">>
                <option name="role" value="Admin" ${selectedAdmin}>ADMIN</option>
                <option name="role" value="User" ${selectedUser}>USER</option>
                <option name="role" value="Author" ${selectedAuthor}>AUTHOR</option>
                <option name="role" value="Manager" ${selectedManager}>MANAGER</option>
                <option name="role" value="Editor" ${selectedEditor}>EDITOR</option>
            </select>
        </div>
    </div>
    <div>

        <div class="btn-group">
            <button class="button">EDIT</button>
        </div>
        </form:form>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.5/js/bootstrap-select.min.js"></script>
    <script src="plugin/script.js"></script>

</body>

</html>

