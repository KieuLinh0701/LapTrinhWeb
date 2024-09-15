<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot password</title>
</head>
<body>
	<form action="/LTWeb/forgotpassword" method="post">
		<h1>Tạo mật khẩu mới</h1>
		<c:if test="${alert !=null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>

		<div class="container">
			<label for="username"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="username" required> 
			<label for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required>
			<label for="repeatpassword"><b>Repeat Password</b></label> <input type="password"
				placeholder="Enter Repeat Password" name="repeatPassword" required>
			<button type="submit">Submit</button>
		</div>
	</form>
</body>
</html>