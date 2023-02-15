<%@include file="../pageConstructor/header.jsp"%>

<c:forEach var="user" items="${requestScope.users}">
  <p>Open profile of <a href="wall?id=${user.id}"> ${user.userName} </a> </p>
</c:forEach>

<%@include file="../pageConstructor/footer.jsp"%>