<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parking CCTV</title>
</head>
<body>
<jsp:useBean id="acces" class="com.Acces"/>
<jsp:setProperty name="acces" property="*"/>

<h2 align="center"><span><strong>result of acces of day</strong></span></h2>

<table align="center" cellpadding="5" cellspacing="5" border="1">
    <tr>

    </tr>
    <tr bgcolor="#FBEFEF">
        <td><b>id</b></td>
        <td><b>user_id</b></td>
        <td><b>Password</b></td>
        <td><b>Name</b></td>
        <td><b>Email</b></td>
    </tr>
    <tr bgcolor="#DEB887">
        <td>
            <jsp:getProperty name="acces" property="plaque"/>
        </td>
    </tr>

</table>
</body>
</html>
