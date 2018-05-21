<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet" type="text/css">

<html>
<head>
    <title>dashboard</title>
</head>
<body>

<div class="wrapper">
    <c:import url="header.jsp" />

    <div class="middle">
        <div class="container">
            <main class="content">
                <strong>Content:</strong> Sed placerat accumsan ligula. Aliquam felis magna, congue quis, tempus eu,
                aliquam vitae, ante. Cras neque justo, ultrices at, rhoncus a, facilisis eget, nisl. Quisque vitae pede.
                Nam et augue. Sed a elit. Ut vel massa. Suspendisse nibh pede, ultrices vitae, ultrices nec, mollis non,
                nibh. In sit amet pede quis leo vulputate hendrerit. Cras laoreet leo et justo auctor condimentum.
                Integer id enim. Suspendisse egestas, dui ac egestas mollis, libero orci hendrerit lacus, et malesuada
                lorem neque ac libero. Morbi tempor pulvinar pede. Donec vel elit.
            </main><!-- .content -->
        </div><!-- .container-->

        <c:import url="aside.jsp" />
    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <div class="footer_content">☺ footer ☺</div>
</footer><!-- .footer -->

</body>
</html>
