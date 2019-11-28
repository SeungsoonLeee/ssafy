<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<form method="post" action="faqInsert.do" >
	<table>
		<caption> FAQ </caption>
		<tbody>
			<tr height="50"><td><label for="title">제목</label></td>
			    <td>${faq.title }</td>
			</tr>
			<tr height="50"><td><label for="title">아이디</label></td>
			    <td>${faq.id }</td>
			</tr>
			<tr><td colspan="2"><label for="content">내용</label></td></tr>
			<tr><td colspan="2" align="center">${faq.contents }</td></tr>
			<c:if test="not empty faq.reply">
				<tr><td colspan="2"><label for="content">답변</label></td></tr>
				<tr><td colspan="2" align="center">${faq.reply }</td></tr>	
			</c:if>
		</tbody>
		<tfoot>
			<tr><td colspan="2" align="center">
				<a href="faqList.do">목록</a>
			</td></tr>
		</tfoot>
	</table>
</form>
</body>
</html>