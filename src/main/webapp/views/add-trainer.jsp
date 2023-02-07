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
	<title>Add Trainer</title>
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
		<form action="add" method="POST">
			<table>
				<thead>
					<tr>
						<th colspan="2"><h3>Add new Trainer</h3></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<label for="trainer_name">Trainer Name</label>
						</td>
						<td>
							<input type="text" id="trainer_name" class="input" name="trainer_name">
						</td>
					</tr>
					<tr>
                        <td>
                            <label for="trainer_age">Trainer Age</label>
                        </td>
                        <td>
                            <input type="text" id="trainer_age" class="input" name="trainer_age">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="trainer_gender">Trainer Gender</label>
                        </td>
                        <td>
                            <input type="text" id="trainer_gender" class="input" name="trainer_gender">
                        </td>
                    </tr>
					<tr>
						<td>
							<label for="trainer_experience">Trainer Experience</label>
						</td>
						<td>
							<select id="trainer_experience" name="trainer_experience" class="input">
                                <option value="">Select Experience</option>
                                <option value="1">1</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                            </select>
						</td>
					</tr>
					<tr>
                        <td>
                            <label for="trainer_address">Trainer Address</label>
                        </td>
                        <td>
                            <textarea type="text" id="trainer_address" class="input" name="trainer_address"></textarea>
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