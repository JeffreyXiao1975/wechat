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
    <script src="${pageContext.request.contextPath}/js/wechatplatform.js"></script>
    <script type="text/javascript">
	    function disableaccount(iaccountid) {
	    	layer.confirm('<spring:message code="wechat.subscription.account.disable.confirm"/>', 
	    		{
	    			btn: ['<spring:message code="button.confirm"/>','<spring:message code="button.cancel"/>'] //按钮
	    		}, 
	    		
	    		function(){
	    			$.ajax({
	    				type:"GET",
	    				dataType: "json",
	    				url: '${pageContext.request.contextPath}/subscription/disableSubscriptionAccount.do?accountId=' + iaccountid,
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
	    	layer.confirm('<spring:message code="wechat.subscription.account.enable.confirm"/>', 
	    		{
	    			btn: ['<spring:message code="button.confirm"/>','<spring:message code="button.cancel"/>'] //按钮
	    		}, 
	    		
	    		function(){
	    			$.ajax({
	    				type:"GET",
	    				dataType: "json",
	    				url: '${pageContext.request.contextPath}/subscription/enableSubscriptionAccount.do?accountId=' + iaccountid,
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
	    	layer.confirm('<spring:message code="wechat.subscription.account.delete.confirm"/>', 
	    		{
	    			btn: ['<spring:message code="button.confirm"/>','<spring:message code="button.cancel"/>'] //按钮
	    		}, 
	    		
	    		function(){
	    			$.ajax({
	    				type:"GET",
	    				dataType: "json",
	    				url: '${pageContext.request.contextPath}/subscription/deleteSubscriptionAccount.do?accountId=' + iaccountid,
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
    <div style="height:30px;width:100%;display:inline-block;background:brown;text-align:left;line-height:30px;overflow:hidden;">
      <strong style="color:white;">&nbsp;&nbsp;<spring:message code="wechat.subscription.account"/></strong>
    </div>
    <div class="container-fluid"> 
	  <form:form id="frmSubscriptionMain" action="subscriptionmain.do" method="POST" cssStyle="width:100%" commandName="subscriptionAccountCriteriaModel">
	    <div class="row">
	      <div class="col-sm-12">
	        <div class="form-group">
	          <form:checkbox path="disabled" value="1"/>&nbsp;<spring:message code="checkbox.disabled"/>&nbsp;&nbsp;&nbsp;&nbsp;
	          <form:checkbox path="deleted" value="1"/>&nbsp;<spring:message code="checkbox.deleted"/>&nbsp;&nbsp;&nbsp;&nbsp;
	          <a href="#" onclick="$('#frmSubscriptionMain').submit();" style="text-decoration:none;" title="<spring:message code="button.search"/>">
              <i class="fas fa-search-plus"></i>
            </a>&nbsp;
	        </div>
	      </div>
	    </div>
	    
	    <div class="row">
	      <div class="col-sm-2">
	        <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
              <div style="position:absolute; width:150px; height:78px; top:22px; left:0px; z-index:1;background:white;">
                <div style="display:inline-block;position:relative;width:150px;height:78px;background:lightgray;text-align:center;line-height:78px;overflow:hidden;">
                  <a href="#" onclick="openlayer('${pageContext.request.contextPath}/subscription/createSubscriptionAccount.do', 2, '<spring:message code="wechat.subscription.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="wechat.subscription.account.new"/>">
                    <i class="fas fa-plus-square" style="font-size:30px;"></i>
                  </a>
                </div>
              </div>
              <div style="position:absolute; width:150px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">&nbsp;</div>
            </div>
          </div>
	      <c:if test="${not empty subscriptionAccountCriteriaModel.subscriptionAccountList}">
	        <c:forEach items="${subscriptionAccountCriteriaModel.subscriptionAccountList}" var="subscriptionAccountVo">
	          <c:if test="${subscriptionAccountVo.disabled == false}">
	            <c:if test="${subscriptionAccountVo.deleted == false}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:78px; top:22px; left:0px; z-index:1;background:green;">
                        <div style="display:inline-block;position:relative;width:150px;height:78px;background-color:green;text-align:center;line-height:78px;overflow:hidden;">
                          <c:out value="${subscriptionAccountVo.accountName}"/>
                        </div>
                      </div>
                      <div style="position:absolute; width:150px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">
                        &nbsp;<a href="#" onclick="openlayer('${pageContext.request.contextPath}/subscription/viewSubscriptionAccount.do?id='+'${subscriptionAccountVo.id}', 2, '<spring:message code="wechat.subscription.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.view"/>">
                                <i class="fas fa-eye"></i>
                              </a>&nbsp;
                        <a href="#" onclick="openlayer('${pageContext.request.contextPath}/subscription/updateSubscriptionAccount.do?id='+'${subscriptionAccountVo.id}', 2, '<spring:message code="wechat.subscription.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.update"/>">
                          <i class="fas fa-edit"></i>
                        </a>&nbsp;
                        <a href="#" onclick="disableaccount('${subscriptionAccountVo.id}');" style="text-decoration:none;" title="<spring:message code="button.disable"/>">
                          <i class="fas fa-thumbs-down"></i>
                        </a>&nbsp;
                        <a href="#" onclick="deleteaccount(${subscriptionAccountVo.id});" style="text-decoration:none;" title="<spring:message code="button.delete"/>">
                          <i class="fas fa-trash-alt"></i>
                        </a>
                      </div>
                    </div>
                  </div>
	            </c:if>
	            <c:if test="${subscriptionAccountVo.deleted == true}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:78px; top:22px; left:0px; z-index:1;background:gray;">
                        <div style="display:inline-block;position:relative;width:150px;height:78px;background:gray;text-align:center;line-height:78px;overflow:hidden;">
                          <c:out value="${subscriptionAccountVo.accountName}"/>
                        </div>
                      </div>
                    <div style="position:absolute; width:150px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">
                        &nbsp;<a href="#" onclick="openlayer('${pageContext.request.contextPath}/subscription/viewSubscriptionAccount.do?id='+'${subscriptionAccountVo.id}', 2, '<spring:message code="wechat.subscription.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.view"/>">
                                <i class="fas fa-eye"></i>
                              </a>
                      </div>
                    </div>
                  </div>
	            </c:if>
	          </c:if>
	          <c:if test="${subscriptionAccountVo.disabled == true}">
	            <c:if test="${subscriptionAccountVo.deleted == false}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:78px; top:22px; left:0px; z-index:1;background:lightgray;">
                        <div style="display:inline-block;position:relative;width:150px;height:78px;background:lightgray;text-align:center;line-height:78px;overflow:hidden;">
                          <c:out value="${subscriptionAccountVo.accountName}"/>
                        </div>
                      </div>
                      <div style="position:absolute; width:150px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">
                        &nbsp;<a href="#" onclick="openlayer('${pageContext.request.contextPath}/subscription/viewSubscriptionAccount.do?id='+'${subscriptionAccountVo.id}', 2, '<spring:message code="wechat.subscription.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.view"/>">
                                <i class="fas fa-eye"></i>
                              </a>&nbsp;
                        <a href="#" onclick="enableaccount('${subscriptionAccountVo.id}');" style="text-decoration:none;" title="<spring:message code="button.enable"/>">
                          <i class="fas fa-thumbs-up"></i>
                        </a>&nbsp;
                        <a href="#" onclick="deleteaccount(${subscriptionAccountVo.id});" style="text-decoration:none;" title="<spring:message code="button.delete"/>">
                          <i class="fas fa-trash-alt"></i>
                        </a>
                      </div>
                    </div>
                  </div>
	            </c:if>
	            <c:if test="${subscriptionAccountVo.deleted == true}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:78px; top:22px; left:0px; z-index:1;background:gray;">
                        <div style="display:inline-block;position:relative;width:150px;height:78px;background:gray;text-align:center;line-height:78px;overflow:hidden;">
                          <c:out value="${subscriptionAccountVo.accountName}"/>
                        </div>
                      </div>
                      <div style="position:absolute; width:150px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">
                        &nbsp;<a href="#" onclick="openlayer('${pageContext.request.contextPath}/subscription/viewSubscriptionAccount.do?id='+'${subscriptionAccountVo.id}', 2, '<spring:message code="wechat.subscription.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.view"/>">
                                <i class="fas fa-eye"></i>
                              </a>
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