<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Project</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
</head>
<body>
	<jsp:include page="title.jsp" />
	<article id="content">
		<jsp:include page="aside.jsp" />
		<article id="mainContent">
			<table align="center">
				<caption>에러 발생</caption>
				<tr>
					<td>${msg}</td>
				</tr>
				<tr>
					<td>에러가 발생했습니다. 다시 수행해 주세요!</td>
			</table>
		</article>
	</article>
	<jsp:include page="/copyright.jsp" />
</body>
</html>











