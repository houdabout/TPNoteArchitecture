<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access</title>
</head>
<body>
<jsp:useBean id="acces" class="com.Acces"/>
<jsp:setProperty name="acces" property="*"/>
<h2 align="center"><span><strong>Access</strong></span></h2>

<table align="center" cellpadding="5" cellspacing="5" border="1">
    <tr>

    </tr>
    <tr bgcolor="#FBEFEF">
        <td><b>Marque</b></td>
        <td><b>Serie</b></td>
        <td><b>Plaque</b></td>
        <td><b>Name</b></td>
        <td><b>Proprietaire</b></td>
         <td><b>Image</b></td>
        <td><b><input type="submit" value="Visualiser"/></b></td>
    </tr>
    <tr bgcolor="#DEB887">
        <td>
            <jsp:getProperty name="acces" property="plaque"/>
        </td>
    </tr>

</table>
</body>
</html>