<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags/" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css" integrity="sha512-GQGU0fMMi238uA+a/bdWJfpUGKUkBdgfFdgBm72SUQ6BeyWjoY/ton0tEjH+OSH9iP4Dfh+7HM0I9f5eR0L/4w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<title>Insert title here</title>
</head>
<body>
	
	<!-- 커스텀 태그를 이용해 상단 navBar 구현 -->
	<my:navBar current="list" />
	<br />
	<div class="container">
		<div class="row">
			<div class="col">
			
				<h1>검색결과 : ${searchStr }</h1>
				<c:if test="${not empty param.success }">
					<c:if test="${param.success }">
						<div class="alert alert-primary">
							게시물이 삭제되었습니다.
						</div>
					</c:if>
					<c:if test="${not param.success }">
						<div class="alert alert-danger">
							게시물 삭제 중 문제 발생하였습니다.
						</div>
					</c:if>
				</c:if>
				
				<table class="table table-hover" style="table-layout: fixed">
					<thead>
						<tr style="text-align : center;">
							<th class="col-1" ><i class="fa-solid fa-hashtag"></i></th>
							<th class="col-3" >제목</th>
							<th class="col-1" ><i class="fa-solid fa-comments"></i></th>
							<th class="col-1" ><i class="fa-solid fa-calendar"></i></th>
							<th class="col-2" >조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${searchList }" var="board">
							<tr>
								<td style="text-align : center;">${board.id }</td>
								<td style="text-overflow:ellipsis; overflow:hidden; white-space:nowrap;">
									<span>
										<c:url value="/boardApp/board/${board.id }" var="getUrl"></c:url>
										<a href="${getUrl }">
											${board.title }
										</a>
									</span>
								</td>
								<td style="text-align : center;">
									<!-- 댓글 갯수 추가 -->
									<c:if test="${board.numOfReply > 0}">
										<span>
											${board.numOfReply }
										</span>
									</c:if>
								</td>
								<td style="text-align : center;">${board.prettyInserted }</td>
								<td style="text-align : center;">${board.views }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
		<!-- pagination 추가 -->
	<div class="mt-3">
		<my:PaginationSearch path="search"/>
	</div>
</body>
</html>


