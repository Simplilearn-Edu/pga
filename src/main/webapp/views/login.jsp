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
	<title>${pagetitle}</title>
	<style type="text/css">
	    body{
            font-family:"Arial"
        }

		.formdiv{
			padding: 8px;
			border: 1px solid black;
			display: inline-block;

			margin: auto;
		}

		.input{
			height: 20px;
			padding:8px;
			width: 300px;
		}
	</style>
</head>
<body>
	<div class="formdiv">
		<form action="login" method="POST">
			<table>
				<thead>
					<tr>
						<th><h3>${user} Login</h3></th>
						<c:if test="${error==true || success==true}">
						    ${message}
						</c:if>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<label for="user_name">Username</label>
						</td>
						<td>
							<input type="email" placeholder="${user}@example.com" id="user_email" class="input" name="user_email">
						</td>
					</tr>
					<tr>
						<td>
							<label for="user_password">Password</label>
						</td>
						<td>
							<input type="password" placeholder="Enter your password" id="user_password" class="input" name="user_password">
						</td>
					</tr>
					<tr>
						<td><button type="submit">Login</button></td>
						<!--td><a href="/registration"><button type="button">Registration</button></a></td-->
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>