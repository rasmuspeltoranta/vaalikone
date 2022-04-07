<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Candidate" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All datatable rows</title>
</head>
<style>
body{
background-color: #166a8b;
text-align:center;
display: flex;
    flex-flow: column wrap;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
font-size: x-large;

}
table{
text-align:center;
background-color: white;

}
h1{
font-size:xx-large;

}
</style>
<body>
<h1>Ehdokkaat:</h1>

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
	 <a href="/editcandidate?ehdokas_id=${candidate.ehdokas_id }"> Muokkaa</a> <br>
	 </td>
	 <td>
	 <a href="/removecandidate?ehdokas_id=${candidate.ehdokas_id }">Poista</a>
		
	</tr>
</c:forEach>
</table>
 <a href="form.html"> Lisää</a> 

</body>
</html>