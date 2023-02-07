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
	<title>Edit Payment :: ${payment.subscriber.subscriberName}</title>
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
		<form action="/payment/edit" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3>Edit Payment</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
                        <td>
                            <label for="payment_subscriber_id">Payment By</label>
                        </td>
                        <td>
                            <input type="hidden" value="${payment_id}" name = "payment_id">
                            <input type="hidden" value="${payment.subscriber.subscriberId}" name = "payment_subscriber_id">
                            <label>${payment.subscriber.subscriberName}</label>
                            <!-- select id="payment_subscriber_id" name="payment_subscriber_id">
                                <c:forEach items="${subscribers}" var="subscriber">
                                    <option value="${subscriber.subscriberId}" <c:if test="${subscriber.subscriberId == payment.subscriber.subscriberId}">selected</c:if>>
                                        ${subscriber.subscriberName}
                                    </option>
                                </c:forEach>
                            </select -->
                        </td>
                    </tr>
                    <tr>
						<td>
							<label for="payment_amount">Paid Amount</label>
						</td>
						<td>
							<input type="hidden" id="old_payment_amount" class="input" name="old_payment_amount" value="${payment.paidAmount}">
							<input type="number" id="payment_amount" class="input" name="payment_amount" value="${payment.paidAmount}">
							<br><label>Out of INR. ${payment.subscriber.subscriptionPlan.planFees}</label>
						</td>
					</tr>

					<tr>
                        <td>
                            <label for="payment_date">Payment Date</label>
                        </td>
                        <td>
                            <input type="date" id="payment_date" class="input" name="payment_date" value="${payment.paymentDate}">
                        </td>
                    </tr>

					<tr>
                        <td>
                            <label for="payment_mode">Payment Mode</label>
                        </td>
                        <td>
                            <select id="payment_mode" name="payment_mode">
                                <c:forEach items="${payment_mode}" var="mode">
                                    <option value="${mode}" <c:if test="${mode == payment.paymentMode}">selected</c:if>>
                                        ${mode}
                                    </option>
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