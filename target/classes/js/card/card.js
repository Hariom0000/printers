function createCard() {
	$
			.ajax({
				url : 'card',
				type : 'post',
				contentType : 'application/json',
				data : JSON.stringify(serializeObject()),
				success : function(data) {
					$("#listview tbody").empty();
					$
							.each(
									data,
									function(key, value) {
										$("#listview tbody")
												.append(
														"<tr><td><input type='hidden' id="
																+ value.id
																+ " value='"
																+ value.type
																+ "'/>"
																+ value.type
																+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editcard("
																+ value.id
																+ ");'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deletecard();></span></td></tr>");
									});
					$("li#litab1").toggleClass("active");
					$("li#litab2").toggleClass("active");
					$("div#tab1").toggleClass("active");
					$("div#tab2").toggleClass("active");
					$('#validate')[0].reset();
				},
			});
}
function editcard(id) {
	console.log(document.getElementById("" + id + "").value);
	$("#type").val($("#" + id + "").val());
	$("#id").val(id);
	$("li#litab1").toggleClass("active");
	$("li#litab2").toggleClass("active");
	$("div#tab1").toggleClass("active");
	$("div#tab2").toggleClass("active");

}


$(document)
		.ready(
				function() {
					$("#tab1").attr("class", "tab-pane active");
					$("#id").val("");
					$("#type").val("");
					$
							.ajax({
								url : 'getcards',
								type : 'get',
								contentType : 'application/json',
								dataType : 'json',
								success : function(data) {
									$
											.each(
													data,
													function(key, value) {
														$("#listview tbody")
																.append(
																		"<tr><td><input type='hidden' id="
																				+ value.id
																				+ " value='"
																				+ value.type
																				+ "'/>"
																				+ value.type
																				+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editcard("
																				+ value.id
																				+ ");'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deletecard();></span></td></tr>");
													});
								},
							});
				});

// Wedding card
