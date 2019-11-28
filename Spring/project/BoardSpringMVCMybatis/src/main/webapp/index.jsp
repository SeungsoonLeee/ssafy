<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Project</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="/title.jsp" />
	<article id="content">
		<jsp:include page="/aside.jsp" />
		<article id="mainContent">
			<c:choose>
				<c:when test="${!empty content}">
					<jsp:include page="${content}" />
				</c:when>
				<c:otherwise>
					<jsp:include page="default.jsp" />
				</c:otherwise>
			</c:choose>
		</article>
	</article>
	<jsp:include page="copyright.jsp" />
</body>
</html>




