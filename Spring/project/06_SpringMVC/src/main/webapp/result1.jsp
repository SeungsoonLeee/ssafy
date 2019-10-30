<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	번호: ${board.no }<br/>
	아이디: ${board.id }<br/>
	제목: ${board.title }<br/>
	내용: ${board.contents }<br/>
</body>
</html>