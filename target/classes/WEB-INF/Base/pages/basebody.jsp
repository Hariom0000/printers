
<div class="tabbable">
	<!-- Only required for left/right tabs -->
	<ul class="nav nav-tabs">
		<li class="active"><a href="#tab1" data-toggle="tab">Section
				1</a></li>
		<li><a href="#tab2" data-toggle="tab">Section 2</a></li>
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

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>#</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Username</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Mark</td>
						<td>Otto</td>
						<td>@mdo</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Jacob</td>
						<td>Thornton</td>
						<td>@fat</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>Larry</td>
						<td>the Bird</td>
						<td>@twitter</td>
					</tr>
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
				<form id="validate" method="POST"
					action="javascript:alert('Form #validate submited');">
					<div class="col-md-12">
						<div class="col-md-6">
							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput">Card Number</label>
								</div>
								<div class="col-md-8">
									<input type="text" class="form-control validate[required]"
										id="cardnumber" placeholder="Example input">
								</div>
							</fieldset>
							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput">Active year</label>
								</div>
								<div class="col-md-8">
									<input type="text"
										class="form-control validate[required,maxSize[8]]"
										id="activeyear" placeholder="Example input">
								</div>
							</fieldset>
							<fieldset class="form-group">
								<div class="col-md-4" style="padding-top: 5px;">
									<label for="formGroupExampleInput">Card Type</label>
								</div>
								<div class="col-md-8">
									<select id="cardtype" class="form-control validate[required]">
										<option value=""></option>
										<option value="cheese">Cheese</option>
										<option value="tomatoes">Tomatoes</option>
										<option value="mozarella">Mozzarella</option>
										<option value="mushrooms">Mushrooms</option>
										<option value="pepperoni">Pepperoni</option>
										<option value="onions">Onions</option>
									</select>
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
						<div class="col-md-6">
							<fieldset class="form-group">
								<div class="col-md-6" style="text-align: center;">
									<div class="kv-avatar center-block" style="width: 98%;">
										<input id="avatar" name="avatar" type="file"
											class="file-loading">
									</div>
									<a href="#" class="btn btn-primary">Main image <span
										class="badge">1</span></a>
								</div>
								<div class="col-md-6">
									<div class="kv-avatar center-block" style="width: 98%;">
										<input id="avatar1" name="avatar1" type="file"
											class="file-loading">
									</div>
									<a href="#" class="btn btn-primary">Front image <span
										class="badge">2</span></a>
								</div>
							</fieldset>

						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
