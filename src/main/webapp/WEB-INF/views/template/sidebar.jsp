<%@ include file="/WEB-INF/views/include.jsp" %>

<ul>

    <c:forEach var="menu" items="${cUserMenus}">

        <li><a href="${menu.link}">${menu.name}</a></li>

    </c:forEach>

</ul>