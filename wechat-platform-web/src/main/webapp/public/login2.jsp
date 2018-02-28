<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title><spring:message code="application.title"/></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/login.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/jquery-ui.css"/>
    <script src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/jquery-ui.js"></script>
    <script type="text/javascript">
        if (window.opener != null) {
           	window.opener.location = "${pageContext.request.contextPath}/public/logout.jsp";
           	window.close();
		}
        
        if (parent.ifrmContent != null) {
			window.parent.location = "${pageContext.request.contextPath}/public/logout.jsp";
		}

		function onload() {
			document.getElementById("username").focus();
		}
		
		$(function(){
			$("#forget_block").dialog({
    			autoOpen: false,
    		    height: 250,
    		    width: 330,
    		    modal: true
			});
			
			$("#forget").click(function(){
				$("#forget_block").dialog("open");					   
			});
			
			//$("#btn_cancel").click(function(){
			//	alert("ok");
			//	$("#forget_block").dialog("close");					   
			//});
		});
    </script>
  </head>
  <body onload="javascript:onload();" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" rightmargin="0">
    <table id="layoutTable">
      <tr>
		<td class="top">&nbsp;</td>
      </tr>
      <tr>
        <td class="middle">
		  <div id="container">
		    <div id="logo">
			  <img src="${pageContext.request.contextPath}/images/login/logo.jpg"/>
		    </div>
		    <div id="login">
		      <form:form id="frmLogin" action="login.do" method="POST" commandName="user">
			    <div class="info_div">
			      <span></span>
			    </div>
			    <div class="username_div">
			      <form:input path="username" maxlength="10" placeholder="Username" style="width:100px"/>
			      <font color="red"><form:errors path="username"/></font>
			    </div>
			    <div class="password_div">
			      <form:password path="password" maxlength="10" placeholder="Password" style="width:100px"/>
			      <font color="red"><form:errors path="password"/></font>
			    </div>
                <div class="forget_div">
                  <a href="#" id="forget"><spring:message code="login.resetpassword"/></a>
                </div>
			    <div class="submit_div">
			      <input type="submit" value='<spring:message code="login.login"/>'/>
			    </div>
		      </form:form>
		    </div>
		    <div class="record">
              <a href="#"><spring:message code="application.legalterms"/></a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;&copy;<spring:message code="application.copyright"/> - XYH&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;
            </div>
	      </div>
		</td>
	  </tr>
	  <tr>
		<td class="bottom">&nbsp;</td>
      </tr>
    </table>
    
    <!--弹出层_系统设置-->
    <div class="block_div" id="forget_block">
	  <iframe id="ifrmResetPassword" style="width:300px;height:180px;background-color: #adb9cd;border:none;" src="${pageContext.request.contextPath}/public/resetpassword.do"></iframe>
    </div>
  </body>
</html>