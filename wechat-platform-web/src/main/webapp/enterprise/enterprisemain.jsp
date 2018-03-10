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

  <body style="overflow:hidden">
    <div style="height:30px;width:100%;display:inline-block;background:brown;text-align:left;line-height:30px;overflow:hidden;">
      <strong style="color:white;">&nbsp;&nbsp;<spring:message code="wechat.enterprise.account"/></strong>
    </div>
    <div class="container-fluid">
	  <form:form id="frmEnterpriseMain" action="enterprisemain.do" method="POST" cssStyle="width:100%" commandName="enterpriseAccountCriteriaModel">
	    <div class="row">
	      <div class="col-sm-12">
	        <div class="form-group">
	          <form:checkbox path="disabled" value="1"/>&nbsp;<spring:message code="checkbox.disabled"/>&nbsp;&nbsp;&nbsp;&nbsp;
	          <form:checkbox path="deleted" value="1"/>&nbsp;<spring:message code="checkbox.deleted"/>&nbsp;&nbsp;&nbsp;&nbsp;
	          <a href="#" onclick="$('#frmEnterpriseMain').submit();" style="text-decoration:none;" title="<spring:message code="button.search"/>">
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
                  <a href="#" onclick="openlayer('${pageContext.request.contextPath}/enterprise/createEnterpriseAccount.do', 2, '<spring:message code="wechat.enterprise.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="wechat.enterprise.account.new"/>">
                    <i class="fas fa-plus-square" style="font-size:30px;"></i>
                  </a>
                </div>
              </div>
              <div style="position:absolute; width:150px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">&nbsp;</div>
            </div>
          </div>
	      <c:if test="${not empty enterpriseAccountCriteriaModel.enterpriseAccountList}">
	        <c:forEach items="${enterpriseAccountCriteriaModel.enterpriseAccountList}" var="enterpriseAccountVo">
	          <c:if test="${enterpriseAccountVo.disabled == false}">
	            <c:if test="${enterpriseAccountVo.deleted == false}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:78px; top:22px; left:0px; z-index:1;background:green;">
                        <div style="display:inline-block;position:relative;width:150px;height:78px;background:green;text-align:center;line-height:78px;overflow:hidden;">
                          <c:out value="${enterpriseAccountVo.accountName}"/>
                        </div>
                      </div>
                      <div style="position:absolute; width:22px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">
                        &nbsp;<a href="#" onclick="openlayer('${pageContext.request.contextPath}/enterprise/viewEnterpriseAccount.do?id='+'${enterpriseAccountVo.id}', 2, '<spring:message code="wechat.enterprise.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.view"/>">
                                <i class="fas fa-eye"></i>
                              </a>&nbsp;
                        <a href="#" onclick="openlayer('${pageContext.request.contextPath}/enterprise/updateEnterpriseAccount.do?id='+'${enterpriseAccountVo.id}', 2, '<spring:message code="wechat.enterprise.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.update"/>">
                          <i class="fas fa-edit"></i>
                        </a>&nbsp;
                        <a href="#" onclick="disableaccount('${enterpriseAccountVo.id}');" style="text-decoration:none;" title="<spring:message code="button.disable"/>">
                          <i class="fas fa-thumbs-down"></i>
                        </a>&nbsp;
                        <a href="#" onclick="deleteaccount(${enterpriseAccountVo.id});" style="text-decoration:none;" title="<spring:message code="button.delete"/>">
                          <i class="fas fa-trash-alt"></i>
                        </a>
                      </div>
                    </div>
                  </div>
	            </c:if>
	            <c:if test="${enterpriseAccountVo.deleted == true}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:78px; top:0px; left:0px; z-index:1;background:gray;">
                        <div style="display:inline-block;position:relative;width:150px;height:78px;background:gray;text-align:center;line-height:78px;overflow:hidden;">
                          <c:out value="${enterpriseAccountVo.accountName}"/>
                        </div>
                      </div>
                      <div style="position:absolute; width:150px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">
                        &nbsp;<a href="#" onclick="openlayer('${pageContext.request.contextPath}/enterprise/viewEnterpriseAccount.do?id='+'${enterpriseAccountVo.id}', 2, '<spring:message code="wechat.enterprise.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.view"/>">
                                <i class="fas fa-eye"></i>
                              </a>
                      </div>
                    </div>
                  </div>
	            </c:if>
	          </c:if>
	          <c:if test="${enterpriseAccountVo.disabled == true}">
	            <c:if test="${enterpriseAccountVo.deleted == false}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:78px; top:22px; left:0px; z-index:1;background:lightgray;">
                        <div style="display:inline-block;position:relative;width:150px;height:78px;background:lightgray;text-align:center;line-height:78px;overflow:hidden;">
                          <c:out value="${enterpriseAccountVo.accountName}"/>
                        </div>
                      </div>
                      <div style="position:absolute; width:22px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">
                        &nbsp;<a href="#" onclick="openlayer('${pageContext.request.contextPath}/enterprise/viewEnterpriseAccount.do?id='+'${enterpriseAccountVo.id}', 2, '<spring:message code="wechat.enterprise.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.view"/>">
                                <i class="fas fa-eye"></i>
                              </a>&nbsp;
                        <a href="#" onclick="enableaccount('${enterpriseAccountVo.id}');" style="text-decoration:none;" title="<spring:message code="button.enable"/>">
                          <i class="fas fa-thumbs-up"></i>
                        </a>&nbsp;
                        <a href="#" onclick="deleteaccount(${enterpriseAccountVo.id});" style="text-decoration:none;" title="<spring:message code="button.delete"/>">
                          <i class="fas fa-trash-alt"></i>
                        </a>
                      </div>
                    </div>
                  </div>
	            </c:if>
	            <c:if test="${enterpriseAccountVo.deleted == true}">
	              <div class="col-sm-2">
                    <div style="position:relative;width:150px;height:100px; margin-bottom:20px;box-shadow: 5px 5px 2px #888888;">
                      <div style="position:absolute; width:150px; height:78px; top:22px; left:0px; z-index:1;background:gray;">
                        <div style="display:inline-block;position:relative;width:150px;height:78px;background:gray;text-align:center;line-height:78px;overflow:hidden;">
                          <c:out value="${enterpriseAccountVo.accountName}"/>
                        </div>
                      </div>
                      <div style="position:absolute; width:150px; height:22px; top:0px; right:0px; z-index:2; background:yellow;">
                        &nbsp;<a href="#" onclick="openlayer('${pageContext.request.contextPath}/enterprise/viewEnterpriseAccount.do?id='+'${enterpriseAccountVo.id}', 2, '<spring:message code="wechat.enterprise.account"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.view"/>">
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
	  </form:form>
	</div>
  </body>
</html>