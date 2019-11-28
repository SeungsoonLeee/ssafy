<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>제목</td>
			<td>등록일</td>
			<td>답변여부</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<c:forEach items="${list }" var="faq">
			<tr>
				<td>${faq.no }</td>
				<td>${faq.id }</td>
				<td><a href="faqSearch.do?no=${faq.no} ">${faq.title }</a></td>
				<td>${faq.regdate }</td>
				<c:choose>
					<c:when test="${not empty faq.reply}">
						<td>답변 있음 ${faq.reply }</td>
					</c:when>
					<c:otherwise>
						<td>답변 없음 </td>
					</c:otherwise>
				</c:choose>
				<td><a href="faqUpdateForm.do?no=${faq.no} ">수정</a></td>
				<td><a href="faqDelete.do?no=${faq.no} ">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>