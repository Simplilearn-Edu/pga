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
	<title>Add Subscriber</title>
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
    <h2>Subscriber Information</h2>
    <c:if test="${error==true || success==true}">
        ${message}
    </c:if>
	<div class="formdiv">
		<form action="add" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3>Add new Subscriber</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
                        <td>
                            <label for="subscriber_name">Subscriber Name</label>
                        </td>
                        <td>
                            <input type="text" id="subscriber_name" class="input" name="subscriber_name">
                        </td>
                    </tr>
                    <tr>
						<td>
							<label for="subscriber_age">Subscriber Age</label>
						</td>
						<td>
							<input type="text" id="subscriber_age" class="input" name="subscriber_age">
						</td>
					</tr>
					<tr>
                        <td>
                            <label for="subscriber_gender">Subscriber Gender</label>
                        </td>
                        <td>
                            <input type="radio" id="subscriber_gender_male" name="subscriber_gender" value="Male">
                            <label for="subscriber_gender_male">Male</label>
                            <input type="radio" id="subscriber_gender_female" name="subscriber_gender" value="Female">
                            <label for="subscriber_gender_female">Female</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="subscriber_address">Subscriber Address</label>
                        </td>
                        <td>
                            <textarea id="subscriber_address" class="input" style="height: 200px" name="subscriber_address"></textarea>
                        </td>
                    </tr>
					<tr>
						<td>
							<label for="subscriber_trainer_id">Select Trainer</label>
						</td>
						<td>
							<select id="subscriber_trainer_id" name="subscriber_trainer_id" class="input">
                                <option value="">Select Trainer</option>
                                <c:forEach items="${trainers}" var="trainer">
                                    <option value="${trainer.trainerId}">${trainer.trainerName}</option>
                                </c:forEach>
                            </select>
						</td>
					</tr>
					<tr>
                        <td>
                            <label for="subscription_plan_id">Subscription Plan</label>
                        </td>
                        <td>
                            <select id="subscription_plan_id" name="subscription_plan_id" class="input">
                                <c:forEach items="${subscriptionPlans}" var="plan">
                                    <option value="${plan.planId}">
                                        ${plan.planTitle}
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