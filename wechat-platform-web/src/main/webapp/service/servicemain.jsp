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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/wechataccount.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/layer.js"></script>
    <script src="${pageContext.request.contextPath}/js/wechatplatform.js"></script>
    <script type="text/javascript">
	    function disableaccount(iaccountid) {
	    	layer.confirm('<spring:message code="wechat.service.account.disable.confirm"/>', 
	    		{
	    			btn: ['<spring:message code="button.confirm"/>','<spring:message code="button.cancel"/>'] //按钮
	    		}, 
	    		
	    		function(){
	    			$.ajax({
	    				type:"GET",
	    				dataType: "json",
	    				url: '${pageContext.request.contextPath}/service/disableServiceAccount.do?accountId=' + iaccountid,
	    				success: function (result) {
	    					if (result.success == "true") {
	    						layer.msg(result.message, {icon: 1});
	    					} else {
	    						layer.msg(result.message, {icon: 1});
	    					}
	    				},
	    				error : function() {
	    					layer.msg('error', {icon: 1});
	    				}
	    			});
	    		}, 
	    		function(){
	    			layer.close();
	    		}
	    	);
		}
	    
	    function enableaccount(iaccountid) {
	    	layer.confirm('<spring:message code="wechat.service.account.enable.confirm"/>', 
	    		{
	    			btn: ['<spring:message code="button.confirm"/>','<spring:message code="button.cancel"/>'] //按钮
	    		}, 
	    		
	    		function(){
	    			$.ajax({
	    				type:"GET",
	    				dataType: "json",
	    				url: '${pageContext.request.contextPath}/service/enableServiceAccount.do?accountId=' + iaccountid,
	    				success: function (result) {
	    					if (result.success == "true") {
	    						layer.msg(result.message, {icon: 1});
	    					} else {
	    						layer.msg(result.message, {icon: 1});
	    					}
	    				},
	    				error : function() {
	    					layer.msg('error', {icon: 1});
	    				}
	    			});
	    		}, 
	    		function(){
	    			layer.close();
	    		}
	    	);
		}
	    
	    function deleteccount(iaccountid) {
	    	layer.confirm('<spring:message code="wechat.service.account.delete.confirm"/>', 
	    		{
	    			btn: ['<spring:message code="button.confirm"/>','<spring:message code="button.cancel"/>'] //按钮
	    		}, 
	    		
	    		function(){
	    			$.ajax({
	    				type:"GET",
	    				dataType: "json",
	    				url: '${pageContext.request.contextPath}/service/deleteServiceAccount.do?accountId=' + iaccountid,
	    				success: function (result) {
	    					if (result.success == "true") {
	    						layer.msg(result.message, {icon: 1});
	    					} else {
	    						layer.msg(result.message, {icon: 1});
	    					}
	    				},
	    				error : function() {
	    					layer.msg('error', {icon: 1});
	    				}
	    			});
	    		}, 
	    		function(){
	    			layer.close();
	    		}
	    	);
		}
    </script>
  </head>

  <body style="overflow:hidden">
    <div style="height:5px;margin-left:20px;">&nbsp;</div>
	<div style="margin-left:20px;">&nbsp;<spring:message code="wechat.service.account"/></div>
	<div style="height:5px;margin-left:20px;">&nbsp;</div>
	<form:form id="frmServiceMain" action="servicemain.do" method="POST" cssStyle="width:100%" commandName="queryServiceAccountCriteriaModel">
	  <div style="top:20px; margin-left:20px; border:1px solid #333">
	    <form:checkbox path="disabled" value="1"/><spring:message code="checkbox.disabled"/>
	    <form:checkbox path="deleted" value="1"/><spring:message code="checkbox.deleted"/>
	    <input type="submit" id="btnSearch" value="<spring:message code="button.search"/>"/>
	  </div>
	  <div style="height:10px;margin-left:20px;">&nbsp;</div>
	  
	  <div class="container-fluid">
	    <div class="row">
	      <div class="col-sm-2">
	        <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
	          <img id="img-new-service-account" onclick="openlayer('${pageContext.request.contextPath}/service/createServiceAccount.do', 2, '<spring:message code="wechat.service.account"/>', '500px', '300px');" title="<spring:message code="wechat.service.account.new"/>" src="${pageContext.request.contextPath}/images/new.png" style="width:100%; height:100%; cursor:pointer;"/>
	        </div>
          </div>
	      <c:if test="${not empty queryServiceAccountCriteriaModel.serviceAccountList}">
	        <c:forEach items="${queryServiceAccountCriteriaModel.serviceAccountList}" var="serviceAccountVo">
	          <c:if test="${serviceAccountVo.disabled == false}">
	            <c:if test="${serviceAccountVo.deleted == false}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:100px; top:0; left:0; z-index:1;background:green;">
                        <div style="display:inline-block;position:relative;width:150px;height:100px;background-color:green;text-align:center;line-height:100px;overflow:hidden;">
                          <c:out value="${serviceAccountVo.accountName}"/>
                        </div>
                      </div>
                      <div style="position:absolute; width:22px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">
                        <div class="accountmenu">
                          <ul>
                            <li>
                              <a href="#">
                                <img src="${pageContext.request.contextPath}/images/wechat.png" class="img"/>
                              </a>
              
                              <ul>
                                <li><a href="#" onclick="openlayer('${pageContext.request.contextPath}/service/viewServiceAccount.do?id='+'${serviceAccountVo.id}', 2, '<spring:message code="wechat.service.account"/>', '500px', '300px');">&nbsp;<spring:message code="button.view"/></a></li>
                                <li><a href="#" onclick="openlayer('${pageContext.request.contextPath}/service/updateServiceAccount.do?id='+'${serviceAccountVo.id}', 2, '<spring:message code="wechat.service.account"/>', '500px', '300px');">&nbsp;<spring:message code="button.update"/></a></li>
                                <li><a href="#" onclick="disableaccount('${serviceAccountVo.id}');">&nbsp;<spring:message code="button.disable"/></a></li>
                                <li><a href="#" onclick="deleteaccount(${serviceAccountVo.id});">&nbsp;<spring:message code="button.delete"/></a></li>
                              </ul>
                            </li>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
	            </c:if>
	            <c:if test="${serviceAccountVo.deleted == true}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:100px; top:0; left:0; z-index:1;background:gray;">
                        <div style="display:inline-block;position:relative;width:150px;height:100px;background:gray;text-align:center;line-height:100px;overflow:hidden;">
                          <c:out value="${serviceAccountVo.accountName}"/>
                        </div>
                      </div>
                    </div>
                  </div>
	            </c:if>
	          </c:if>
	          <c:if test="${serviceAccountVo.disabled == true}">
	            <c:if test="${serviceAccountVo.deleted == false}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:100px; top:0; left:0; z-index:1;background:lightgray;">
                        <div style="display:inline-block;position:relative;width:150px;height:100px;background:lightgray;text-align:center;line-height:100px;overflow:hidden;">
                          <c:out value="${serviceAccountVo.accountName}"/>
                        </div>
                      </div>
                      <div style="position:absolute; width:22px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">
                        <div class="accountmenu">
                          <ul>
                            <li>
                              <a href="#">
                                <img src="${pageContext.request.contextPath}/images/wechat.png" class="img"/>
                              </a>
              
                              <ul>
                                <li><a href="#" onclick="openlayer('${pageContext.request.contextPath}/service/viewServiceAccount.do?id='+'${serviceAccountVo.id}', 2, '<spring:message code="wechat.service.account"/>', '500px', '300px');">&nbsp;<spring:message code="button.view"/></a></li>
                                <li><a href="#" onclick="enableaccount('${serviceAccountVo.id}');">&nbsp;<spring:message code="button.enable"/></a></li>
                                <li><a href="#" onclick="deleteaccount(${serviceAccountVo.id});">&nbsp;<spring:message code="button.delete"/></a></li>
                              </ul>
                            </li>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
	            </c:if>
	            <c:if test="${serviceAccountVo.deleted == true}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:100px; top:0; left:0; z-index:1;background:gray;">
                        <div style="display:inline-block;position:relative;width:150px;height:100px;background:gray;text-align:center;line-height:100px;overflow:hidden;">
                          <c:out value="${serviceAccountVo.accountName}"/>
                        </div>
                      </div>
                    </div>
                  </div>
	            </c:if>
	          </c:if>
	        </c:forEach>
	      </c:if>
	    </div>
	  </div>
	</form:form>
  </body>
</html>