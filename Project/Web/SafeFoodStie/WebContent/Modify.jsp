<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFY</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/index.css">
<script type='text/javascript' src='js/jquery-3.3.1.js'></script>
<script>
	function update(){
		var frm = $("#modify");
		frm.attr("action", "memeberUpdate.do")
		frm.submit();
	}
	function remove(){
		var frm = $("#modify");
		frm.attr("action", "memberRemove.do")
		frm.submit();
	}
</script>
<style type="text/css">
	<style type="text/css">
	#table{
		margin : auto;
	}
	
	#jointable{
		width : 600px;
	}
	
	#jointable th{
		text-align : right;
		width : 70px
		
	}
	
	#jointable td{
		width : 500px;
	}
	
	#jointable{
		border-spacing: 10px;
		border-collapse: separate;
		border : solid 1px black;
		border-radius:10px;
	}
	
	#jointable input[type=text]{
		width : 400px;
		border-radius:6px;
	}
	
	#jointable input[type=password]{
		width : 400px;
		border-radius:6px;
	}
	

</style>
</head>
<body>
	<form method="post" action="memberUpdate.do">
		<div id="table" align="center">
			<table id="jointable">
				<tr>
					<th><h3>회원 정보</h3></th>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" id="id" name="id" value="${member.id }">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pw" placeholder="영문 숫자 포함 6자리 이상" value="${member.password }"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" id="name" placeholder="User Name" name="name" value="${member.name }"></td>
				</tr>
				<tr>
					<th>주소 <font color="red"></font></th>
					<td><input type="text" id="addr" placeholder="address" name="addr" value="${member.address }"></td>
				</tr>
				<tr>
					<th>전화번호 <font color="red"></font></th>
					<td><input type="text" id="tel" placeholder="010-xxxx-xxxx" name="tel" value="${member.phone }"></td>
				</tr>
				<tr>
					<th>알레르기 <font color="red"></font></th>
					<td>
						<fieldset id="allegebox"
							style="width: 400px; border: solid 1px black;">
							<legend style="width: auto">
								<font size="4em">Check</font>
							</legend>
							<input id="bean" type="checkbox" name="allergies" value="대두"/><label>대두</label>
							<input id="peanut" type="checkbox" name="allergies" value="땅콩"/><label>땅콩</label>
							<input id="milk" type="checkbox" name="allergies" value="우유"/><label>우유</label>
							<input id="crab" type="checkbox" name="allergies" value="게"/><label>게</label><br />
							<input id="shrimp" type="checkbox" name="allergies" value="새우"/><label>새우</label>
							<input id="tuna" type="checkbox" name="allergies" value="참치"/><label>참치</label>
							<input id="salmon" type="checkbox" name="allergies" value="연어"/><label>연어</label>
							<input id="mugwort" type="checkbox" name="allergies" value="쑥"/><label>쑥</label><br />
							<input id="beef" type="checkbox" name="allergies" value="소고기"/><label>소고기</label>
							<input id="chicken" type="checkbox" name="allergies" value="닭고기"/><label>닭고기</label>
							<input id="pork" type="checkbox" name="allergies" value="돼지고기"/><label>돼지고기</label><br />
							<input id="peach" type="checkbox" name="allergies" value="복숭아"/><label>복숭아</label>
							<input id="dandelion" type="checkbox" name="allergies" value="민들레"/><label>민들레</label>
							<input id="eggwhite" type="checkbox" name="allergies" value="계란흰자"/><label>계란흰자</label><br />
						</fieldset>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit" class="btn btn-primary" onclick="update()">수정</button>
						<button type="button" class="btn btn-primary" onclick="remove()">회원탈퇴</button></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>