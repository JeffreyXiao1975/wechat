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
    		$("#frmQueryPlatformUser").ajaxSubmit({
    			type : "post",
    			url : "${pageContext.request.contextPath}/platform/queryUser.do",
    			success:function(data) {
    				alter("ok");
    			}
    		});
    	}
    </script>
  </head>
  <body>
    <img id="imgLoading" src="${pageContext.request.contextPath}/images/loading_red.gif" style="position:absolute;left:40%;top:40%;width:100px;height:100px;display:none;"/>
	<form:form id="frmQueryPlatformUser" action="queryUser.do" method="POST" cssStyle="width:100%" commandName="queryPlatformUserCriteriaModel">
	  <table width="100%" cellspacing="0">
	    <tr>
	      <td>
	        <fieldset>
	          <legend><spring:message code="title.search.filter"/></legend>
	          <table>
	            <tr>
	              <td>&nbsp;<spring:message code="wechat.platform.usersetting.username"/>:&nbsp;</td>
	              <td>
	                <form:input path="username" size="20" maxlength="100"/>&nbsp;
	              </td>
	              <td>
	                  <input type="button" id="btnSearch" value="<spring:message code="button.search"/>" onclick="submitQuery();"/>
	              </td>
	            </tr>
	          </table>
	        </fieldset>
	      </td>
	    </tr>
	  </table>
	  <table>
	    <tr>
	      <td>
	        <fieldset id="myDiv">
	          <legend><spring:message code="title.search.result"/></legend>
	          <table>
	            <tr>
	              <td>&nbsp;</td>
	              <td>&nbsp;<spring:message code="wechat.platform.usersetting.username"/></td>
	              <td>&nbsp;<spring:message code="wechat.platform.usersetting.password"/></td>
	              <td>&nbsp;<spring:message code="wechat.platform.common.createdtime"/></td>
	              <td>&nbsp;<spring:message code="wechat.platform.common.updatedtime"/></td>
	              <td>&nbsp;</td>
	            </tr>
	            <c:if test="${not empty queryPlatformUserCriteriaModel.userlist}">
	              <c:forEach items="${queryPlatformUserCriteriaModel.userlist}" var="platformUserVo">
	                <tr>
	                  <td>&nbsp;<c:out value="${platformUserVo.id}"/></td>
	                  <td>&nbsp;<c:out value="${platformUserVo.username}"/></td>
	                  <td>&nbsp;<c:out value="${platformUserVo.password}"/></td>
	                  <td>&nbsp;<c:out value="${platformUserVo.createdTime}"/></td>
	                  <td>&nbsp;<c:out value="${platformUserVo.updatedTime}"/></td>
	                  <td>&nbsp;</td>
	                </tr>
	              </c:forEach>
	            </c:if>
	            <tr>
	              <td colspan="6">	                
	                <form:hidden path="totalPageNumber"/>
	                <form:hidden path="currentPageNumber"/>
	                <form:hidden path="firstPage"/>
	                <form:hidden path="lastPage"/>
	                <form:hidden path="pageSize"/>
	              </td>
	            </tr>
	          </table>
	        </fieldset>
	      </td>
	    </tr>
	  </table>
	</form:form>
  </body>
</html>