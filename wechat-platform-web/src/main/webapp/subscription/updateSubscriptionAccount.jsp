<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome-all.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/layer.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
    <script type="text/javascript">
    	var index = parent.layer.getFrameIndex(window.name);
    </script>
  </head>

  <body style="overflow:hidden">
    <div class="container-fluid" style="margin-left:0px;">
      <form:form id="frmUpdateSubscriptionAccount" action="updateSubscriptionAccount.do" method="POST" cssStyle="width:100%" commandName="subscriptionAccountModel">
        <div class="form-inline">
          <div class="row" style="margin-top:10px;">
            <div class="col-md-12 controls">
              <div class="form-group">
                <label for="account_leId"><spring:message code="wechat.subscription.account.le"/></label>
                <form:select id="account_leId" path="legalEntityId">
	              <form:option value="0" label="Select"/>
	              <form:options items="${legalEntities}" />
	            </form:select>
              </div>
            </div>
          </div>
          
          <div class="row" style="margin-top:10px;">
            <div class="col-md-12 controls">
              <div class="form-group">
                <label for="accountName"><spring:message code="wechat.subscription.account.name"/></label>
                <form:input path="accountName" maxlength="100"/>
              </div>
            </div>
          </div>
      
          <div class="row" style="margin-top:10px;">
            <div class="col-md-12 controls">
              <div class="form-group">
                <label for="accountDesc"><spring:message code="wechat.subscription.account.desc"/></label>
                <form:textarea path="accountDesc" maxlength="1024"/>
              </div>
            </div>
          </div>
	 
          <div class="row" style="margin-top:10px;">
            <div class="col-md-12 controls">
              <div class="form-group">
                <form:hidden path="id" />
                <form:hidden path="disabled" />
	            <form:hidden path="deleted" />
	            <a href="#" onclick="$('#frmUpdateServiceAccount').submit();" class="btn btn-success">&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="button.update"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                <a href="#" onclick="parent.layer.close(index);" class="btn btn-success">&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
              </div>
            </div>
          </div>
	    </div>
	  </form:form>
	</div>
  </body>
</html>