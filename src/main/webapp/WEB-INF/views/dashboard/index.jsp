<%@include file="/WEB-INF/views/include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<tiles:insertDefinition name="layout">

	<tiles:putAttribute name="title">Home</tiles:putAttribute>

	<tiles:putAttribute name="body" type="string">

		Welcome ${cUser.name}!

	</tiles:putAttribute>
</tiles:insertDefinition>