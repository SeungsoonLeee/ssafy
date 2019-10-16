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

<c:url value="/" var="ctx"></c:url>

<link href="${ctx }css/basic.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.errorMsg {
	color: red;
}

.loginForm {
	position: relative;
	left: 0px;
	top: 0px;
}
</style>
</head>
<body>
	<jsp:include page="/title.jsp" />
	<article id="content">
		<jsp:include page="/aside.jsp" />
		<article id="mainContent">
			<c:choose>
				<c:when test="${ empty id }">
					<c:if test="${not empty cookie.id}">
						<c:set var="idSave" value="value='${cookie.id.value}'" />
						<c:set var="checked" value="checked='checked'" />
					</c:if>
					<center>
						<article class='loginForm'>
							<form action="login.do" method="post" id="frm">
								<table>
									<c:if test="${ not empty msg }">
										<tr>
											<td colspan='2' class="errorMsg">${msg}</td>
										</tr>
									</c:if>
									<c:if test="${not empty referer}">
										<input type="hidden" name="referer" value='${referer}' />
									</c:if>
									<tr>
										<td>아 이 디</td>
										<td>
											<input type="text" name="id" ${idSave} id="id" />
										</td>
									</tr>
									<tr>
										<td>비밀번호</td>
										<td>
											<input type="password" name="pw" id="pw" />
										</td>
									</tr>
									<tr>
										<td align='right' colspan="2">
											<input type="checkbox" name='idsave' value='t' ${checked}>
											아이디 저장
											<input type="submit" value="로그인" />
										</td>
									</tr>
								</table>
							</form>
						</article>
					</center>
				</c:when>
			</c:choose>
		</article>
	</article>
	<jsp:include page="/copyright.jsp" />
</body>
</html>





















