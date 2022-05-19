<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="searchStr" %>
<%@ attribute name="path" %>

<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<c:if test="${pageInfo.left > 1 }">
			<c:url value="${path }" var="link">
				<c:param name="q" value="${param.q }"></c:param>
				<c:param name="page" value="${pageInfo.left - 1 }"></c:param>
			</c:url>
			<li class="page-item">
				<a class="page-link" href="${link }">prev</a>
			</li>
		</c:if>
		
		<c:forEach begin="${pageInfo.left }" end="${pageInfo.right }" var="pageNum">
			<c:url value="${path }" var="link" >
				<c:param name="q" value="${param.q }"></c:param>
				<c:param name="page" value="${pageNum }"></c:param>
			</c:url>
			<li class="page-item ${pageInfo.current == pageNum ? 'active' : '' }">
				<a class="page-link" href="${link }">${pageNum }</a>
			</li>
		</c:forEach>
		
		<c:if test="${pageInfo.right < pageInfo.end }">
			<c:url value="${path }" var="link">
				<c:param name="q" value="${param.q }"></c:param>
				<c:param name="page" value="${pageInfo.right + 1 }"></c:param>
			</c:url>
			<li class="page-item">
				<a class="page-link" href="${link }">next</a>
			</li>
		</c:if>
		
	</ul>
</nav>

