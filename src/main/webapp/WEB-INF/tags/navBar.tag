<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="current"%>

<c:url value="/boardApp/board/list" var="listUrl"></c:url>
<c:url value="/boardApp/board/write" var="insertUrl"></c:url>
<c:url value="/boardApp/board/search" var="searchUrl"></c:url>

<nav class="navbar navbar-expand-sm navbar-light bg-light">
	<div class="container">
		<!-- 홈버튼 -->
		<a class="navbar-brand" href="${listUrl }"><i class="fa-solid fa-house"></i></a>

		<!-- 글쓰기 버튼 -->
		<div class="navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link ${current == 'list' ? 'active' : '' }" href="${listUrl }">목록보기</a></li>
				<li class="nav-item"><a	class="nav-link ${current == 'insert' ? 'active' : '' }" href="${insertUrl }">글쓰기</a></li>
			</ul>
		</div>
		<form class="d-flex" action="${searchUrl }" method="get">
			<input class="form-control me-2" type="search" placeholder="제목 검색" name="q">
			<button class="btn btn-outline-success col-3" type="submit">검색</button>
		</form>
	</div>
</nav>