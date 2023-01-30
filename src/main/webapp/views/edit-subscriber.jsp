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
	<title>Edit Subscriber :: ${subscriber.subscriberName}</title>
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
    <jsp:include page="header.jsp" ></jsp:include>
    <h2>Subscriber Information</h2>
    <c:if test="${error==true || success==true}">
        ${message}
    </c:if>
	<div class="formdiv">
		<form action="/subscriber/edit" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3>Edit Subscriber</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
                        <td>
                            <label for="subscriber_name">Subscriber Name</label>
                        </td>
                        <td>
                            <input type="hidden" id="subscriber_id" class="input" name="subscriber_id" value="${subscriber.subscriberId}">
                            <input type="text" required id="subscriber_name" class="input" name="subscriber_name" value="${subscriber.subscriberName}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="subscriber_age">Subscriber Age</label>
                        </td>
                        <td>
                            <input type="text" required id="subscriber_age" class="input" name="subscriber_age" value="${subscriber.subscriberAge}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="subscriber_address">Subscriber Address</label>
                        </td>
                        <td>
                            <textarea id="subscriber_address" required class="input" name="subscriber_address" value="${subscriber.subscriberAge}">${subscriber.subscriberAddress}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="subscriber_gender">Subscriber Gender</label>
                        </td>
                        <td>
                            <input type="radio" required id="subscriber_gender_male" name="subscriber_gender" value="Male" <c:if test="${subscriber.subscriberGender == \"Male\"}">checked</c:if>>
                            <label for="subscriber_gender_male">Male</label>
                            <input type="radio" required id="subscriber_gender_female" name="subscriber_gender" value="Female" <c:if test="${subscriber.subscriberGender == \"Female\"}">checked</c:if>>
                            <label for="subscriber_gender_female">Female</label>
                        </td>
                    </tr>
					<tr>
                        <td>
                            <label for="subscriber_trainer_id">Subscriber Trainer</label>
                        </td>
                        <td>
                            <select id="subscriber_trainer" name="subscriber_trainer_id">
                                <option value="0">Select Trainer</option>
                                <c:forEach items="${trainers}" var="trainer">
                                    <option value="${trainer.trainerId}" <c:if test="${trainer.trainerId == subscriber.trainer.trainerId}">selected</c:if>>
                                        ${trainer.trainerName}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="subscription_plan_id">Subscription Plan</label>
                        </td>
                        <td>
                            <select id="subscription_plan_id" name="subscription_plan_id">
                                <option value="0">Select Subscription Plan</option>
                                <c:forEach items="${subscriptionPlans}" var="plan">
                                    <option value="${plan.planId}" <c:if test="${plan.planId == subscriber.subscriptionPlan.planId}">selected</c:if>>
                                        ${plan.planTitle}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
					<tr>
					    <input type="hidden" value="${subscriber.subscriberStatus}" name="subscriber_status">
						<td colspan="2"><button type="submit">Submit</button></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>