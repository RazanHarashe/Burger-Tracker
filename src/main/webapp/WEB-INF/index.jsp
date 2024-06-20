<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Burger Tracker</title>
</head>
<body>
    <h1>Burger Tracker</h1>
    <table>
        <thead>
            <tr>
                <th>Burger Name</th>
                <th>Restaurant Name</th>
                <th>Rating (out of 5)</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="burger" items="${burgers}">
                <tr>
                    <td>${burger.name}</td>
                    <td>${burger.restaurant}</td>
                    <td>${burger.rating}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>Add a Burger:</h2>
    <form:form modelAttribute="burger" action="/burgers" method="post">
        <form:errors path="*" cssClass="error" />
        <p>
            Burger Name: <form:input path="name" />
            <form:errors path="name" cssClass="error" />
        </p>
        <p>
            Restaurant Name: <form:input path="restaurant" />
            <form:errors path="restaurant" cssClass="error" />
        </p>
        <p>
            Rating: <form:input path="rating" />
            <form:errors path="rating" cssClass="error" />
        </p>
        <p>
            Notes: <form:textarea path="notes" />
            <form:errors path="notes" cssClass="error" />
        </p>
        <p>
            <input type="submit" value="Submit" />
        </p>
    </form:form>
</body>
</html>
