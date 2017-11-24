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
			
			<spring:bind path="mobile">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="mobile" class="form-control"
						placeholder="mobile" autofocus="true"></form:input>
					<form:errors path="mobile"></form:errors>
				</div>
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

            <spring:bind path="type">
			<form:radiobuttons path="type" items="${typeList}" />
            </spring:bind>

            <spring:bind path="creditCardNumber">
            				<div class="form-group ${status.error ? 'has-error' : ''}">
            					<form:input type="text" path="creditCardNumber" class="form-control"
            						placeholder="creditCardNumber"></form:input>
            					<form:errors path="creditCardNumber"></form:errors>
            				</div>
            			</spring:bind>

             <spring:bind path="expiryDate">
                        				<div class="form-group ${status.error ? 'has-error' : ''}">
                        					<form:input type="text" path="expiryDate" class="form-control"
                        						placeholder="expiryDate"></form:input>
                        					<form:errors path="expiryDate"></form:errors>
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
