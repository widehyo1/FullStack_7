<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><decorator:title default="HeHe System" /></title>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome Icons -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- DataTables -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
<style>
*{
	font-size:13px;
}

</style>
<decorator:head />
</head>
<body class="hold-transition">
	<div class="wrapper" style="max-width: 1280px; margin: 0 auto;">

		<nav class="main-header navbar navbar-expand navbar-white navbar-light" style="margin-left:0px; width: 100%; padding-right: 0;">

			<!-- Left navbar links -->
			<ul class="navbar-nav">
				<li class="nav-item">

					<div style="width: 200px;height: 80px; background-image: url(<%=request.getContextPath()%>/resources/image/logoblack.png);   background-size: cover; cursor:pointer;" onclick="logo_go();"></div>
				</li>
				
			</ul>

			<!-- Navbar -->

			<!-- Right navbar links -->
			<ul class="navbar-nav ml-auto">
				
				<div style="width: 200px; text-align: center; margin-right: 230px; align-self: flex-end; align-items: center;">
					<h2>${loginInst.instNm }</h2>
				</div>
				
				<li class="nav-item d-none d-sm-inline-block" style="margin-right: 15px; margin-top: 18px;">
					<i class="fas fa-qrcode fa-3x" style="color:#1a4f72;"></i>
				</li>
				
				<!-- 로그인 확인  -->
				<li class="nav-item" style="margin-right: 25px;">
					<div class="user-panel mt-3 d-flex">
						<div class="media">
							<div class="media-body">
								<p class="dropdown-item-title">남은시간 10:00</p>
								<span class="float-right text-sm text-danger"></span> <input class="btn btn-block btn-primary btn-xs" style="background-color: #1a4f72; border-color: #1a4f72; width: 110px; width: 110px;" type="button" value="연장하기" />
							</div>
						</div>
					</div>
				</li>
				<li class="nav-item">
					<div class="user-panel mt-3 d-flex">
						<div class="media">
							<div class="media-body">
								<p class="dropdown-item-title">
									<b>${loginUser.mberNm }</b>님 안녕하세요.
								</p>
								<div class="input-group">
									<div class="col-md-6 p-0">
									<span class="float-right text-sm text-danger"></span> <input class="btn btn-block btn-primary btn-xs" style="width: 75px; background-color: #1a4f72; border-color: #1a4f72; margin-right: 5px;" type="button" value="내정보" /> 
									</div>
									<div class="col-md-6 p-0">
									<span class="float-right text-sm text-danger"></span> <input class="btn btn-block btn-primary btn-xs" style="width: 75px; background-color: #1a4f72; border-color: #1a4f72;" type="button" value="로그아웃" onclick="location.href='<%=request.getContextPath()%>/common/logout.do';" />
									</div>
								</div>
							</div>
						</div>
					</div>
					
				</li>
			</ul>
		</nav>
		<nav class="main-header navbar navbar-expand navbar-white navbar-light" style="width: 100%; margin-left:0px;">
			<!-- Left navbar links -->
			
			<ul class="navbar-nav">
				<c:forEach items="${menuList }" var="submenu">
					<li class="nav-item subMenu " id="${submenu.menuUrl }">
						<a style="color: black;" href="javascript:goPage('<%=request.getContextPath()%>${submenu.menuUrl }','${submenu.menuNo }');" class="nav-link">
							<span>${submenu.menuNm }</span>
						</a>
					</li>
				</c:forEach>
			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<!-- Control Sidebar -->
		<!-- /.control-sidebar -->
		
	<script>
	function logo_go(){
		var renewURL = location.href;
		var former = renewURL.substring(0, renewURL.indexOf('='));
		var later = renewURL.substring(renewURL.indexOf('=')).substring(0,4)+"0000";
		location.href = former + later;
	}

	</script>	