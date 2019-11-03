<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}

a {
	margin: 10px;
}
</style>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<br>
	<table width=780 border=0 cellpadding=0 cellspacing=0>
		<tr>
			<td width="20"></td>
			<td>
				<!--contents-->
				<table width=590 border=0 cellpadding=0 cellspacing=0>
					<c:if test="${not empty id}">
					<tr>
						<td align="right" height="22">${id }님 로그인 되었습니다. <a href="logout.do">로그 아웃</a></td>
					</tr>
					</c:if>
					<tr>
						<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 -
								에러</b></td>
					</tr>
				</table> <br> <!-- write Form  -->
				<table border="0" cellpadding="0" cellspacing="1" width="590"
					bgcolor="BBBBBB">
					<tr>
						<td width=100 align=center bgcolor="E6ECDE" height="22">처리 중
							문제가 발생했습니다.</td>
					</tr>
					<tr>
						<td width=100 align=center height="22">문제 내용 - ${msg}</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>