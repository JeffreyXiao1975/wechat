<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/jquery-ui.css"/>
    <script src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/jquery-ui.js"></script>
    <script type="text/javascript">
    	$(function() {
    		<c:if test="${not empty result}">
    		    //alert("Serice account was created successfully!");
    		</c:if>
    		<c:if test="${empty result}">
		    	//alert("Serice account was created!");
			</c:if>
    	});
    </script>
  </head>

  <body>
    <img id="imgLoading" src="${pageContext.request.contextPath}/images/loading_red.gif" style="position:absolute;left:40%;top:40%;width:100px;height:100px;display:none;"/>
    <form:form id="frmViewServiceAccount" action="viewServiceAccount.do" method="POST" cssStyle="width:100%" commandName="serviceAccountModel">
	  <div style="height:10px;">&nbsp;</div>
	  <div style="top:20px; border:0px solid #333">
	    <spring:message code="wechat.service.account.le"/>:&nbsp;
	    <form:select id="new_service_account_leId" path="legalEntityId" readonly="true">
	      <form:option value="0" label="Select"/>
	      <form:options items="${legalEntities}" />
	    </form:select><br/><br/>
	    <spring:message code="wechat.service.account.name"/>:&nbsp;
        <form:input path="accountName" maxlength="100" readonly="true"/><br/><br/>
        <spring:message code="wechat.service.account.desc"/>:&nbsp;
        <form:textarea path="accountDesc" maxlength="1024" readonly="true"/><br/><br/>
	    <form:hidden id="new_service_account_disabled" path="disabled" />
	    <form:hidden id="new_service_account_deleted" path="deleted" />
	    <input type="submit" id="new_service_account_create" value="<spring:message code="button.create"/>"/>
	    <input type="button" id="new_service_account_cancel" value="<spring:message code="button.cancel"/>"/>
	  </div>
	  <div style="height:10px;">&nbsp;</div>
	</form:form>
  </body>
</html>