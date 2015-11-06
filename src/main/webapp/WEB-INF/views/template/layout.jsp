<!DOCTYPE HTML>
<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    	
	<title><tiles:insertAttribute name="title" /></title>
    	
	<tiles:insertAttribute name="head" />

	<link rel="icon" href="${assets}/favicon.ico">

</head>
<body>
	
	<!-- Header -->
	<header class="header navbar navbar-fixed-top" role="banner">
	
		<tiles:insertAttribute name="header" />
	
	</header>
	
	<!-- Container -->
	<div id="container" style="padding-top:50px">
	
		<!-- Sidebar -->
		<div id="sidebar" class="sidebar-fixed">
			
			<tiles:insertAttribute name="sidebar" />
			
		</div>
		
		<!-- Content -->
		<div id="content">
			<div class="container">
			
				<tiles:insertAttribute name="body" />
			
			</div>
		</div>
		
	</div>

</body>
</html>