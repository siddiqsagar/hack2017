<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isELIgnored="false" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Transaction</title>

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
            Transaction</span>
        </h1>
    </header>
    <div class="container">
        <h2 class="form-signin-heading">Create your account</h2>
        <table>
            <tr>
                <td>Description</td>
                <td>Date and time</td>
                <td>Amount</td>
            </tr>
            <c:forEach items="${transactionResponseList}" var="transactionResponse">
            <tr>
                <td><c:out value="${transactionResponse.description}" /></td>
                <td><c:out value="${transactionResponse.transactionDate}" /> <c:out value="${transactionResponse.transactionTime}" /></td>
                <td><c:out value="${transactionResponse.totalAmount}" /></td>
            </tr>
            </c:forEach>
        </table>
        <button class="btn btn-lg btn-primary btn-block" type="button">
            <h4 class="text-center">
                <a href="${contextPath}/cushome">Back to home page</a>
            </h4>
        </button>
    </div>
</body>
</html>