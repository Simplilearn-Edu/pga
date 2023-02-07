<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>PG Place :: ${place.placeName}</title>
        <style type="text/css">
        		table,th,td{
        			border: 1px solid black;
        			border-collapse: collapse;
        			padding:8px;
        			text-align: center;
        		}
        </style>
    </head>

    <body>
        <jsp:include page="owner_header.jsp" ></jsp:include>
        <h2>Place Information</h2>
        <c:if test="${error} eq true">
            <h3>${error}</h3>
        </c:if>
        <table>
    		<thead>
    			<tr>
    				<th colspan="2"><h2>${place.placeName}</h2></th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<th>ID</th>
    				<td>${place.placeId}</td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td>${place.placeAddress}</td>
                </tr>
                <tr>
                    <th>City</th>
                    <td>${place.placeCity}</td>
                </tr>
                <tr>
                    <th>Rent</th>
                    <td>${place.placeRent}</td>
                </tr>
                <tr>
                    <th>Status</th>
                    <td>${place.placeStatus==true?"Available":"Occupied"}</td>
                </tr>
    		</tbody>
    	</table>

        <h2>About the Owner</h2>

    	<table>
    	    <tbody>
                <tr>
                    <th>Owner's Name</th>
                    <td>${place.placeOwner.getOwnerName()}</td>
                </tr>
                <tr>
                    <th>Mobile Number</th>
                    <td>${place.placeOwner.getOwnerMobileNo()}</td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td>${place.placeOwner.getOwnerEmail()}</td>
                </tr>
    	    </tbody>
    	</table>
    </body>
</html>