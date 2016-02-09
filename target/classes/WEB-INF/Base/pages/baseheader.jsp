<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="base_url"></spring:url>
<spring:url value="/img" var="img_url"></spring:url>
<div class="row" style="background-image: url('${img_url}/login.jpg');height: 100px;vertical-align: middle;">
	<div class="col-md-9"></div>
	<div class="col-md-3">
		<img width="90px" height="50px" style="z-index: 99;" src="${img_url}/default_avatar_male.jpg">
		<p>Welcome : Hariom singh</p>
	</div>

</div>
<div class="clear"></div>
<div class="row">
	<ul class="nav nav-pills" style="border-bottom: 4px solid #d6d6d6;">
		<li role="presentation" class="${activeclass=='home'?'active':''}"><a href="${base_url}admin/home/">Home</a></li>
		<li role="presentation" class="${activeclass=='management'?'active':''}"><a href="${base_url}admin/management/">Management</a></li>
		<li role="presentation"><a href="#">Messages</a></li>
	</ul>
</div>