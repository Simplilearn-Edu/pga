<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Add Place</title>
	<style type="text/css">
        td{
            border: 1px solid black;
            border-collapse: collapse;
            padding:24px;
            text-align: center;
        }
		.formdiv{
			padding: 8px;
			border: 1px solid black;
			display: inline-block;
			margin-top: 24px;
		}

		.input{
			height: 20px;
			width: 300px;
			padding: 8px;
		}
	</style>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <h2>Place Information</h2>
    <c:if test="${error==true || success==true}">
        ${message}
    </c:if>
	<div class="formdiv">
		<form action="add" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3>Add new PG Place</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
                        <td>
                            <label for="place_name">Place Name</label>
                        </td>
                        <td>
                            <input type="text" id="place_name" class="input" name="place_name">
                        </td>
                    </tr>
                    <tr>
						<td>
							<label for="place_Address">Place Address</label>
						</td>
						<td>
							<textarea id="place_address" class="input" name="place_address"></textarea>
						</td>
					</tr>
					<tr>
                        <td>
                            <label for="place_rent">Place Rent (INR)</label>
                        </td>
                        <td>
                            <input type="number" id="place_rent" class="input" name="place_rent">
                        </td>
                    </tr>
					<tr>
						<td colspan="2"><button type="submit">Submit</button></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>