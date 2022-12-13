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

<%--<%--%>
<%--    if (session.getAttribute("login") != null &&--%>
<%--            session.getAttribute("password") != null &&--%>
<%--            session.getAttribute("role") != null) {--%>


<%--        if (session.getAttribute("role").toString().equals("USER")) {--%>
<%--            response.sendRedirect(request.getContextPath() + "/welcome");--%>
<%--        }--%>

<%--        if (session.getAttribute("role").toString().equals("ADMIN")) {--%>
<%--            response.sendRedirect(request.getContextPath() + "/adminMenu");--%>
<%--        }--%>
<%--    } else {--%>
<%--        response.sendRedirect(request.getContextPath() + "/login");--%>
<%--    }--%>
<%--%>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>SignUp</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


</head>
<body>
<t:header/>
<div class="intro-section" id="home-section">

    <div class="slide-1" style="background-image: url('images/Personpg.jpg');">
        <div class="container">
            <div class="row align-items-center ">
                <div class="col-12">
                    <div class="row align-items-center">

                        <div class="col-lg-5 ml-sign text-center" data-aos="fade-up" data-aos-delay="500">
                            <form action="<%=request.getContextPath()%>/login" class="form-box" method="post">
                                <h3 class="h4 text-black mb-4">Sign Up</h3>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="login"
                                           name="login"><br>

                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="password"
                                           name="password"><br><br>
                                </div>
                                <div><input class="btn btn-primary btn-top btn-pill" type="submit" value="Input"></div>
                                <div>
                                    <label class="red__error">
                                        <c:if test="${param.er == 'login' and param.er != 'pasword'}">Invalid login</c:if>
                                        <c:if test="${param.er == 'password' and param.er != 'login'}">Invalid password</c:if>
                                    </label>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
