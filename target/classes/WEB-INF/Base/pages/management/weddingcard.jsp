<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/img" var="img_url"></spring:url>
<spring:url value="/js" var="js_url"></spring:url>
<script src="${js_url}/card/weddingcard.js"></script>
<style>
.kv-avatar .file-preview-frame, .kv-avatar .file-preview-frame:hover {
	margin: 0;
	padding: 0;
	border: none;
	box-shadow: none;
	text-align: center;
}

.kv-avatar .file-input {
	display: table-cell;
	max-width: 220px;
}

.modal-dialog {
	margin: 2% auto;
	width: 60%;
}

.modal {
	z-index: 99999;
}
</style>
<div class="tabbable">
	<!-- Only required for left/right tabs -->
	<ul class="nav nav-tabs">
		<li class="active"><a href="#tab1" data-toggle="tab">Section
				1</a></li>
		<li><a href="#tab2" data-toggle="tab"
			onclick="resetWeddingCardFrom();">Section 2</a></li>
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
						<th>Card Number</th>
						<th>Active Year</th>
						<th>Card Type</th>
						<th>ImageOnCard</th>
						<th>UserCast</th>
						<th>MinOrder</th>
						<th>priceLTHundred</th>
						<th>priceGTHundred</th>
						<th>Edit</th>
						<th>view</th>
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

				<div class="col-md-12">
					<form id="validate" method="POST"
						action="javascript:weddingcard();" enctype="multipart/form-data">
						<div class="col-md-6">
							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput"><input type="hidden"
										name="id" id="id">Card Number</label>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control validate[required]"
										id="cardNumber" name="cardNumber" placeholder="Example input">
								</div>
							</fieldset>
							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput">Active year</label>
								</div>
								<div class="col-md-8">
									<select id="activeYearId" name="activeYearId"
										class="form-control validate[required]">
									</select>
								</div>
							</fieldset>
							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput">Card Type</label>
								</div>
								<div class="col-md-8">
									<select id="cardTypeId" name="cardTypeId"
										class="form-control validate[required]">
									</select>
								</div>
							</fieldset>

							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput">IMG on Crad</label>
								</div>
								<div class="col-md-8">
									<select id="weddingCardFrontImageId"
										name="weddingCardFrontImageId"
										class="form-control validate[required]">
									</select>
								</div>
							</fieldset>

							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput">Cast</label>
								</div>
								<div class="col-md-8">
									<select id="userCastId" name="userCastId"
										class="form-control validate[required]">
									</select>
								</div>
							</fieldset>

							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput">Minimum Order</label>
								</div>
								<div class="col-md-8">
									<input type="number" id="minOrder" name="minOrder"
										class="form-control validate[required]">
								</div>
							</fieldset>
							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput">Card Price > 100</label>
								</div>
								<div class="col-md-8">
									<input type="number" id="priceLTHundred" name="priceLTHundred"
										class="form-control validate[required]">
								</div>
							</fieldset>
							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput">Card Price < 300 </label>
								</div>
								<div class="col-md-8">
									<input type="number" id="priceGTHundred" name="priceGTHundred"
										class="form-control validate[required]">
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
					</form>
					<div class="col-md-6">
						<fieldset class="form-group">
							<div class="col-md-6" style="text-align: center;">
								<div class="kv-avatar center-block" style="width: 98%;"
									id="mainImgDiv">
									<input id="mainImg" name="mainImg" type="file"
										class="avatar file-loading">
								</div>
								<a href="#" class="btn btn-primary">Main image <span
									class="badge">1</span></a>
							</div>
							<div class="col-md-6">
								<div class="kv-avatar center-block" style="width: 98%;"
									id="frontImgDiv">
									<input id="frontImg" name="frontImg" type="file"
										class="avatar file-loading">
								</div>
								<a href="#" class="btn btn-primary">Front image <span
									class="badge">2</span></a>
							</div>
						</fieldset>
						<fieldset class="form-group">
							<div class="col-md-6" style="text-align: center;">
								<div class="kv-avatar center-block" style="width: 98%;"
									id="middleImgDiv">
									<input id="middleImg" name="middleImg" type="file"
										class="avatar file-loading">
								</div>
								<a href="#" class="btn btn-primary">Middle image <span
									class="badge">1</span></a>
							</div>
							<div class="col-md-6">
								<div class="kv-avatar center-block" style="width: 98%;"
									id="lastImgDiv">
									<input id="lastImg" name="lastImg" type="file"
										class="avatar file-loading">
								</div>
								<a href="#" class="btn btn-primary">Last image <span
									class="badge">2</span></a>
							</div>
						</fieldset>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>





