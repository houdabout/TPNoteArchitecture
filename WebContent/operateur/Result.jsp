<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parking CCTV</title>
</head>
<body BGCOLOR=#FBEFEF>

<h2 align="center"><span><strong>Resultat d'accés</strong></span></h2>

<h3>Voiture</h3>
<p>
    <strong>Plaque :</strong>
    <%=request.getAttribute("plaque")%>

    <strong>Marque :</strong>
    <%=request.getAttribute("marque")%>

    <strong>Serie :</strong>
    <%=request.getAttribute("serie")%>
</p>
<h3>Proprietaire : </h3>
<p>
    <strong>Nom : </strong><%=request.getAttribute("nom")%>
    <strong>Prenom : </strong><%=request.getAttribute("prenom")%>
    <strong>Age : </strong><%=request.getAttribute("age")%>
</p>
<h3>Operateur : </h3>
<p>
    <strong>Username : </strong><%=request.getAttribute("operateur")%>
</p>
<h3>Image : </h3>
<img src="ImageController?id=<%=request.getAttribute("accesID")%>" width="400px"/>

</body>
</html>
