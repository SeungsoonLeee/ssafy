<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			    <td><input type="text" name="title" id="title"/></td>
			</tr>
			<tr height="50"><td><label for="title">아이디</label></td>
			    <td><input type="text" name="id" id="id"/></td>
			</tr>
			<tr><td colspan="2"><label for="content">내용</label></td></tr>
			<tr><td colspan="2" align="center">
			    <textarea name="contents" id="content" cols="30" rows="10"></textarea>
			</td></tr>
		</tbody>
		<tfoot>
			<tr><td colspan="2" align="center">
				<input type="submit" value="작성"/>
				<input type="reset" value="취소"/>
			</td></tr>
		</tfoot>
	</table>
</form>
</body>
</html>