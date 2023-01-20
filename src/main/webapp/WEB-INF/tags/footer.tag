<%--
  Created by IntelliJ IDEA.
  User: Evigeniy Nechaev
  Date: 16.11.2022
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<body>
<div id="footer">
    <div> <img  src="images/Look.png" class="icon-look" ${hide}>
        <img src="images/face.png" class="icon-facebook cross"
              onclick="location.href='https://ru-ru.facebook.com/'" ${hide}>
        <img src="images/instagram.png" class="icon-instagram cross"
             onclick="location.href='https://www.instagram.com/'" ${hide}>
        <img src="images/4962260.png" class="icon-telegram cross"
             onclick="location.href='https://web.telegram.org/?legacy=1#/login'" ${hide}>
    </div>

    <h4 class="address lang" key="Minsk" ${hide}>Minsk ul.Nemiga 24 </h4>

</div>
<script src="plugin/script.js"></script>
</body>
</html>
