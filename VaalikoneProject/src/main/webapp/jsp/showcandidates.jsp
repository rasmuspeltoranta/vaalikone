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
    align-items: center;
  }
  
  
  
  </style>
<body>
<table>
<tr>
	<th>ID</th>
	<th>Sukunimi</th>
	<th>Etunimi</th>
	<th>Puolue</th>
</tr>
<c:forEach var="candidate" items="${sessionScope.allcandidates }">
	<tr>
		<td>${candidate.ehdokas_id }</td>
		<td>${candidate.sukunimi }</td>
		<td>${candidate.etunimi }</td>
		<td>${candidate.puolue }</td>
	 <td>
	 
	 </td>
		
	</tr>
</c:forEach>
</table>
</body>
</html>