<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="path" %>

<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<c:forEach begin="${pageInfo.left }" end="${pageInfo.right }"
			var="pageNum">
			
			<c:url value="${path }" var="link" >
				<c:param name="page" value="${pageNum }"></c:param>
			</c:url>
			
			<li class="page-item ${pageInfo.current == pageNum ? 'active' : '' }">
				<a class="page-link" href="${link }">${pageNum }</a>
			</li>
		</c:forEach>
	</ul>
</nav>