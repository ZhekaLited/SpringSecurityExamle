<%--
  Created by IntelliJ IDEA.
  User: Evgeniy Nechaev
  Date: 06.11.2022
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>SignUp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


</head>
<body style="overflow-y: hidden">
<t:header/>
<div class="intro-section" id="home-section">

    <div class="slide-1" style="background-image: url('images/Personpg.jpg');">
        <div class="container">
            <div class="row align-items-center ">
                <div class="col-12">
                    <div class="row align-items-center">

                        <div class="col-lg-5 ml-sign text-center" data-aos="fade-up" data-aos-delay="500">
                            <c:url value="/j_spring_security_check" var="loginUrl"/>
                            <form:form action="${loginUrl}" method="post" cssClass="form-box" modelAttribute="user">

<%--                                <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">--%>

                                <h3 class="h4 text-black mb-4 lang" key="Sign Up"><spring:message
                                        code="language.Signup"/></h3>
                                <div class="form-group">
                                    <spring:message code="language.Login" var="searchPlaceholder"/>
                                    <input type="text" class="form-control" placeHolder="${searchPlaceholder}"
                                           name="username">
                                    <form:errors cssClass="red__errrorrr" path="login"/>
                                    <br>
                                </div>
                                <div class="form-group">
                                    <spring:message code="language.Password" var="searchPlaceholder"/>
                                    <input type="password" class="form-control" placeholder="${searchPlaceholder}"
                                           name="password">
                                    <form:errors cssClass="red__errrorrr" path="password"/>
                                    <br><br>
                                </div>


                                <div class="btn-group">
                                    <button class="btn btn-primary btn-top btn-pill lang" key="Input"><spring:message
                                            code="language.Input"/></button>
                                </div>
                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="plugin/script.js"></script>

</body>
</html>