<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>Subscriber :: ${subscriber.subscriberName}</title>
        <style type="text/css">
        		table,th,td{
        			border: 1px solid black;
        			border-collapse: collapse;
        			padding:8px;
        			text-align: center;
        		}
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <h2>Subscriber Information</h2>
        <c:if test="${error==true || success==true}">
            ${message}
        </c:if>
        <table>
    		<thead>
    			<tr>
    				<th colspan="2"><h3>${subscriber.subscriberName}</h3></th>
    			</tr>
    		</thead>
    		<tbody>
    			<tr>
    				<td>ID</td>
    				<td>${subscriber.subscriberId}</td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>${subscriber.subscriberGender}</td>
                </tr>
                <tr>
                    <td>Age(Years)</td>
                    <td>${subscriber.subscriberAge}</td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>${subscriber.subscriberAddress}</td>
                </tr>

                <tr>
                    <td>Paid Fees</td>
                    <td>${subscriber.subscriberFeesPaid}</td>
                </tr>
                <tr>
                    <td>Allocated Trainer</td>
                    <td><a href="/trainer/${subscriber.trainer.trainerId}">${subscriber.trainer.trainerName}</a></td>
                </tr>
                <tr>
                    <td>Subscription Plan</td>
                    <td><a href="/subscriptionplan/${subscriber.subscriptionPlan.planId}">${subscriber.subscriptionPlan.planTitle}</a></td>
                </tr>
                <tr>
                    <td>Subscriber Status</td>
                    <td>
                        <c:if test="${subscriber.subscriberStatus == false}">
                            Inactive
                        </c:if>
                        <c:if test="${subscriber.subscriberStatus == true}">
                            Active
                        </c:if>
                    </td>
                </tr>
    		</tbody>
    	</table>
    </body>
</html>