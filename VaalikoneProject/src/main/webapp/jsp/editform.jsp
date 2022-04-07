<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Candidate" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Game</title>
</head>
<style>
body{
background-color: #166a8b;

align-items: center;



}
form{
font-size: x-large;
text-align: center;
}


</style>
<body>

	<form action='./editcandidate' method='post'>
		Sukunimi: <input type='text' name='sukunimi' value='${sessionScope.candidate.sukunimi }'><br>
		Etunimi: <input type='text' name='etunimi' value='${sessionScope.candidate.etunimi }'><br>
		Puolue:   <input type='text' name='puolue' value='${sessionScope.candidate.puolue }'><br>
		Kotipaikkakunta: <input type='text' name='kotipaikkakunta' value='${sessionScope.candidate.kotipaikkakunta }'><br>
		Ikä: <input type='number' name='ika' value='${sessionScope.candidate.ika }'><br>
		Miksi eduskuntaan?: <input type='text' name='miksi_eduskuntaan' value='${sessionScope.candidate.miksi_eduskuntaan }'><br>
		Mitä asioita haluat edistaa?: <input type='text' name='mita_asioita_haluat_edistaa' value='${sessionScope.candidate.mita_asioita_haluat_edistaa }'><br>
		Ammatti:<input type='text' name='ammatti' value='${sessionScope.candidate.ammatti }'><br>
		<input type="hidden" name="ehdokas_id" value="${sessionScope.candidate.ehdokas_id }">		
		<input type='submit' name='ok' value='Edit'>
	</form>

</body>
</html>