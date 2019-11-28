<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form method="post" action="filedown.do">
  	<input type="hidden" name="realFileName" value="${realFileName}">
  	<input type="hidden" name="fileName" value="${fileName}">
  	${fileName}
  	<input type="submit"  value="다운 받기">
  </form>
  <%-- <a href="filedown.do?realFileName=${realFileName}&fileName=${fileName}">${fileName}</a> --%>
  <a href="../upload/${realFileName }">${fileName}</a>
</body>
</html>







