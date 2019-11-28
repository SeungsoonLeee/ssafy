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
			<table align="center">
				<caption>고객 정보</caption>
				<tr>
					<td>이 름</td>
					<td></td>
				</tr>
				<tr>
					<td>비 번</td>
					<td></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td></td>
				</tr>
			</table>
		</article>
	</article>
	<jsp:include page="/copyright.jsp" />
</body>
</html>






