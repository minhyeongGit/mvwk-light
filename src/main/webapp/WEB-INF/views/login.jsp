<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="/login" method="post">
		<div>
			<input type="text" id="userId" name="username" placeholder="아이디">
		</div>
		<div>
			<input type="password" id="userPw" name="password" placeholder="비밀번호">
		</div>
		<div> 
			<!-- <input type="checkbox" name="remember-me">로그인 상태 유지 -->
		</div>
		<div>
			<input type="submit" value="로그인">
		</div>
		<div>
			<a href="">
				비밀번호를 잊어버리셨나요?
			</a>
		</div>
		<div>
			계정이 없으신가요? 
			<a href="/join">
				회원가입
			</a>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</body>
</html>