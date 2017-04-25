<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<?php
$reponse = mysql_query("SELECT * FORM com.Acces"); ?>

<form action="" method="get">

    <label>Date accees :
        <input type="text" name="date"/>
    </label>

    <label>Image :
        <input type="text" name="img"/>
    </label>

    <label>com.Voiture :
        <input type="text" name="img"/>
    </label>

    <label>Plaque :
        <input type="text" name="img"/>
    </label>

    <label>com.Proprietaire :
        <input type="text" name="img"/>
    </label>

    <label>com.Operateur:
        <input type="text" name="img"/>
    </label>
</form>


</body>
</html>