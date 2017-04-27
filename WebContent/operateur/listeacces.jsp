<%@ page import="com.model.Acces" %>
<%@ page import="com.model.Proprietaire" %>
<%@ page import="com.model.Voiture" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %><%--
  Created with care and love.
  User: simoe
  Date: 27/04/2017
  Time: 20:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste</title>
</head>
<body BGCOLOR=#FBEFEF>
<%
    List<Acces> accesList = (List<Acces>) request.getAttribute("accesList");
    for (Acces acces : accesList) {
%>
<%
    try {
        Voiture voiture = Voiture.find(acces.getPlaque());

%>
<h3>Voiture</h3>
<p>
    <strong>Plaque :</strong>
    <%=voiture.getPlaque()%>

    <strong>Marque :</strong>
    <%=voiture.getMarque()%>

    <strong>Serie :</strong>
    <%=voiture.getSerie()%>
</p>
<%

    Proprietaire proprietaire = Proprietaire.find(voiture.getProprietaire());
%>
<h3>Proprietaire : </h3>
<p>
    <strong>Nom : </strong><%=proprietaire.getNom()%>
    <strong>Prenom : </strong><%=proprietaire.getPrenom()%>
    <strong>Age : </strong><%=proprietaire.getAge()%>
</p>
<h3>Operateur : </h3>
<p>
    <strong>Username : </strong><%=acces.getOperateur()%>
</p>
<h3>Image : </h3>
<%System.out.println("ID : " + acces.getId());%>
<img src="ImageController?id=<%=acces.getId()%>" width="200px"/>

<%
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
<hr/>
</body>
</html>
