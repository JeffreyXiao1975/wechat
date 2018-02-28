<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><spring:message code="application.title"/></title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container">    
      <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
        <div class="panel panel-info" >
          <div class="panel-heading">
            <div class="panel-title">Welcome to XYH WeChat Platform</div>
            <div style="float:right; position: relative; top:-26px">
              <img src="${pageContext.request.contextPath}/images/wechat.png" style="width:30px;height:30px;">
            </div>
          </div>     

          <div style="padding-top:30px" class="panel-body" >
            <form:form id="frmLogin" action="login.do" method="POST" commandName="user" class="form-horizontal" role="form">
              <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12">
                <p>Username is mandatory!<p>
                <p>Password is mandatory!<p>
              </div>

              <div style="margin-bottom: 25px" class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                <form:input id="login-username" path="username" maxlength="10" placeholder="Username" class="form-control"/>                                        
              </div>
                                
              <div style="margin-bottom: 25px" class="input-group">
                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                <form:password id="login-password" path="password" maxlength="10" placeholder="Password" class="form-control"/>
              </div> 

              <div style="margin-top:10px" class="form-group">
                <!-- Button -->
                <div class="col-sm-12 controls">
                  <a id="btn-login" href="#" onClick="$('#frmLogin').submit()" class="btn btn-success">&nbsp;&nbsp;&nbsp;&nbsp;Login&nbsp;&nbsp;&nbsp;&nbsp;</a>
                </div>
              </div>

              <div class="form-group">
                <div class="col-md-12 control">
                  <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                    Forget Password?
                    <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">Click Here</a>
                  </div>
                </div>
              </div>    
            </form:form>
          </div>                     
        </div>  
      </div>

      <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info">
          <div class="panel-heading">
            <div class="panel-title">Welcome to XYH WeChat Platform</div>
            <div style="float:right; position: relative; top:-26px">
              <img src="${pageContext.request.contextPath}/images/wechat.png" style="width:30px;height:30px;">
            </div>
          </div>  
          <div class="panel-body" >
            <form:form id="frmResetPassword" action="login.do" method="POST" commandName="user" class="form-horizontal" role="form">
              <div id="resetpassalert" style="display:none" class="alert alert-danger">
                <p>Error:</p>
                <span></span>
              </div>

              <div class="form-group">
                <label for="email" class="col-md-2 control-label">Email</label>
                <div class="col-md-9">
                  <form:input id="txtUsername" path="username" maxlength="10" placeholder="Username" class="form-control"/>
                </div>
              </div>

              <div class="form-group">
                <!-- Button -->                                        
                <div class="col-md-offset-2 col-md-9">
                  <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i><spring:message code="button.passwordtomailbox"/></button>
                </div>
              </div>
              
              <div class="form-group">
                <div class="col-md-12 control">
                  <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                    Back to login page?
                    <a href="#" onClick="$('#signupbox').hide(); $('#loginbox').show()">Click Here</a>
                  </div>
                </div>
              </div>
            </form:form>
          </div>
        </div>
      </div> 
    </div>
  </body>
</html>