<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet" type="text/css">

<header class="header">
    <div class="table">
        <div class="cell"><img src="${pageContext.request.contextPath}/images/logo_mini.jpg"></div>
        <div class="header_user_name">
            <c:out value="${sessionScope.user.name} id: ${sessionScope.user.stud_id}"/>
            <a href="../index?action=logout">(exit)</a>
        </div>
    </div>
</header>
