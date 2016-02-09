<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/" var="baseurl" />
<spring:url value="/css" var="css_url"></spring:url>
<spring:url value="/js" var="js_url"></spring:url>
<%-- <link href="${css_url}/68edcfebd6057f54c0890bde01c3c5fe.css"
	rel="stylesheet" type="text/css" media="screen" /> --%>
<link href="${css_url}/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="${css_url}/style.css" rel="stylesheet" type="text/css" />
<link href="${css_url}/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="${css_url}/validation/validationEngine.jquery.css" rel="stylesheet" type="text/css" />
<link href="${css_url}/fileinput.min.css" rel="stylesheet"
	type="text/css" />

<link href="${css_url}/baselayout/baselayout.css" rel="stylesheet"
	type="text/css" />
<link href="${css_url}/baselayout/baseheader.css" rel="stylesheet"
	type="text/css" />
<link href="${css_url}/baselayout/basemenu.css" rel="stylesheet"
	type="text/css" />
<script src="js/jquery.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type='text/javascript'
	src='js/validationEngine/languages/jquery.validationEngine-en.js'></script>
<script type='text/javascript'
	src='js/validationEngine/jquery.validationEngine.js'></script>
	<script type='text/javascript'
	src='js/fileinput.min.js'></script>
<script type='text/javascript'
	src='js/validationEngine/customvalidation.js'></script>

</head>
<body>
<tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
<tiles:insertAttribute name="menu"></tiles:insertAttribute>
<tiles:insertAttribute name="body"></tiles:insertAttribute>
</body>
</html>