<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/login.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/jquery-ui.css"/>
    <script src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/jquery-ui.js"></script>
    <script type="text/javascript">
		$(function(){
			$("#txtUsername").focus();
			
			$("#btn_cancel").click(function(){
				//$("#forget_block", parent.document).dialog("close");
			});
		});
    </script>
  </head>
  <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" rightmargin="0">
    <!--弹出层_系统设置-->
    
	  <div class="title"><span><spring:message code="login.resetpassword"/></span></div>
      <div class="spliter h_5"></div>
      <form:form id="frmResetPassword" action="login.do" method="POST" commandName="userModel">
        <div>
		  <table>
		    <tr class="search_tab">
              <td class="label">&nbsp;</td>
              <td></td>
            </tr>
            <tr class="search_tab">
              <td class="label"><spring:message code="login.username"/>:&nbsp;</td>
              <td><form:input id="txtUsername" path="username" maxlength="10" placeholder="Username"/></td>
            </tr>
            <tr class="search_tab">
              <td class="label">&nbsp;</td>
              <td></td>
            </tr>
          </table>	
	    </div>
        <div class="btn_div">
          <input type="button" class="btn01" value="<spring:message code="button.passwordtomailbox"/>" id="btn_send"/>
          <input type="button" class="btn" value="<spring:message code="button.cancel"/>" id="btn_cancel"/>
        </div>
      </form:form>
      <div class="spliter h_5" style="height:10px;"></div>
  </body>
</html>