<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/jquerytab/jquery-ui.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquerytab/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquerytab/jquery-ui.js"></script>
    <script>
        $( function() {
        	$("#tabs").tabs({
      			beforeLoad: function(event, ui) {
        			ui.jqXHR.fail(function() {
          				ui.panel.html("Couldn't load this tab. We'll try to fix this as soon as possible. If this wouldn't be a demo.");
        			});
      			}
			});
		} );
    </script>
  </head>

  <body style="height:100%;width:100%;">
    <div id="tabs">
      <ul>
        <li><a href="${pageContext.request.contextPath}/platform/queryUser.do"><spring:message code="wechat.platform.usersetting"/></a></li>
        <li><a href="${pageContext.request.contextPath}/platform/authorizationSetting.do"><spring:message code="wechat.platform.permissionsetting"/></a></li>
        <li><a href="${pageContext.request.contextPath}/platform/systemSetting.do"><spring:message code="wechat.platform.systemsetting"/></a></li>
      </ul>
    </div>
  </body>
</html>