<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Modal Header</h4>
			</div>
			<div class="modal-body">
				<div class="row" style="border: none;">
					<div class="file-preview ">
						<div class="file-drop-disabled">
							<div class="file-preview-thumbnails">
								<div class="file-default-preview">
									<img alt="Your Avatar" id="showHighResolution" src=""
										style="width: 90%">
								</div>
							</div>
							<div class="clearfix"></div>
							<div class="file-preview-status text-center text-success"></div>
							<div class="kv-fileinput-error"></div>
						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-2"></div>
						<div class="col-md-8">
							<div class="col-md-3">
								<div id="mainImgDiv" class="kv-avatar center-block">
									<div class="file-input">
										<div class="file-preview ">
											<div class="file-drop-disabled">
												<div class="file-preview-thumbnails">
													<div class="file-default-preview">
														<img alt="Your Avatar" id="modelmainImg" src=""
															style="width: 80%">
													</div>
												</div>
												<div class="clearfix"></div>
												<div class="file-preview-status text-center text-success"></div>
												<div class="kv-fileinput-error"></div>
											</div>
										</div>
										<a class="btn btn-primary" id="amodelmainImg" href="#">Main
											image <span class="badge">1</span>
										</a>
									</div>
								</div>

							</div>
							<div class="col-md-3">
								<div id="mainImgDiv" class="kv-avatar center-block">
									<div class="file-input">
										<div class="file-preview ">
											<div class="file-drop-disabled">
												<div class="file-preview-thumbnails">
													<div class="file-default-preview">
														<img alt="Your Avatar" id="modelfrontImg" src=""
															style="width: 80%">
													</div>
												</div>
												<div class="clearfix"></div>
												<div class="file-preview-status text-center text-success"></div>
												<div class="kv-fileinput-error"></div>
											</div>
										</div>
										<a class="btn btn-primary" id="amodelfrontImg" href="#">Front
											image <span class="badge">1</span>
										</a>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div id="mainImgDiv" class="kv-avatar center-block">
									<div class="file-input">
										<div class="file-preview ">
											<div class="file-drop-disabled">
												<div class="file-preview-thumbnails">
													<div class="file-default-preview">
														<img alt="Your Avatar" id="modelmiddleImg" src=""
															style="width: 80%">
													</div>
												</div>
												<div class="clearfix"></div>
												<div class="file-preview-status text-center text-success"></div>
												<div class="kv-fileinput-error"></div>
											</div>
										</div>
										<a class="btn btn-primary" id="amodelmiddleImg" href="#">Middle
											image <span class="badge">1</span>
										</a>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<div id="mainImgDiv" class="kv-avatar center-block">
									<div class="file-input">
										<div class="file-preview ">
											<div class="file-drop-disabled">
												<div class="file-preview-thumbnails">
													<div class="file-default-preview">
														<img alt="Your Avatar" id="modellastImg" src=""
															style="width: 80%">
													</div>
												</div>
												<div class="clearfix"></div>
												<div class="file-preview-status text-center text-success"></div>
												<div class="kv-fileinput-error"></div>
											</div>
										</div>
										<a class="btn btn-primary" id="amodellastImg" href="#">Last
											image <span class="badge">1</span>
										</a>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-2"></div>
					</div>
				</div>

				<p>Some text in the modal.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>





