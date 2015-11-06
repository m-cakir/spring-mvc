<%@include file="/WEB-INF/views/include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<c:if test="${!empty cUser}">
	<c:redirect url="/"/>
</c:if>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<title>Login</title>

	<link href="${bootstrap}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${bootstrap}/css/bootstrap-theme.min.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

	<link rel="icon" href="${assets}/favicon.ico">

	<script>
		if(location.pathname != "/login"){
			location.reload();
		}
	</script>
</head>

<body>

	<div class="container" style="margin:0 auto;padding-top:40px">

		<form class="form-vertical" action="/doLogin" method="post">

			<h3 class="form-title">Sign In to your Account</h3>

			<c:if test="${param.error == 1}">
				<div class="alert fade in alert-danger">
					<i class="icon-remove close" data-dismiss="alert"></i>

					<c:choose>
						<c:when test="${SPRING_SECURITY_LAST_EXCEPTION.message == 'User is disabled'}">
							${SPRING_SECURITY_LAST_EXCEPTION.message}
						</c:when>
						<c:when test="${SPRING_SECURITY_LAST_EXCEPTION.message == 'Bad credentials'}">
							${SPRING_SECURITY_LAST_EXCEPTION.message}
						</c:when>
						<c:otherwise>
							Something has gone wrong, try again later
						</c:otherwise>
					</c:choose>

				</div>
			</c:if>

			<div class="form-group">

				<input type="text" name="uname" class="form-control" placeholder="Username" autofocus="autofocus"/>

			</div>
			<div class="form-group">

				<input type="password" name="pass" class="form-control" placeholder="Password"/>

			</div>
			<div class="form-group">

				<button type="submit" class="btn btn-primary pull-right">Sign In </button>

			</div>

		</form>

	</div>

	<script src="${plugins}/jquery/jquery-1.10.2.min.js"></script>
	<script src="${bootstrap}/js/bootstrap.min.js"></script>
</body>
</html>
