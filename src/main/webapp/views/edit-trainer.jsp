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
	<title>Edit Trainer :: ${trainer.trainerName}</title>
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
		}
	</style>
</head>
<body>
    <jsp:include page="header.jsp" ></jsp:include>
    <h2>Trainer Information</h2>
    <c:if test="${error==true || success==true}">
        ${message}
    </c:if>
	<div class="formdiv">
		<form action="/trainer/edit" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3>Edit - ${trainer.trainerName}</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<label for="trainer_name">Trainer Name</label>
						</td>
						<td>
							<input type="hidden" id="trainer_id" class="input" value="${trainer.trainerId}" name="trainer_id">
							<input type="text" id="trainer_name" class="input" value="${trainer.trainerName}" name="trainer_name">
						</td>
					</tr>
					<tr>
                        <td>
                            <label for="trainer_age">Trainer Age</label>
                        </td>
                        <td>
                            <input type="text" id="trainer_age" class="input" value="${trainer.trainerAge}" name="trainer_age">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="trainer_gender">Trainer Gender</label>
                        </td>
                        <td>
                            <input type="radio" id="trainer_gender_male" name="trainer_gender" value="Male" <c:if test="${subscriber.subscriberGender == \"Male\"}">checked</c:if>>
                            <label for="trainer_gender_male">Male</label>
                            <input type="radio" id="trainer_gender_female" name="trainer_gender" value="Female" <c:if test="${subscriber.subscriberGender == \"Female\"}">checked</c:if>>
                            <label for="trainer_gender_female">Female</label>
                        </td>
                    </tr>
					<tr>
						<td>
							<label for="trainer_experience">Trainer Experience</label>
						</td>
						<td>
							<select id="trainer_experience" name="trainer_experience" class="input">
							    <option value="">Select Experience</option>
							    <c:forEach items="${experience}" var="ex">
							        <option value="${ex}" <c:if test="${ex == trainer.trainerExperience}">selected</c:if>>
							            ${ex}
							        </option>
							    </c:forEach>
                            </select>
						</td>
					</tr>
					<tr>
                        <td>
                            <label for="trainer_address">Trainer Address</label>
                        </td>
                        <td>
                            <input type="text" id="trainer_address" class="input" value="${trainer.trainerAddress}" name="trainer_address">
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