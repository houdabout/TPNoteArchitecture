<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>LoginOperateur</title>
</head>
<body BGCOLOR=#FBEFEF>

<h1>login verification operateur</h1>


<form action="LoginServlet" method="post">

    <label>Enter username :
        <input type="text" name="username"/>
    </label>
    <br/>
    <label>Enter Password :
        <input type="password" name="password"/>
    </label>

    <br/><input type="submit" value="Login"/>
    <%
        if (request.getParameter("error") != null) {
    %>
    <p style="color:darkred">Something wrong happened, try again later</p>
    <%
        }
    %>
</form>

</body>
</html>