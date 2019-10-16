<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<title>Board Project</title>
<link rel="stylesheet" type="text/css" href="css/basic.css" />
</head>
<body>
	<jsp:include page="/title.jsp" />
	<article id="content">
		<jsp:include page="/aside.jsp" />
		<article id="mainContent">
			<form method="post" action="insertBoard.log">
				<input type="hidden" name="id" id="id" value="${id }" />
				<table width="300">
					<tr>
						<th colspan="2">게시글 작성</th>
					</tr>
					<tr height="30" width="100">
						<td>
							<label for="title">제목</label>
						</td>
						<td>
							<input type="text" name="title" id="title" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<label for="content">내용</label>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<textarea name="contents" id="contents" cols="50" rows="7"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="작성" />
							<input type="button" value="취소" id="cancel" />
						</td>
					</tr>
				</table>
			</form>
		</article>
	</article>
	<jsp:include page="/copyright.jsp" />
</body>
<script>
	$("#cancel").on("click", function() {
		history.back();
	});
</script>
</html>

