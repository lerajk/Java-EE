<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="binary.search.game.model.*" %>

<% 


NumberGuesser target = new NumberGuesser();
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Number Guessing Game</h1>
<p>Pick a number between 0 to 1000. Remember it but don't tell me. I guarantee to guess it in 10 guesses or less
provided you don't change your number and answer my questions truthfully.</p> <br>
<p> I will make a series of guesses. After each guess tell me if my guess is too high or too low or correct.
The game ends when the guess is equal to your number.</p> <br>

<form action="${pageContext.request.contextPath}/Guess.jsp" method="get">
	Click to <input type="submit" value="Begin">
	</form>


</body>
</html>