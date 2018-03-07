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
	    	layer.confirm('<spring:message code="wechat.enterprise.account.disable.confirm"/>', 
	    		{
	    			btn: ['<spring:message code="button.confirm"/>','<spring:message code="button.cancel"/>'] //按钮
	    		}, 
	    		
	    		function(){
	    			$.ajax({
	    				type:"GET",
	    				dataType: "json",
	    				url: '${pageContext.request.contextPath}/enterprise/disableEnterpriseAccount.do?accountId=' + iaccountid,
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
	    	layer.confirm('<spring:message code="wechat.enterprise.account.enable.confirm"/>', 
	    		{
	    			btn: ['<spring:message code="button.confirm"/>','<spring:message code="button.cancel"/>'] //按钮
	    		}, 
	    		
	    		function(){
	    			$.ajax({
	    				type:"GET",
	    				dataType: "json",
	    				url: '${pageContext.request.contextPath}/enterprise/enableEnterpriseAccount.do?accountId=' + iaccountid,
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
	    	layer.confirm('<spring:message code="wechat.enterprise.account.delete.confirm"/>', 
	    		{
	    			btn: ['<spring:message code="button.confirm"/>','<spring:message code="button.cancel"/>'] //按钮
	    		}, 
	    		
	    		function(){
	    			$.ajax({
	    				type:"GET",
	    				dataType: "json",
	    				url: '${pageContext.request.contextPath}/enterprise/deleteEnterpriseAccount.do?accountId=' + iaccountid,
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

  <body>
    <div style="height:5px;margin-left:20px;">&nbsp;</div>
	<div style="margin-left:20px;">&nbsp;<spring:message code="wechat.enterprise.account"/></div>
	<div style="height:5px;margin-left:20px;">&nbsp;</div>
	<form:form id="frmEnterpriseMain" action="enterprisemain.do" method="POST" cssStyle="width:100%" commandName="enterpriseAccountCriteriaModel">
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
	          <img id="img-new-enterprise-account" onclick="openlayer('${pageContext.request.contextPath}/enterprise/createEnterpriseAccount.do', 2, '<spring:message code="wechat.enterprise.account"/>', '500px', '300px');" title="<spring:message code="wechat.enterprise.account.new"/>" src="${pageContext.request.contextPath}/images/new.png" style="width:100%; height:100%; cursor:pointer;"/>
	        </div>
          </div>
	      <c:if test="${not empty enterpriseAccountCriteriaModel.enterpriseAccountList}">
	        <c:forEach items="${enterpriseAccountCriteriaModel.enterpriseAccountList}" var="enterpriseAccountVo">
	          <c:if test="${enterpriseAccountVo.disabled == false}">
	            <c:if test="${enterpriseAccountVo.deleted == false}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:100px; top:0; left:0; z-index:1;background:green;">
                        <div style="display:inline-block;position:relative;width:150px;height:100px;background-color:green;text-align:center;line-height:100px;overflow:hidden;">
                          <c:out value="${enterpriseAccountVo.accountName}"/>
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
                                <li><a href="#" onclick="openlayer('${pageContext.request.contextPath}/enterprise/viewEnterpriseAccount.do?id='+'${enterpriseAccountVo.id}', 2, '<spring:message code="wechat.enterprise.account"/>', '500px', '300px');">&nbsp;<spring:message code="button.view"/></a></li>
                                <li><a href="#" onclick="openlayer('${pageContext.request.contextPath}/enterprise/updateEnterpriseAccount.do?id='+'${enterpriseAccountVo.id}', 2, '<spring:message code="wechat.enterprise.account"/>', '500px', '300px');">&nbsp;<spring:message code="button.update"/></a></li>
                                <li><a href="#" onclick="disableaccount('${enterpriseAccountVo.id}');">&nbsp;<spring:message code="button.disable"/></a></li>
                                <li><a href="#" onclick="deleteaccount(${enterpriseAccountVo.id});">&nbsp;<spring:message code="button.delete"/></a></li>
                              </ul>
                            </li>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
	            </c:if>
	            <c:if test="${enterpriseAccountVo.deleted == true}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:100px; top:0; left:0; z-index:1;background:gray;">
                        <div style="display:inline-block;position:relative;width:150px;height:100px;background:gray;text-align:center;line-height:100px;overflow:hidden;">
                          <c:out value="${enterpriseAccountVo.accountName}"/>
                        </div>
                      </div>
                    </div>
                  </div>
	            </c:if>
	          </c:if>
	          <c:if test="${enterpriseAccountVo.disabled == true}">
	            <c:if test="${enterpriseAccountVo.deleted == false}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:100px; top:0; left:0; z-index:1;background:lightgray;">
                        <div style="display:inline-block;position:relative;width:150px;height:100px;background:lightgray;text-align:center;line-height:100px;overflow:hidden;">
                          <c:out value="${enterpriseAccountVo.accountName}"/>
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
                                <li><a href="#" onclick="openlayer('${pageContext.request.contextPath}/enterprise/viewEnterpriseAccount.do?id='+'${enterpriseAccountVo.id}', 2, '<spring:message code="wechat.enterprise.account"/>', '500px', '300px');">&nbsp;<spring:message code="button.view"/></a></li>
                                <li><a href="#" onclick="enableaccount('${enterpriseAccountVo.id}');">&nbsp;<spring:message code="button.enable"/></a></li>
                                <li><a href="#" onclick="deleteaccount(${enterpriseAccountVo.id});">&nbsp;<spring:message code="button.delete"/></a></li>
                              </ul>
                            </li>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
	            </c:if>
	            <c:if test="${enterpriseAccountVo.deleted == true}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:100px; top:0; left:0; z-index:1;background:gray;">
                        <div style="display:inline-block;position:relative;width:150px;height:100px;background:gray;text-align:center;line-height:100px;overflow:hidden;">
                          <c:out value="${enterpriseAccountVo.accountName}"/>
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