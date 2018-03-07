<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title><spring:message code="application.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/_all-skins.min.css">
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/adminlte.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/jquery-ui.min.css"/>
    <script src="${pageContext.request.contextPath}/scripts/jquery-ui.min.js"></script>
    <script type="text/javascript">
    </script>
  </head>
  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
      <header class="main-header">
        <!-- Logo -->
        <a href="#" class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b><spring:message code="application.company"/></b></span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b><spring:message code="application.company"/></b><spring:message code="application.wechat"/></span>
        </a>

        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
          <!-- Sidebar toggle button-->
          <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>

          <!-- Navbar Right Menu -->
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- Messages: style can be found in dropdown.less-->
              <li class="dropdown messages-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-envelope-o"></i>
                  <span class="label label-success">4</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">You have 4 messages</li>
                  <li>
                    <!-- inner menu: contains the actual data -->
                    <ul class="menu">
                      <li><!-- start message -->
                        <a href="#">
                          <div class="pull-left">
                            <img src="${pageContext.request.contextPath}/images/user2-160x160.jpg" class="img-circle" alt="User Image">
                          </div>
                          <h4>
                            Support Team
                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                          </h4>
                          <p>Why not buy a new awesome theme?</p>
                        </a>
                      </li>
                      <!-- end message -->
                    </ul>
                  </li>
                  <li class="footer"><a href="#">See All Messages</a></li>
                </ul>
              </li>
          
              <!-- User Account: style can be found in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="${pageContext.request.contextPath}/images/user2-160x160.jpg" class="user-image" alt="User Image">
                  <span class="hidden-xs"><c:out value="${sessionScope.user.username}"/></span>
                </a>
                <ul class="dropdown-menu">
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-right">
                      <a href="${pageContext.request.contextPath}/public/logout.jsp" class="btn btn-default btn-flat"><spring:message code="application.logout"/></a>
                    </div>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
        </nav>
      </header>

      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MAIN NAVIGATION</li>
            <li class="active treeview menu-open">
              <a href="#">
                <i class="fa fa-dashboard"></i> <span><spring:message code="wechat.platform.management"/></span>
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu">
                <li class="active"><a href="${pageContext.request.contextPath}/platform/platformUserSetting.do" target="ifrm_content"><i class="fa fa-circle-o"></i><spring:message code="wechat.platform.usersetting"/></a></li>
                <li><a href="${pageContext.request.contextPath}/platform/platformRoleSetting.do" target="ifrm_content"><i class="fa fa-circle-o"></i><spring:message code="wechat.platform.permissionsetting"/></a></li>
                <li><a href="${pageContext.request.contextPath}/platform/platformSystemSetting.do" target="ifrm_content"><i class="fa fa-circle-o"></i><spring:message code="wechat.platform.systemsetting"/></a></li>
              </ul>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/enterprise/enterprisemain.do" target="ifrm_content">
                <i class="fa fa-th"></i>
                <span><spring:message code="wechat.enterprise.account"/></span>
                <span class="pull-right-container">
                  <span class="label label-primary pull-right">4</span>
                </span>
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/service/servicemain.do" target="ifrm_content">
                <i class="fa fa-th"></i> 
                <span><spring:message code="wechat.service.account"/></span>
                <span class="pull-right-container">
                  <small class="label pull-right bg-green">5</small>
                </span>
              </a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/subscription/subscriptionmain.do" target="ifrm_content">
                <i class="fa fa-th"></i> 
                <span><spring:message code="wechat.subscription.account"/></span>
                <span class="pull-right-container">
                  <small class="label pull-right bg-green">6</small>
                </span>
              </a>
            </li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>
      
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper" style="height:100px;">
        <iframe name="ifrm_content" id="ifrm_content" style="border:0;width:100%;height:100%;"></iframe>
      </div>
      <!-- /.content-wrapper -->
      
      <footer class="main-footer">
        <div class="pull-right hidden-xs">
          <b>Version</b> 1.0.0
        </div>
        <strong>Copyright &copy; 2018-2019 <a href="www.xyh.com">XYH</a>.</strong> All rights reserved.
      </footer>
    </div>
  </body>
</html> 