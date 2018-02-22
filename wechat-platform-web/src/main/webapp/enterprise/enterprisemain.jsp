<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.2.1.min.js"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.form.js"/>
    <script type="text/javascript">
	    function submitQuery() {
			alert("ok");
		}
    </script>
    <style type="text/css">
    	.newaccount {
      		width: 150px;
      		height: 150px;
      		float: left;
      		margin-right: 20px;
      		margin-bottom: 20px;
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
      		margin-bottom: 20px;
      		background-color: green;
      		text-align:center; 
      		line-height:150px;      		
      		box-shadow: 5px 5px 2px #888888;
      	}
      	
      	.activeaccount a:link{text-decoration: none;}
        .activeaccount a img{position:relative; width:12px; height:12px; padding:2px; border:1px solid #cfcfcf; top:-60px; left:113px;}
        .activeaccount a:hover img{ border-color:#8ECFF9;}
        .activeaccount span{left:-120px; top:0px;}
        .activeaccount ul{display:none;width:100px;}
        .activeaccount ul li{float:none;width:100px;margin:0;}
      
      	.disabledaccount {
      		width: 150px;
      		height: 150px;
      		float: left;
      		margin-right: 20px;
      		margin-bottom: 20px;
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
      		margin-bottom: 20px;
      		background-color: gray;
      		text-align:center;
      		line-height:150px;
      		box-shadow: 5px 5px 2px #888888;
      	}
      	.ui-menu { width: 150px; }
    </style>
  </head>

  <body>
    <img id="imgLoading" src="${pageContext.request.contextPath}/images/loading_red.gif" style="position:absolute;left:40%;top:40%;width:100px;height:100px;display:none;"/>
	<form:form id="frmEnterpriseMain" action="enterprisemain.do" method="POST" cssStyle="width:100%" commandName="queryEnterpriseAccountCriteriaModel">
	  <div style="height:10px;">&nbsp;</div>
	  <div style="top:20px; border:1px solid #333">
	    <form:checkbox path="disabled" value="1"/><spring:message code="checkbox.disabled"/>
	    <form:checkbox path="deleted" value="1"/><spring:message code="checkbox.deleted"/>
	    <input type="submit" id="btnSearch" value="<spring:message code="button.search"/>"/>
	  </div>
	  <div style="height:10px;">&nbsp;</div>
	  
	  <div style="width:100%">
	    <div class="newaccount">
	      <img id="img-new-enterprise-account" title="<spring:message code="wechat.enterprise.account.new"/>" src="${pageContext.request.contextPath}/images/new.png" style="width:100%; height:100%; cursor:pointer;" />
        </div>
	    <c:if test="${not empty queryEnterpriseAccountCriteriaModel.enterpriseAccountList}">
	      <c:forEach items="${queryEnterpriseAccountCriteriaModel.enterpriseAccountList}" var="enterpriseAccountVo">
	        <c:if test="${enterpriseAccountVo.disabled == false}">
	          <c:if test="${enterpriseAccountVo.deleted == false}">
	            <div class="activeaccount">
	              <a href="#" onclick="">
	                 <img src="${pageContext.request.contextPath}/images/nextPage.gif"/>
	               </a>
	              <span><c:out value="${enterpriseAccountVo.accountName}"/></span>
	              <ul>
	                 <li><a href="#">View</a></li>
	                 <li><a href="#">Edit</a></li>
	                 <li><a href="#">Disable</a></li>
	                 <li><a href="#">Delete</a></li>
	               </ul>
	            </div>
	          </c:if>
	          <c:if test="${enterpriseAccountVo.deleted == true}">
	            <div class="deletedaccount"><c:out value="${enterpriseAccountVo.accountName}"/></div>
	          </c:if>
	        </c:if>
	        <c:if test="${enterpriseAccountVo.disabled == true}">
	          <c:if test="${enterpriseAccountVo.deleted == false}">
	            <div class="disabledaccount"><c:out value="${enterpriseAccountVo.accountName}"/></div>
	          </c:if>
	          <c:if test="${enterpriseAccountVo.deleted == true}">
	            <div class="deletedaccount"><c:out value="${enterpriseAccountVo.accountName}"/></div>
	          </c:if>
	        </c:if>
	      </c:forEach>
	    </c:if>
	  </div>
	</form:form>
  </body>
</html>