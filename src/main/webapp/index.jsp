<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet" type="text/css">
    <title>access form</title>
</head>

<body>

<div class="wrapper">

    <header class="header">
        <div class= "table">
            <div class="cell"><img src="${pageContext.request.contextPath}/images/logo_mini.jpg"></div>
            <div class="cell">
                <form action="${pageContext.request.contextPath}/index" method="post">
                    <div class= "table_login">
                        <div class="row">
                            <div class="cell">enter your name or ID</div>
                            <div class="cell">password</div>
                        </div>
                        <div class="row">
                            <div class="cell"><input type="text" name="userName"></div>
                            <div class="cell"><input type="password" name="userPassword"></div>
                            <div class="cell"><input class= "button_min_width" type="submit" name="button_login" value="OK"></div>
                            <div class="cell"><input class= "button_min_width" type="submit" name="button_add" value="add me"></div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </header><!-- .header-->

    <div class="middle">
        <div class="start_page_reply">
            <c:out value="${param.loginReply}" default=""/>
        </div>
        <jsp:useBean id="date" class="java.util.Date"/>
        <fmt:formatDate type = "both" timeStyle = "short" value = "${date}" />
    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <div class="footer_content">☺ footer ☺</div>
</footer><!-- .footer -->

</body>
</html>

