<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/index.css">
<script type='text/javascript' src='js/jquery-3.3.1.js'></script>
<script type="text/javascript" src="js/validCheck.js"></script>
<script type="text/javascript" src="js/calCheck.js"></script>
<style type="text/css">
<
style type ="text/css">#table {
	margin: auto;
}

#jointable {
	width: 600px;
}

#jointable th {
	text-align: right;
	width: 70px
}

#jointable td {
	width: 500px;
}

#jointable {
	border-spacing: 10px;
	border-collapse: separate;
	border: solid 1px black;
	border-radius: 10px;
}

#jointable input[type=text] {
	width: 400px;
	border-radius: 6px;
}

#jointable input[type=password] {
	width: 400px;
	border-radius: 6px;
}
</style>
</head>
<body>
	<form method="post" name="registeInputForm" action="Register.do" onsubmit="return registCheck();">
		<div id="table" align="center">
			<table id="jointable">
				<tr>
					<th>
						<h3>회원 가입
						<c:if test="${ not empty msg }">${msg}</c:if>
			 		    </h3>
		 		    </th>
				</tr>
				<tr>
					<th>아이디 <font color="red">*</font></th>
					<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<th>비밀번호 <font color="red">*</font></th>
					<td><input type="password" name="pw" placeholder="  영문 숫자 포함 6자리 이상"></td>
				</tr>
				<tr>
					<th>이름 <font color="red">*</font></th>
					<td><input type="text" id="name" placeholder="  User Name" name="name"></td>
				</tr>
				<tr>
					<th>주소 <font color="red">*</font></th>
					<td><input type="text" id="addr" placeholder="  address" name="addr"></td>
				</tr>
				<tr>
					<th>전화번호 <font color="red">*</font></th>
					<td><input type="text" id="tel" placeholder="  010-xxxx-xxxx" name="tel"></td>
				</tr>
				<tr>
					<th>email <font color="red">*</font></th>
					<td><input type="text" id="email" placeholder="id@naver.com" name="email"></td>
				</tr>
				<tr>
					<th>알레르기 <font color="red">*</font></th>
					<td>
						<fieldset id="allegebox"
							style="width: 400px; border: solid 1px black;">
							<legend style="width: auto">
								<font size="4em">Check</font>	
							</legend>
							<input value="대두" id="bean" type="checkbox" name="allergies" /><label>대두</label>
							<input value="땅콩" id="peanut" type="checkbox" name="allergies" /><label>땅콩</label>
							<input value="우유" id="milk" type="checkbox" name="allergies" /><label>우유</label>
							<input value="게" id="crab" type="checkbox" name="allergies" /><label>게</label><br />
							<input value="새우" id="shrimp" type="checkbox" name="allergies" /><label>새우</label>
							<input value="참치" id="tuna" type="checkbox" name="allergies" /><label>참치</label>
							<input value="연어" id="salmon" type="checkbox" name="allergies" /><label>연어</label>
							<input value="쑥" id="mugwort" type="checkbox" name="allergies" /><label>쑥</label><br />
							<input value="소고기" id="beef" type="checkbox" name="allergies" /><label>소고기</label>
							<input value="닭고기" id="chicken" type="checkbox" name="allergies" /><label>닭고기</label>
							<input value="돼지고기" id="pork" type="checkbox" name="allergies" /><label>돼지고기</label><br />
							<input value="복숭아" id="peach" type="checkbox" name="allergies" /><label>복숭아</label>
							<input value="민들레" id="dandelion" type="checkbox" name="allergies" /><label>민들레</label>
							<input value="계란흰자" id="eggwhite" type="checkbox" name="allergies" /><label>계란흰자</label><br />
						</fieldset>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit" class="btn btn-primary">등록✔️</button></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>