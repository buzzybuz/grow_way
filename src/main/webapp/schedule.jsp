<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet" type="text/css">

<html>
<head>
    <title>schedule</title>
</head>
<body>

<div class="wrapper">
    <c:import url="header.jsp"/>

    <div class="middle">
        <div class="container">
            <main class="content">
                <div class="red_text">
                    <c:out value="${requestScope.err}" default=""/>
                </div>
                <div class="line_height_1_5">
                    <c:forEach items="${requestScope.scheduleList}" var="list">
                        ${list.num}&nbsp&nbsp&nbsp
                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.date_time}"/>
                        &nbsp&nbsp&nbsp${list.lesson_data}<br>
                    </c:forEach>
                </div>
            </main><!-- .content -->
        </div><!-- .container-->

        <c:import url="aside.jsp"/>
    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <div class="footer_content">☺ footer ☺</div>
</footer><!-- .footer -->

</body>
</html>
