<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/js" var="js_url"></spring:url>
<script src="${js_url}/card/card.js"></script>
<div class="tabbable">
	<!-- Only required for left/right tabs -->
	<ul class="nav nav-tabs">
		<li class="active" id="litab1"><a href="#tab1" data-toggle="tab">Section
				1</a></li>
		<li id="litab2"><a href="#tab2" data-toggle="tab" onclick="resetform();">Section 2</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="tab1">
			<!-- <div class="col-md-12"> -->
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>

			<table class="table table-bordered" id="listview">
				<thead>
					<tr>
						<th>CardType</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<!-- <nav> -->
			<ul class="nav pagination pagination-sm">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
			<!-- </nav> -->
		</div>
		<div class="tab-pane" id="tab2">
			<div class="row">
				<form id="validate" method="POST" commandName="CardType"
					action="javascript:createCard();">
					<div class="col-md-12">
						<div class="col-md-6">
							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput">Card Type</label> <input
										type="hidden" id="id" name="id">
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control validate[required]"
										name="type" id="type" placeholder="enter card type" />
								</div>
							</fieldset>
							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput"></label>
								</div>
								<div class="col-md-8">
									<input type="submit" class="btn pull-left" value="Submit">
								</div>
							</fieldset>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>