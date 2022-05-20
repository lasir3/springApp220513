<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="current"%>

<c:url value="/boardApp/board/list" var="listUrl"></c:url>
<c:url value="/boardApp/board/write" var="insertUrl"></c:url>
<c:url value="/boardApp/board/search" var="searchUrl"></c:url>

<nav class="navbar navbar-expand-sm navbar-light bg-light">
	<div class="container">
		<!-- 홈버튼 -->
		<a class="navbar-brand" href="${listUrl }"><i
			class="fa-solid fa-house"></i></a>

		<!-- 햄버거 버튼 추가 -->
		<!-- button.navbar-toggler>span.navbar-toggler-icon -->
		<button class="navbar-toggler" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent">
			<span class="navbar-toggler-icon"></span>
		</button>

		<!-- 글쓰기 버튼 -->
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav  me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a
					class="nav-link ${current == 'list' ? 'active' : '' }"
					href="${listUrl }">목록보기</a></li>
				<li class="nav-item"><a
					class="nav-link ${current == 'insert' ? 'active' : '' }"
					href="${insertUrl }">글쓰기</a></li>
			</ul>
			<form class="d-flex" action="${searchUrl }" method="get">
				<input class="form-control me-2" type="search" placeholder="검색"
					name="q">
				<button class="btn btn-outline-success" type="submit">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</form>
		</div>

	</div>
</nav>