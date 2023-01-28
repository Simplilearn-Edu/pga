<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>PG Places</title>
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
                    <td colspan="6"><a href="places/add-new" style="float:right"><button>Add New Places</button></a></td>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>Name of PG Place</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>Rent</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${places}" var="place">
                <tr>
                    <td>${place.placeId}</td>
                    <td>${place.placeName}</td>
                    <td>${place.placeAddress}</td>
                    <td>${place.placeCity}</td>
                    <td>${place.placeRent}</td>
                    <td><c:if test="${place.placeStatus==true}">Available</c:if></td>
                    <td>
                        <a href="places/${place.placeId}"><button>View</button></a>
                        <a href="places/edit-place/${place.placeId}"><button>Edit</button></a>
                        <a href="places/delete/${place.placeId}"><button>Delete</button></a>
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