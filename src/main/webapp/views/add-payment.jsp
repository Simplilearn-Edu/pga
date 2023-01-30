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
	<title>Add Payments</title>
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
    <h2>Payments</h2>
    <c:if test="${error==true || success==true}">
        ${message}
    </c:if>
	<div class="formdiv">
		<form action="add" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3>Record a New Payment</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
                        <td>
                            <label for="payment_subscriber_id">Payment By</label>
                        </td>
                        <td>
                            <select id="payment_subscriber_id" name="payment_subscriber_id">
                                <c:forEach items="${subscribers}" var="subscriber">
                                <option value=${subscriber.subscriberId}>${subscriber.subscriberName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
						<td>
							<label for="payment_amount">Paid Amount</label>
						</td>
						<td>
							<input type="number" id="payment_amount" class="input" name="payment_amount">
						</td>
					</tr>
					<tr>
                        <td>
                            <label for="payment_mode">Payment Mode</label>
                        </td>
                        <td>
                            <select id="payment_mode" name="payment_mode">
                                <c:forEach items="${payment_mode}" var="mode">
                                <option value=${mode}>${mode}</option>
                                </c:forEach>
                            </select>
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