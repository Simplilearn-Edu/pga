<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Header</title>
    <style type="text/css">

		.formdiv{
			padding: 8px;
			border: 1px solid black;
			display: inline-block;

			margin: auto;
			/*width: 50%;*/
		}
        table,th{
            border: 1px solid black;
            border-collapse: collapse;
            padding:24px;
            text-align: center;
        }
		.input{
			height: 20px;
			width: 300px;
		}
	</style>
</head>
<body>
    <table>
        <tbody>
            <tr>
                <th><a href="/subscriber">Subscribers</a></th>
                <th><a href="/trainer">Trainers</a></th>
                <th><a href="/subscriptionplan">Subscription Plans</a></th>
                <th><a href="/payment">Payments</a></th>
                <th><a href="/logout">Log Out</a></th>
                <th colspan="5"><u style="text-align:right">Welcome, ${adminName}</u></th>
            </tr>
        </tbody>
    </table>
</body>
</html>