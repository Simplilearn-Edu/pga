<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Subscription Plans</title>
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
        <h2>Subscription Plans</h2>
        <table>
            <thead>
                <tr>
                    <td colspan="5"><a href="subscriptionplan/add-new" style="float:right"><button>Add New SubscriptionPlans</button></a></td>
                </tr>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Duration(Months)</th>
                    <th>Fees</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${subscriptionPlans}" var="subscriptionPlan">
                <tr>
                    <td>${subscriptionPlan.planId}</td>
                    <td>${subscriptionPlan.planTitle}</td>
                    <td>${subscriptionPlan.planDuration}</td>
                    <td>INR. ${subscriptionPlan.planFees}</td>
                    <td>
                        <a href="subscriptionplan/${subscriptionPlan.planId}"><button>View</button></a>
                        <a href="subscriptionplan/edit-plan/${subscriptionPlan.planId}"><button>Edit</button></a>
                        <a href="subscriptionplan/delete/${subscriptionPlan.planId}"><button>Delete</button></a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="5">${message}</td>
                </tr>
            </tfoot>
        </table>
    </body>
</html>