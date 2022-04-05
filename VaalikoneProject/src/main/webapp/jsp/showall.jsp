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
<body>

<table>
<tr>
	<th>ID</th>
	<th>Sukunimi</th>
	<th>Etuimi</th>
	<th>Puolue</th>
</tr>
<c:forEach var="candidate" items="${sessionScope.allcandidates }">
	<tr>
		<td>${candidate.ehdokas_id }</td>
		<td>${candidate.sukunimi }</td>
		<td>${candidate.etunimi }</td>
		<td>${candidate.puolue }</td>
		
	</tr>
</c:forEach>
</table>

</body>
</html>