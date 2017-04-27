<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Search</title>
</head>
<body BGCOLOR=#FBEFEF>
<h2 align="center"><span><strong>Search</strong></span></h2>

<form action="/SearchController" method="get">

    <label>
        Enter Date de debut :
        <input type="date" name="date1"/>
    </label>
    <label>
        Enter Date de debut :
        <input type="date" name="date2"/>
    </label>

    <br/><input type="submit" value="search"/>
</form>

</body>
</html>