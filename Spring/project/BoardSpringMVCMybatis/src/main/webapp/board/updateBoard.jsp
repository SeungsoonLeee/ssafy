<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<form method="post" action="updateBoard.do">
				<input type="hidden" name="no" id='no' value='${board.no}' />
				<input type="hidden" name="regdate" id='regdate' value='${board.regdate}' />
				<table>
					<tr>
						<th colspan="2">게시글 수정</th>
					</tr>
					<tr height="50">
						<td>
							<label for="title">제목</label>
						</td>
						<td>
							<input type="text" name="title" id="title" value='${board.title }' />
						</td>
					</tr>
					<tr height="50">
						<td>
							<label for="title">아이디</label>
						</td>
						<td>
							<input type="text" value="${board.id}" readonly="readonly" name="id">
						</td>
					<tr>
						<td colspan="2">
							<label for="contents">내용</label>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<textarea name="contents" id="contents" cols="50" rows="5">${board.contents }</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="수정" />
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


