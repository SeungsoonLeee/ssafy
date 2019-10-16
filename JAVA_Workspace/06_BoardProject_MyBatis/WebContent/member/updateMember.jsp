<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Board Project</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="/title.jsp" />
	<article id="content">
		<jsp:include page="/aside.jsp" />
		<article id="mainContent">
			<form method="post" action="updateMember.log">
				<table>
					<tr>
						<td class="caption" colspan='2' align='center'>회원 정보 수정</td>
					</tr>
					<tr>
						<td class='tbasic'>아 이 디</td>
						<td class='tbasic'>
							<input type='text' name="id" id="id" readonly="readonly"  value="${member.id}">
						</td>
					</tr>
					<tr>
						<td class='tbasic'>비밀번호</td>
						<td class='tbasic'>
							<input type='password' name='password' id='password'   value="${member.password}">
						</td>
					</tr>
					<tr>
						<td class='tbasic'>이 &nbsp;름</td>
						<td class='tbasic'>
							<input type='text' name='name' id='name' value='${member.name}'>
						</td>
					</tr>
					<tr>
						<td class='tbasic'>이메일</td>
						<td class='tbasic'>
							<input type='text' name='email' id='email'   value='${member.email}'>
						</td>
					</tr>
					<tr>
						<td class='tbasic'>전화번호</td>
						<td class='tbasic'>
							<input type='text' name='phone' id='phone'   value='${member.phone}'>
						</td>
					</tr>
					<tr>
						<td class='tbasic'>주 &nbsp;소</td>
						<td class='tbasic'>
							<input type='text' name='address' id='address'  value='${member.address}'>
					</tr>
					<tr>
						<td colspan='2' align='center' class='tfoot tspacial'>
							<input type="submit" value='수정'>
							<input type="reset" value='취소'>
						</td>
					</tr>
				</table>
			</form>
		</article>
	</article>
	<jsp:include page="/copyright.jsp" />
</body>

<!-- TODO: 09-2 화면에 member의 정보를 출력하시오. -->
<!-- END: -->
</html>
