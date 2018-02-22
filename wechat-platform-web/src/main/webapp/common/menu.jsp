<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String contextPath = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <style type="text/css">
      A:visited { color:blue }
      A:active { color:blue }
      A:link { color:blue }
    </style>
    <script type="text/javascript" src="<%=contextPath%>/scripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/scripts/template-web.js"></script>
    <script type="text/javascript">
      $(document).ready(function() {
    	  $("#trIdentityMgt").click(function() {
	  		  $("#trIdentity").slideToggle("slow");
	  		  $("#trAuthentication").slideToggle("slow");
	  		  if ($("#imgIdentityMgt").attr("src") == "<%= contextPath%>/images/plus.gif") {
	  			  $("#imgIdentityMgt").attr("src", "<%= contextPath%>/images/minus.gif");
	  		  } else {
	  			  $("#imgIdentityMgt").attr("src", "<%= contextPath%>/images/plus.gif");
	  		  }
	  	  });
      });
    </script>
  </head>
    <body style="margin-left:0px; margin-top:0px; margin-right:0px; margin-bottom:0px; height:100%;" >
      <table cellspacing="0" cellpadding="0" width="100%">
        <tr>
          <td nowrap="nowrap">
            <table width="100%" cellspacing="0" cellpadding="0" style="height:100%;">
			  <tr>
			    <td height="22" style="font-weight: bold;font-family: verdana, arial, sans-serif;font-size: 13px; color:yellow;background-color:lightblue;">&nbsp;&nbsp;<spring:message code="application.menu.usgpPlatform"/></td>
			  </tr>
			  <tr>
			    <td>
				  <table width="100%" border="0" cellspacing="0" cellpadding="0" style="font-weight: bold;font-family: verdana, arial, sans-serif;font-size: 10px;">
				    <tr style="cursor:hand;height:20px;" id="trIdentityMgt">
					  <td width="15" align="right">
					    <img src="<%= contextPath%>/images/minus.gif" id="imgIdentityMgt"/>&nbsp;
					  </td>
					  <td colspan="2" nowrap="nowrap"><spring:message code="application.menu.identityManagement"/></td>
					</tr>
					<tr style="height:20px;" id="trIdentity">
					  <td style="width:15px;" align="right">&nbsp;</td>
					  <td style="width:10px;">&nbsp;</td>
					  <td align="left" nowrap="nowrap"><a href="<%= contextPath%>/identity/queryIdObject.do" target="ifrmContent"><spring:message code="application.menu.identity"/></a></td>
					</tr>
					<tr style="height:20px;" id="trAuthentication">
					  <td style="width:15px;" align="right">&nbsp;</td>
					  <td style="width:10px;">&nbsp;</td>
					  <td align="left" nowrap="nowrap"><a href="<%= contextPath%>/identity/queryAuthentication.do" target="ifrmContent"><spring:message code="application.menu.authentication"/></a></td>
					</tr>
					<tr style="height:20px;" id="trAuthentication">
					  <td style="width:15px;" align="right">&nbsp;</td>
					  <td style="width:10px;">&nbsp;</td>
					  <td align="left" nowrap="nowrap"><a href="<%= contextPath%>/navigator.do" target="ifrmContent">Navigation</a></td>
					</tr>
			      </table>
				</td>
			  </tr>
			  <tr>
			    <td height="22" style="font-weight: bold;font-family: verdana, arial, sans-serif;font-size: 13px; color:yellow;background-color:lightblue;">&nbsp;&nbsp;<spring:message code="application.menu.masterData"/></td>
			  </tr>
			</table>
          </td>
        </tr>
        <tr><td>&nbsp;</td></tr>
      </table>
    </body>
</html>