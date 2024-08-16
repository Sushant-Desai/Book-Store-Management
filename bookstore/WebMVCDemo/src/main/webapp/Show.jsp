<%@ page import="java.util.List" %>
<%@ page import="com.bean.ShowBookBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Show Books</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f2f2f2;
        }

        p {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>List of Books</h1>

    <c:if test="${not empty bookList}">
        <table border="1">
            <tr>
                <th>Book ID</th>
                <th>Book Name</th>
                <th>Author</th>
                <th>Year</th>
                <th>Price</th>
            </tr>
            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td><c:out value="${book.bid }"/></td>
					<td><c:out value="${book.bname }"/></td>
					<td><c:out value="${book.author }"/></td>
					<td><c:out value="${book.year }"/></td>
					<td><c:out value="${book.price }"/></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${empty bookList}">
        <p>No books available.</p>
    </c:if>
</body>
</html>
