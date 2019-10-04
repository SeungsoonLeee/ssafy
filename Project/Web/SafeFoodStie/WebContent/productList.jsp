<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT LIST</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript">
function goDetail(foodcode){
	location.href="foodDetail.do?foodcode=" + foodcode;
}
</script>
</head>
<body>
	<table id='listTable' align='center' width='80%'>
		<c:forEach items="${list}" var="food">
			<tr id='listTableFistTr'>
				<td rowspan='5' width='20%'>
					<img src="${food.img}" id="${food.code}" name="${food.code}" width="260px" height="260px" class="imgContent" onclick="goDetail(this.name);")>
				</td>
				<td id="listTableFistTd" align="left">
					<b><font size='5px'>${food.name}</font></b>
				</td>
			</tr>
			<tr>
				<td align='left'>
					<font size='4px'>제조사 : ${food.maker}</font>
				</td>
			</tr>
			<tr>
				<td align='left'>
					<a href='#'><i class='fa fa-calendar'></i> Feb, 2007</a>&nbsp;&nbsp;&nbsp;
					<a href='#'><i class='fa fa-tag'></i> Web Design</a><hr>
				</td>
			</tr>
			<tr>
				<td align='left' height="80%">${food.material}</td>
			</tr>
			<tr id='listTableLastTr'>
				<td align='left'>
					<button type='button' class='btn btn-info'>	<i class='fa fa-plus'></i> 추가</button>
					<button type='button' class='btn btn-info'>	<i class='fa fa-star'></i> 찜</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>