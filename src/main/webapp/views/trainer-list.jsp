<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Trainers</title>
        <style type="text/css">
        		table,th,td{
        			border: 1px solid black;
        			border-collapse: collapse;
        			padding:8px;
        			text-align: trainer;
        		}
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp" ></jsp:include>
        <c:if test="${error==true || success==true}">
            ${message}
        </c:if>
        <h2>Trainers</h2>
        <table>
            <thead>
                <tr>
                    <td colspan="7"><a href="trainer/add-new" style="float:right"><button>Add New Trainer</button></a></td>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Experience (Years)</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${trainers}" var="trainer">
                <tr>
                    <td>${trainer.trainerId}</td>
                    <td>${trainer.trainerName}</td>
                    <td>${trainer.trainerAge}</td>
                    <td>${trainer.trainerGender}</td>
                    <td>${trainer.trainerExperience}</td>
                    <td>${trainer.trainerAddress}</td>
                    <td>
                        <a href="trainer/${trainer.trainerId}"><button>View</button></a>
                        <a href="trainer/edit-trainer/${trainer.trainerId}"><button>Edit</button></a>
                        <a href="trainer/delete/${trainer.trainerId}"><button>Delete</button></a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="7">${message}</td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>