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
    		$("#form-new-service-account").dialog({
    			autoOpen: false,
    		    height: 300,
    		    width: 350,
    		    modal: true,
    		    position: {
    		    	my: "center",
    		    	at: "center",
    		    	//of: "window",
    		    	//collision: "fit",
    		    	using: function( pos ) {
    		    		var topOffset = $( this ).css( pos ).offset().top;
    		    		if ( topOffset < 0 ) {
    		    			$( this ).css( "top", pos.top - topOffset );
    		    		}
    		    	}
    		    }
			});
    		 
    		$("#img-new-service-account").click(function() {
    			$("#form-new-service-account").dialog("open");
    		});
    	});
    </script>
    <style type="text/css">
    	.newaccount {
      		width: 150px;
      		height: 150px;
      		float: left;
      		margin-right: 20px;
      		background-color: green;
      		text-align:center;
      		line-height:150px;
      		box-shadow: 5px 5px 2px #888888;
      	}
      	
      	.activeaccount {
      		width: 150px;
      		height: 150px;
      		float: left;
      		margin-right: 20px;
      		background-color: green;
      		text-align:center;
      		line-height:150px;
      		box-shadow: 5px 5px 2px #888888;
      		
      	}
      
      	.disabledaccount {
      		width: 150px;
      		height: 150px;
      		float: left;
      		margin-right: 20px;
      		background-color: lightgray;
      		text-align:center;
      		line-height:150px;
      		box-shadow: 5px 5px 2px #888888;
      	}
      
      	.deletedaccount {
      		width: 150px;
      		height: 150px;
      		float: left;
      		margin-right: 20px;
      		background-color: gray;
      		text-align:center;
      		line-height:150px;
      		box-shadow: 5px 5px 2px #888888;
      	}
      	
      	.divtitle {
      		height:22px; 
      		background-color:red;
      		text-align:left;
      		line-height:22px;
      		font:italic bold 20px/20px arial,sans-serif;
      		color:white;
      	}
    </style>
  </head>

  <body>
    <img id="imgLoading" src="${pageContext.request.contextPath}/images/loading_red.gif" style="position:absolute;left:40%;top:40%;width:100px;height:100px;display:none;"/>
    <div style="height:5px;">&nbsp;</div>
	<div class="divtitle">&nbsp;<spring:message code="wechat.service.account"/></div>
	<div style="height:5px;">&nbsp;</div>
	<form:form id="frmServiceMain" action="servicemain.do" method="POST" cssStyle="width:100%" commandName="queryServiceAccountCriteriaModel">
	  <div style="top:20px; border:1px solid #333">
	    <form:checkbox path="disabled" value="1"/><spring:message code="checkbox.disabled"/>
	    <form:checkbox path="deleted" value="1"/><spring:message code="checkbox.deleted"/>
	    <input type="submit" id="btnSearch" value="<spring:message code="button.search"/>"/>
	  </div>
	  <div style="height:10px;">&nbsp;</div>
	  
	  <div style="width:100%">
	    <div class="newaccount">
	      <img id="img-new-service-account" title="<spring:message code="wechat.service.account.new"/>" src="${pageContext.request.contextPath}/images/new.png" style="width:100%; height:100%; cursor:pointer;"/>
        </div>
	    <c:if test="${not empty queryServiceAccountCriteriaModel.serviceAccountList}">
	      <c:forEach items="${queryServiceAccountCriteriaModel.serviceAccountList}" var="serviceAccountVo">
	        <c:if test="${serviceAccountVo.disabled == false}">
	          <c:if test="${serviceAccountVo.deleted == false}">
	            <div class="activeaccount"><c:out value="${serviceAccountVo.accountName}"/></div>
	            <ul id="menu">
                  <li><a href="#"><span class="ui-icon ui-icon-disk"></span>保存</a></li>
                  <li><a href="#"><span class="ui-icon ui-icon-zoomin"></span>放大</a></li>
                  <li><a href="#"><span class="ui-icon ui-icon-zoomout"></span>缩小</a></li>
                  <li class="ui-state-disabled"><a href="#"><span class="ui-icon ui-icon-print"></span>打印...</a></li>
                </ul>
	          </c:if>
	          <c:if test="${serviceAccountVo.deleted == true}">
	            <div class="deletedaccount"><c:out value="${serviceAccountVo.accountName}"/></div>
	          </c:if>
	        </c:if>
	        <c:if test="${serviceAccountVo.disabled == true}">
	          <c:if test="${serviceAccountVo.deleted == false}">
	            <div class="disabledaccount"><c:out value="${serviceAccountVo.accountName}"/></div>
	          </c:if>
	          <c:if test="${serviceAccountVo.deleted == true}">
	            <div class="deletedaccount"><c:out value="${serviceAccountVo.accountName}"/></div>
	          </c:if>
	        </c:if>
	      </c:forEach>
	    </c:if>
	  </div>
	  <div id="form-new-service-account" title="<spring:message code="wechat.service.account.new"/>"></div>
	</form:form>
  </body>
</html>