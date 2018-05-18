<%--
  Created by IntelliJ IDEA.
  User: Marat
  Date: 06.05.2018
  Time: 3:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>

<head>
  <link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet" type="text/css">
  <title>access form</title>
</head>

<body>

<div class="wrapper">

  <header class="header">
    <table class= "table_border_collapse">
      <th><img src="${pageContext.request.contextPath}/images/logo_mini.jpg"></th>
      <th>
        <form action="${pageContext.request.contextPath}/index" method="post">
          <table class= "text_align_left">
            <tr>
              <th>enter your name or ID</th>
              <th>password</th>
            </tr>
            <tr>
              <th><input type="text" name="userName"></th>
              <th><input class="font_bold" type="password" name="userPassword"></th>
              <th><input class= "button_min_width" type="submit" name="button_login" value="OK"></th>
              <th><input class= "button_min_width" type="submit" name="button_add" value="add me"></th>
            </tr>
          </table>
        </form>
      </th>
    </table>

  </header><!-- .header-->

  <div class="middle">
    <div class= "start_page_reply">
      <%=(request.getParameter("loginReply")!=null) ? request.getParameter("loginReply") : ""%>
    </div>
  </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
  <div class="footer_content">☺ footer ☺</div>
</footer><!-- .footer -->

</body>
</html>

