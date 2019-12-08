<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customers</title>
    <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/style.css"/>
</head>

<body>
<div id="wrapper";>
    <div id="header";>
        <h2> CRM Customer Relationship Manager</h2>
    </div>
</div>

<div id="container";>
    <div id="content";>

        <input type="button" value="Add customer"
               onclick="window.location.href='showFormForAdd'; return false;"
        class="add-button"/>
<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>email</th>
        <th>Action</th>
    </tr>

    <c:forEach var="tempCustomer" items="${customers}">

        <c:url var="updateLink" value="/customer/showFormForUpdate">
            <c:param name="customerId" value="${tempCustomer.id}"/>
        </c:url>

        <c:url var="deleteLink" value="/customer/delete">
            <c:param name="customerId" value="${tempCustomer.id}"/>
        </c:url>

        <tr>
            <td>${tempCustomer.firstName}</td>
            <td>${tempCustomer.lastName}</td>
            <td>${tempCustomer.email}</td>
            <td>
                <a href="${updateLink}">Update</a>
                |
                <a href="${deleteLink}"
                onclick="if (!(confirm('Are sure you wanna delete this fellow here?'))) return false"
                >Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
            </div>
</div>
</body>
</html>
