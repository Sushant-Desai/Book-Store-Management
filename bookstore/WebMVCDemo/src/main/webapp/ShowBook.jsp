<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*, java.util.*, java.sql.*" %>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<sql:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:localhost:1521:orcl" user="system" password="java"/>

<sql:query dataSource="${db }" var="rs">
SELECT * from books
</sql:query>

<table border="2" width="100%">
	<tr>
		<th>Book Id:</th>
		<th>Book Name:</th>
		<th>Book Author:</th>
		<th>Year:</th>
		<th>Book Price:</th>
	</tr>
	
	<c:forEach var="table" items="${rs.rows}">
	<tr>
		<td><c:out value="${table.bid }"/></td>
		<td><c:out value="${table.bname }"/></td>
		<td><c:out value="${table.author }"/></td>
		<td><c:out value="${table.year }"/></td>
		<td><c:out value="${table.price }"/></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>