<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/join" method="post">
		<div>
			<input type="text" id="userId" name="userId" placeholder="아이디">
		</div>
		<div>
			<input type="password" id="userPw" name="userPw" placeholder="비밀번호">
		</div>
		<div>
			<input type="password" id="confirmPw" placeholder="비밀번호 확인">
		</div>
		<div>
			<input type="text" id="userName" name="userName" placeholder="이름">
		</div>
		<div>
			<input type="text" id="userBirth" name="userBirth" placeholder="생년월일">
		</div>
		<div>
		 	<input type="radio" name="userGender" value="1" checked>남자
			<input type="radio" name="userGender" value="2" >여자
		</div>
		<div>
			<input type="email" id="userMail" name="userMail" placeholder="이메일">
		</div>
		<div>
			<input type="text" id="userCellNum" name="userCellNum" placeholder="휴대폰번호">
		</div>
		<div>
			<input type="submit" value="회원가입">
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>

</body>
</html>