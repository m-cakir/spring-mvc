<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras"%>

<spring:eval var="appName" expression="@appProps['application.name']" />
<spring:eval var="appVersion" expression="@appProps['application.version']" />

<c:set var="dist" value="/dist-${appVersion}" />

<c:set var="assets" value="${dist}/assets" />
<c:set var="plugins" value="${dist}/plugins" />
<c:set var="css" value="${assets}/css" />
<c:set var="js" value="${assets}/js" />
<c:set var="img" value="${assets}/img" />

<c:set var="bootstrap" value="${plugins}/bootstrap" />