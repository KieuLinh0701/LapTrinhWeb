<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<form action="/LTWeb/register" method="post">
		<h1>Tạo tài khoản mới</h1>
		<c:if test="${alert !=null}">
			<h3 class="alert alertdanger">${alert}</h3>
		</c:if>

		<div class="container">
			<p>Please fill in this form to create an account.</p>
			<hr>

			<label for="username"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="username" id="username" required>

			<label for="password"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" id="password" required>

			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email" id="email" required>

			<label for="fullname"><b>Fullname</b></label> <input type="text"
				placeholder="Enter Fullname" name="fullname" id="fullname" required>

			<label for="phone"><b>Phone</b></label> <input type="text"
				placeholder="Enter Phone" name="phone" id="phone" required>

			<hr>
			<button type="submit" class="registerbtn">Register</button>
		</div>
	</form>
</body>
</html>