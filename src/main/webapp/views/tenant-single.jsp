<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>tenant :: ${tenant.tenantName}</title>
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
        <h2>tenant Information</h2>
        <c:if test="${error} eq true">
            <h3>${error}</h3>
        </c:if>
        <table>
    		<thead>
    			<tr>
    				<th colspan="2"><h2>${tenant.tenantName}</h2></th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<td>ID</td>
    				<td>${tenant.tenantId}</td>
                </tr>
                <tr>
                    <td>Mobile</td>
                    <td>${tenant.tenantMobile}</td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>${tenant.tenantGender}</td>
                </tr>
                <tr>
                    <td>Experience</td>
                    <td>${tenant.tenantEmail}</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>${tenant.tenantAddress}</td>
                </tr>
    		</tbody>
    	</table>
    </body>
</html>