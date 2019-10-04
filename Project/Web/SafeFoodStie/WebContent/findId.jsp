<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>FindID</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="css/loginutil.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<script src="vendor/countdowntime/countdowntime.js"></script>

<style>
#limiter {
	margin: auto;
}

table {
	border-spacing: 10px;
	border-collapse: separate;
}

#findTable td {
	width: 270px;
}

#findTable th {
	text-align: right;
}

input[type=text] {
	width: 270px;
	border-radius: 6px;
}

input[type=password] {
	width: 270px;
	border-radius: 6px;
}
</style>

</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-85 p-r-85 p-t-55 p-b-55">
				<form class="login100-form validate-form flex-sb flex-w">
					<span class="login100-form-title p-b-32">
						아이디 찾기
					</span>
					<table id="findTable">
					<tr>
					<th class="txt1 p-b-11">
						이 름<font color="red" >*</font>  
					</th>
					<td class="wrap-input100 validate-input m-b-36" data-validate = "Username is required">
						<input class="input100" type="text" name="username" placeholder="User Name">
						<span class="focus-input100"></span>
					</td>
					</tr>
					<tr>
					
					<th class="txt1 p-b-11">
						아 이 디<font color="red" >*</font>   
					</th>
					<td class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<input class="input100" type="text" name="pass" placeholder=" I D" >
						<span class="focus-input100"></span>
					</td>
					</tr>
					<tr>
					<th class="txt1 p-b-11">
						전 화 번 호 <font color="red" >*</font>
					</th>
					<td class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<input class="input100" type="text" name="pass" placeholder="010-XXXX-XXXX" >
						<span class="focus-input100"></span>
					</td>
					</tr>
					<tr>
					<th>
					</th>
					<td>
					<button type="button" class="btn btn-info">비밀번호 찾기 √</button>
					</td>
					</tr>
				</table>
					
				</form>
			</div>
		</div>
	</div>
	<div id="dropDownSelect1"></div>
</body>
</html>