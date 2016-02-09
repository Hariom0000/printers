$(document)
		.ready(
				function() {
					$("#tab1").attr("class", "tab-pane active");
					$("#id").val("");
					$("#type").val("");
					$.ajax({
								url : 'getcasts',
								type : 'get',
								contentType : 'application/json',
								dataType : 'json',
								success : function(data) {
								$.each(data,function(key, value) {
									$("#listview tbody").append("<tr><td><input type='hidden' id="+ value.id+ " value='"+ value.cast+ "'/>"+ value.cast+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editcast("+ value.id+ ");'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deletecast("+ value.id+ ");></span></td></tr>");
								});
								},
							});
				});

function createcast(){
	var data = {};
	$.each($("#validate input[type=text],#validate input[type=hidden]"),function(key,value){
		data[value.name]=value.value;
	});
	$.ajax({
		url : 'createupdatecast',
		type : 'post',
		contentType : 'application/json',
		data : JSON.stringify(data),
		success : repetedCode,
	});
}
function editcast(id){
	console.log($("#" + id + "").val());
	$("#cast").val($("#" + id + "").val());
	
	console.log($("#cast").val());
	$("#id").val(id);
	$("li#litab1").toggleClass("active");
	$("li#litab2").toggleClass("active");
	$("div#tab1").toggleClass("active");
	$("div#tab2").toggleClass("active");
}

function deletecast(id){
	var data = {};
	data['id']=id;
	data['cast']='';
	console.log(data);
	$.ajax({
		url : 'deletcast',
		type : 'post',
		contentType : 'application/json',
		data : JSON.stringify(data),
		success : function(data){
			$("#listview tbody").empty();
			$.each(data,function(key, value) {
				$("#listview tbody").append("<tr><td><input type='hidden' id="+ value.id+ " value='"+ value.casst+ "'/>"+ value.cast+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editcasst("+ value.id+ ");'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deletecast("+ value.id+ ");></span></td></tr>");
			});
		},
	});
	
}

function repetedCode(data){
	$("#listview tbody").empty();
	$.each(data,function(key, value) {
		$("#listview tbody").append("<tr><td><input type='hidden' id="+ value.id+ " value='"+ value.cast+ "'/>"+ value.cast+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editcast("+ value.id+ ");'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deletecast("+ value.id+ ");></span></td></tr>");
	});
	$("li#litab1").toggleClass("active");
	$("li#litab2").toggleClass("active");
	$("div#tab1").toggleClass("active");
	$("div#tab2").toggleClass("active");
	$('#validate')[0].reset();
}