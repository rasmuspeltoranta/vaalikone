<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Candidate" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ehdokkaat</title>
</head>
<style>
  h1{
  text-align: center;
  font-size: xx-large;
  
  }
  table{
  text-align: center;
  font-size: x-large;
  
  }
  body {
  background-color: #166a8b;
display: flex;
    flex-flow: column wrap;
    flex-direction: column;
    justify-content: space-around;
    align-items: left;
  }
  
  
  
  </style>
<body>

<c:forEach var="candidate" items="${sessionScope.allcandidates }">
<br>
			<h1>${candidate.ehdokas_id } ${candidate.etunimi } ${candidate.sukunimi }</h1>
			<b>Puolue</b>
			${candidate.puolue }<br>
			<b>Kotipaikkakunta</b>
			${candidate.kotipaikkakunta }<br>
			<b>Ikä</b>
			${candidate.ika }<br>
			<b>Ammatti</b>
			${candidate.ammatti }<br>
			<b>Miksi haluat eduskuntaan?</b>
			${candidate.miksi_eduskuntaan }<br>
			<b>Mitä asioita haluat edistää?</b>
			${candidate.mita_asioita_haluat_edistaa }<br>

		

</c:forEach>

</body>
</html>