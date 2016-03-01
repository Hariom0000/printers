<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<spring:url value="/" var="base_url"></spring:url>
<spring:url value="/js" var="js_url"></spring:url>
<script src="${js_url}/card/owncard.js"></script>
<c:set var="now" value="<%=new java.util.Date()%>" />
<fmt:formatDate pattern="yyyy-MM-dd" var="currentDate" value="${now}" />
<div class="row">
	<div class="col-md-6" style="border: 1px solid #ddd;">
		<img alt="frontimg"
			src="${base_url}${sampleWeddingCardDefault.mainImg}" width="100%;">
	</div>
	<div class="col-md-6"
		style="background-image: url('${base_url}${weddingCardBean.frontImg}');border: 1px solid #ddd;">
		<form:form commandName="TestBean" action="pdf" method="POST" target="_blank">
			<div class="col-md-6">
				<fieldset class="form-group">
					<div class="col-md-4" style="padding-top: 5px;">
						<label for="formGroupExampleInput" style="color: #8A0806">Wed.
							Date</label>
					</div>
					<div class="col-md-8">
						<input type="date" class="form-control validate[required]"
							value="${currentDate}" name="weddingDate" id="weddingDate"
							style="color: #8A0806" />
					</div>
				</fieldset>
				<fieldset class="form-group">
					<div class="col-md-4" style="padding-top: 5px;">
						<label for="formGroupExampleInput" style="color: #8A0806">Boy
							Name</label>
					</div>
					<div class="col-md-8">
						<input type="text" class="form-control validate[required]"
							name="boyName" id="boyName" placeholder="enter first name"
							style="color: #8A0806" />
					</div>
				</fieldset>

				<fieldset class="form-group">
					<div class="col-md-4" style="padding-top: 5px;">
						<label for="formGroupExampleInput" style="color: #8A0806">Address</label>
					</div>
					<div class="col-md-8">
						<textarea name="frontAddress" style="color: #8A0806"
							id="frontAddress" placeholder="enter address"
							class="form-control validate[required]"></textarea>
					</div>
				</fieldset>
			</div>


			<div class="col-md-6">
				<fieldset class="form-group">
					<div class="col-md-4" style="padding-top: 5px;">
						<label for="formGroupExampleInput" style="color: #8A0806">FromName</label>
					</div>
					<div class="col-md-8">
						<input type="text" class="form-control validate[required]"
							name="fromName" id="fromName" placeholder="enter fromName"
							style="color: #8A0806" />
					</div>
				</fieldset>
				<fieldset class="form-group">
					<div class="col-md-4" style="padding-top: 5px;">
						<label for="formGroupExampleInput" style="color: #8A0806">Girl
							Name</label>
					</div>
					<div class="col-md-8">
						<input type="text" class="form-control validate[required]"
							name="girlName" id="girlName" placeholder="enter first name"
							style="color: #8A0806" />
					</div>
				</fieldset>

				<fieldset class="form-group">
					<div class="col-md-4" style="padding-top: 5px;">
						<label for="formGroupExampleInput" style="color: #8A0806">Mobile
							No.</label>
					</div>
					<div class="col-md-8">
						<textarea name="frontMobileNo" style="color: #8A0806"
							id="frontMobileNo" placeholder="enter mobile number"
							class="form-control validate[required]"></textarea>
					</div>
				</fieldset>
				
				<fieldset class="form-group">
					<div class="col-md-4" style="padding-top: 5px;">
						<label for="formGroupExampleInput" style="color: #8A0806"></label>
					</div>
					<div class="col-md-8">
						<input type="submit" value="ubmit">
					</div>
				</fieldset>
			</div>

		</form:form>
	</div>
</div>
<div class="clear"></div>
<div class="row">
	<div class="col-md-6">
		<img alt="frontimg"
			src="${base_url}${sampleWeddingCardDefault.frontImg}" width="100%;">
	</div>
	<div class="col-md-6"
		style="background-image: url('${base_url}${weddingCardBean.middleImg}');"></div>
</div>