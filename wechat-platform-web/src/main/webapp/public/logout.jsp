<%@ page session="true"%>
<%
	session.invalidate();
	response.sendRedirect(request.getContextPath() + "/public/index.jsp");
%>