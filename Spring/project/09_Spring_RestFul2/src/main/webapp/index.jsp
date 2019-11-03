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
<body>
	<h1>메인 페이지</h1>
	<p />

	<p />
	<c:choose>
		<c:when test="${empty id }">
			<jsp:include page="Login.jsp" />
		</c:when>
	</c:choose>
	<h4>
		<a href="phoneInsertForm.do">핸드폰 등록</a>
	</h4>
	<h4>
		<a href="phoneList.do">핸드폰 목록</a>
	</h4>
	<h4>
		<a href="phone">핸드폰 목록 - rest</a>
	</h4>

</body>
</html>