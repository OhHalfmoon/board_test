<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "hrrp://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Logout</title>
</head>
<body>
<h1>Logout Page</h1>

<form method="post" action="/customLogout">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<button>Logout</button>
</form>


</body>
</html>
