<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isELIgnored="false" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Create an account</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<header>
		<h1>
			PayIt Registration</span>
		</h1>

	</header>
	<div class="container">

		<form:form method="POST" modelAttribute="userForm" class="form-signin">
			<h2 class="form-signin-heading">Create your account</h2>
			<spring:bind path="firstName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="firstName" class="form-control"
						placeholder="firstName" autofocus="true"></form:input>
					<form:errors path="firstName"></form:errors>
				</div>
			</spring:bind>
			
			<spring:bind path="lastName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="lastName" class="form-control"
						placeholder="lastName" autofocus="true"></form:input>
					<form:errors path="lastName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="dateOfBirth">
            				<div class="form-group ${status.error ? 'has-error' : ''}">
            					<form:input type="text" path="dateOfBirth" class="form-control"
            						placeholder="dateOfBirth" autofocus="true"></form:input>
            					<form:errors path="dateOfBirth"></form:errors>
            				</div>
            </spring:bind>

			<spring:bind path="type">
            			<form:radiobuttons path="type" items="${typeList}" />
             </spring:bind>

			<spring:bind path="emailAddress">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="emailAddress" class="form-control"
						placeholder="emailAddress" autofocus="true"></form:input>
					<form:errors path="emailAddress"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="password" path="password" class="form-control"
						placeholder="password"></form:input>
					<form:errors path="password"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="mobile">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="mobile" class="form-control"
						placeholder="mobile" autofocus="true"></form:input>
					<form:errors path="mobile"></form:errors>
				</div>

			</spring:bind>

			<spring:bind path="shopName">
            				<div class="form-group ${status.error ? 'has-error' : ''}">
            					<form:input type="text" path="shopName" class="form-control"
            						placeholder="shopName" autofocus="true"></form:input>
            					<form:errors path="shopName"></form:errors>
            				</div>

            </spring:bind>




            <spring:bind path="cardNumber">
            				<div class="form-group ${status.error ? 'has-error' : ''}">
            					<form:input type="text" path="cardNumber" class="form-control"
            						placeholder="cardNumber"></form:input>
            					<form:errors path="cardNumber"></form:errors>
            				</div>
            			</spring:bind>

             <spring:bind path="cardExpiryDate">
                        				<div class="form-group ${status.error ? 'has-error' : ''}">
                        					<form:input type="text" path="cardExpiryDate" class="form-control"
                        						placeholder="cardExpiryDate"></form:input>
                        					<form:errors path="cardExpiryDate"></form:errors>
                        				</div>
                        			</spring:bind>

             <spring:bind path="stripPublicKey">
                        				<div class="form-group ${status.error ? 'has-error' : ''}">
                        					<form:input type="text" path="stripPublicKey" class="form-control"
                        						placeholder="stripPublicKey"></form:input>
                        					<form:errors path="stripPublicKey"></form:errors>
                        				</div>
             </spring:bind>



			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>

	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
