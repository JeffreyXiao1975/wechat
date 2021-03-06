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
	    function disableuser(iuserid) {
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
	    
	    function enableuser(iuserid) {
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
	    
	    function deleteuser(iuserid) {
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
    <div style="height:30px;width:100%;display:inline-block;background:brown;text-align:left;line-height:30px;overflow:hidden;">
      <strong style="color:white;">&nbsp;&nbsp;<spring:message code="wechat.platform.usersetting"/></strong>
    </div>
    
    <div style="height:10px;margin-left:10px;"></div>
    <div class="container-fluid" style="margin-left:0px;">
	  <form:form id="frmQueryPlatformUser" action="platformUserSetting.do" method="POST" class="form-inline" commandName="platformUserCriteriaModel">
	    <div class="col-md-12">
          <div class="form-group">
            <label for="username"><spring:message code="wechat.platform.usersetting.username"/>&nbsp;</label>
            <form:input id="username" path="username" size="20" maxlength="100"/>&nbsp;&nbsp;
            <form:checkbox path="disabledIncluded" value="1"/><spring:message code="checkbox.disabled"/>&nbsp;&nbsp;
	        <form:checkbox path="deletedIncluded" value="1"/><spring:message code="checkbox.deleted"/>&nbsp;&nbsp;
            <a href="#" onclick="$('#frmQueryPlatformUser').submit();" style="text-decoration:none;" title="<spring:message code="button.search"/>">
              <i class="fas fa-search-plus"></i>
            </a>&nbsp;
          </div>
        </div>
      
	    <div class="col-md-12">
          <div style="height:10px;">&nbsp;</div>
        </div>
        <div class="col-md-12">
	      <table class="table table-striped table-bordered table-hover">
	        <thead>
	          <tr>
	            <td>&nbsp;#</td>
	            <td>&nbsp;<spring:message code="wechat.platform.usersetting.username"/></td>
	            <td>&nbsp;<spring:message code="wechat.platform.common.createdtime"/></td>
	            <td>&nbsp;<spring:message code="wechat.platform.common.updatedtime"/></td>
	            <td>&nbsp;</td>
	          </tr>
	        </thead>
	        <tbody>
	          <c:if test="${not empty platformUserCriteriaModel.userlist}">
	            <c:forEach items="${platformUserCriteriaModel.userlist}" var="platformUserVo">
	              <tr>
	                <td>&nbsp;<c:out value="${platformUserVo.id}"/></td>
	                <td>&nbsp;<c:out value="${platformUserVo.username}"/></td>
	                <td>&nbsp;<c:out value="${platformUserVo.createdTime}"/></td>
	                <td>&nbsp;<c:out value="${platformUserVo.updatedTime}"/></td>
	                <td>
	                  <c:if test="${platformUserVo.deleted == false}">
	                    <c:if test="${platformUserVo.disabled == true}">
	                      <a href="#" onclick="openlayer('${pageContext.request.contextPath}/platform/viewPlatformUser.do?id='+'${platformUserVo.id}', 2, '<spring:message code="wechat.platform.usersetting"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.view"/>">
                            <i class="fas fa-eye"></i>
                          </a>&nbsp;
                          <a href="#" onclick="enableuser('${platformUserVo.id}');" style="text-decoration:none;" title="<spring:message code="button.enable"/>">
                            <i class="fas fa-thumbs-up"></i>
                          </a>&nbsp;
                          <a href="#" onclick="deleteuser('${platformUserVo.id}');" style="text-decoration:none;" title="<spring:message code="button.delete"/>">
                            <i class="far fa-trash-alt"></i>
                          </a>
	                    </c:if>
	                    <c:if test="${platformUserVo.disabled == false}">
	                      <a href="#" onclick="openlayer('${pageContext.request.contextPath}/platform/viewPlatformUser.do?id='+'${platformUserVo.id}', 2, '<spring:message code="wechat.platform.usersetting"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.view"/>">
                            <i class="fas fa-eye"></i>
                          </a>&nbsp;
                          <a href="#" onclick="openlayer('${pageContext.request.contextPath}/platform/updatePlatformUser.do?id='+'${platformUserVo.id}', 2, '<spring:message code="wechat.platform.usersetting"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.update"/>">
                            <i class="fas fa-edit"></i>
                          </a>&nbsp;
                          <a href="#" onclick="disableuser('${platformUserVo.id}');" style="text-decoration:none;" title="<spring:message code="button.disable"/>">
                            <i class="far fa-thumbs-down"></i>
                          </a>&nbsp;
                          <a href="#" onclick="deleteuser('${platformUserVo.id}');" style="text-decoration:none;" title="<spring:message code="button.delete"/>">
                            <i class="far fa-trash-alt"></i>
                          </a>
	                    </c:if>
	                  </c:if>
	                  <c:if test="${platformUserVo.deleted == true}">
	                    <a href="#" onclick="openlayer('${pageContext.request.contextPath}/platform/viewPlatformUser.do?id='+'${platformUserVo.id}', 2, '<spring:message code="wechat.platform.usersetting"/>', '500px', '300px');" style="text-decoration:none;" title="<spring:message code="button.view"/>">
                          <i class="fas fa-eye"></i>
                        </a>&nbsp;
	                  </c:if>
	                </td>
	              </tr>
	            </c:forEach>
	          </c:if>
	        </tbody>
	      </table>
	      <form:hidden path="totalPageNumber"/>
	      <form:hidden path="currentPageNumber"/>
	      <form:hidden path="firstPage"/>
	      <form:hidden path="lastPage"/>
	      <form:hidden path="pageSize"/>
	    </div>
	    <div class="col-md-12">
	      <div style="margin-left:10px;">
	        <a href="#" style="text-decoration:none;" title="<spring:message code="page.first"/>">
              <i class="fas fa-fast-backward"></i>
            </a>&nbsp;
            <a href="#" style="text-decoration:none;" title="<spring:message code="page.previous"/>">
              <i class="fas fa-backward"></i>
            </a>&nbsp;
            <a href="#" style="text-decoration:none;" title="<spring:message code="page.next"/>">
              <i class="fas fa-forward"></i>
            </a>&nbsp;
            <a href="#" style="text-decoration:none;" title="<spring:message code="page.last"/>">
              <i class="fas fa-fast-forward"></i>
            </a>&nbsp;
            <spring:message code="page.current"/>:&nbsp;<c:out value="${platformUserCriteriaModel.currentPageNumber}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
            <spring:message code="page.total"/>:&nbsp;<c:out value="${platformUserCriteriaModel.totalPageNumber}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#" style="text-decoration:none;" title="<spring:message code="button.create"/>">
              <i class="fas fa-plus-square"></i>
            </a>&nbsp;
	      </div>
	    </div>
	  </form:form>
	</div>
  </body>
</html>