<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		<meta name="_csrf" content="${_csrf.token}"/>
		<!-- default header name is X-CSRF-TOKEN -->
		<meta name="_csrf_header" content="${_csrf.headerName}"/>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="js/libs/login.min.js"></script>
		<script src="js/login/login.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/libs/login.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/login/login.min.css"/>
	</head>
	<body ng-app="login">
		<div class="page" ng-controller="loginCtrl">
			<h2>????? ???????????</h2>
			<form method="post" ng-submit="login()">
				<label>????????????: </label>
				<input type="text" name="username" ng-model="username"/>
				<label>??????: </label>
				<input type="password" name="password" ng-model="password"/>
				<button type="submit">????</button>
			</form>
		</div>
	</body>
</html>
