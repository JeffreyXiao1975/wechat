<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title><spring:message code="application.title"/></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/main.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/jquery-ui.min.css"/>
    
    <script src="${pageContext.request.contextPath}/scripts/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/jquery-ui.min.js"></script>
    <script type="text/javascript">
    	$(function() {
    		
    	});
    </script>
  </head>
  <body>
	<!-- container -->
	<div id="container">
	  <!-- logo -->
	  <div id="logo"><spring:message code="application.title"/></div>
	  <!-- /logo -->
 
      <!--菜单栏-->
	  <div class="menu_bar">    
        <ul>
          <li class="leftmenu">
            <a href="#" class=""><spring:message code="application.currentuser"/>:&nbsp;<c:out value="${sessionScope.user.username}"/></a>            
          </li> 
          <!-- <li class="leftmenu">
            <a href="#" class="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<spring:message code="application.position"/>:&nbsp;</a>            
          </li> -->
          <li class="menu">
            <a class="help" href="${pageContext.request.contextPath}/public/logout.jsp"><spring:message code="application.logout"/></a>
          </li>
          <li class="menu">
            <a class="help" id="img-new-service-account"><spring:message code="application.help"/></a>
          </li>
        </ul> 
      </div>
      <!--//菜单栏-->
      
      <!-- content -->
	  <div id="content">
		<!-- navigator -->
		<div id="nav">
		  <div class="top"><a href="#" id="set"></a></div>
		  <div class="tags">
		    <a href="${pageContext.request.contextPath}/platform/platformmain.do" target="content_inner">
			  <img src="${pageContext.request.contextPath}/images/nav/tag_yhxf.jpg"/>
			  <span><spring:message code="wechat.platform.management"/></span>
			</a>
			<div class="line"></div>
			<a href="${pageContext.request.contextPath}/enterprise/enterprisemain.do" target="content_inner">
			  <img src="${pageContext.request.contextPath}/images/nav/tag_ztll.jpg"/>
			  <span><spring:message code="wechat.enterprise.accout"/></span>
			</a>
			<div class="line"></div>
			<a href="${pageContext.request.contextPath}/service/servicemain.do" target="content_inner">
			  <img src="${pageContext.request.contextPath}/images/nav/tag_jichushuju.jpg"/>
			  <span><spring:message code="wechat.service.account"/></span>
			</a>
			<div class="line"></div>
			  <a href="${pageContext.request.contextPath}/subscription/subscriptionmain.do" target="content_inner">
				<img src="${pageContext.request.contextPath}/images/nav/tag_dsfgm.jpg"/>
				<span><spring:message code="wechat.subscription.account"/></span>
			  </a>					
			</div>
		  </div>
		  <!-- /navigator -->
						
		  <!-- iframe_div -->
		  <div id="iframe_div">								
			<!-- iframe -->
			<div id="iframe">
			  <iframe name="content_inner" src="${pageContext.request.contextPath}/common/welcome.do" width="100%" height="100%" frameborder="0" marginwidth="0" marginheight="0"></iframe>
			</div>
			<!-- /iframe -->
		  </div>
		  <!-- /iframe_div -->
		</div>
		<!-- /content -->
	</div>
	<!-- /container -->
	
	<iframe id="ifrm-popup-content" style="width:300px;height:200px;border:none;"></iframe>
  </body>
</html> 