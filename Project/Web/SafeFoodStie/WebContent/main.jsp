<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/index.css">
<script type='text/javascript' src='js/jquery-3.3.1.js'></script>
</head>
<body>
	<input type="hidden" id="detailItem" value="">
	<section id='intro'>
		<div id='introFirstComment'>
			<font>WHAT WE <b>PROVIDE</b></font>
		</div>
		<div>
			건강한 삶을 위한 먹거리 프로젝트
		</div>
	</section>
	<section id='searchForm'>
		<form method="post" action="foodList.do" id="frm">
			<table align="center">
				<tr>
					<td>정렬</td>
					<td>검색 조건</td>
					<td>검색 단어</td>
					<td></td>
				</tr>
				<tr>
					<td><select class="form-control" id="sortOption" name="sortOption">
							<option id="sortName" value="sortName">상품명순</option>
							<option id="sortMaker" value="sortMaker">브랜드순</option>
					</select></td>
					<td><select class="form-control" id="searchOption" name="searchOption">
							<option id="searchName" value="searchName">상품명</option>
							<option id="searchMaker" value="searchMaker">제조사</option>
							<option id="searchMaterial" value="searchMaterial">첨가재료</option>
							<option id="searcEtc" value="searcEtc">기타</option>
					</select></td>
					<td><input type="text" class="form-control" id="searchItem" name="searchItem"></td>
					<td><button type="submit" class="btn btn-primary" id="searchBtn" name="searchBtn">검색</button></td>
				</tr>
			</table>
		</form>
	</section>
	<article id="contentArea2">
		<jsp:include page="productList.jsp" />
	</article>
</body>
</html>