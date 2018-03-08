<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
      <form:form id="frmCreatePlatformUser" action="createPlatformUser.do" method="POST" class="form-inline" commandName="platformUserModel">
        <div class="form-inline">
          <div class="row" style="margin-top:10px;">
            <div class="col-md-12 controls">
              <div class="form-group">
                <label for="username"><spring:message code="wechat.platform.usersetting.username"/></label>
                <form:input id="username" path="username" size="20" maxlength="10" autofocus/>
              </div>
            </div>
          </div>
          <div class="row" style="margin-top:10px;">
            <div class="col-md-12 controls">
              <div class="form-group">
                <a href="#" onclick="$('#frmCreatePlatformUser').submit();" class="btn btn-success">&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="button.create"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                <a href="#" onclick="parent.layer.close(index);" class="btn btn-success">&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="button.cancel"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
              </div>
            </div>
          </div>
        </div>
      </form:form>
    </div>
  </body>
</html>