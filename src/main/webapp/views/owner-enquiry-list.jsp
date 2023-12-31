<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>PG Enquiries</title>
    <style type="text/css">
        		table,th,td{
        			border: 1px solid black;
        			border-collapse: collapse;
        			padding:8px;
        			text-align: trainer;
        		}
        </style>
</head>

<body>
<jsp:include page="owner_header.jsp" ></jsp:include>
<c:if test="${error==true || success==true}">
    ${message}
</c:if>
<h2>PG Places</h2>
<table>
    <thead>
    <tr>
        <th>Enquiry ID</th>
        <th>Name of PG Place</th>
        <th>Enquired By</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${enquiries}" var="enquiry">
        <tr>
            <td>${enquiry.enquiryId}</td>
            <td>${enquiry.place.placeName}</td>
            <td>${enquiry.tenant.tenantName}</td>
            <td>${place.placeStatus==true?"Available":"Occupied"}</td>
            <td>
                <a href="places/${enquiry.place.placeId}"><button>View Place</button></a>
                <a href="tenant/${enquiry.tenant.tenantId}"><button>View Tenant</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="6">${message}</td>
    </tr>
    </tfoot>
</table>
</body>
</html>