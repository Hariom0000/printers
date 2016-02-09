$(document)
		.ready(
				function() {
					$("#tab1").attr("class", "tab-pane active");
					$("#id").val("");
					$("#type").val("");
					$.ajax({
								url : 'getweddingcardfrontimg',
								type : 'get',
								contentType : 'application/json',
								dataType : 'json',
								success : function(data) {
								$.each(data,function(key, value) {
									$("#listview tbody").append("<tr><td><input type='hidden' id="+ value.id+ " value='"+ value.frontImageName+ "'/>"+ value.frontImageName+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editweddingcardfrontimg("+ value.id+ ");'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deleteweddingcardfrontimg("+ value.id+ ");></span></td></tr>");
								});
								},
							});
				});

function createweddingcardfrontimg(){
	var data = {};
	$.each($("#validate input[type=text],#validate input[type=hidden]"),function(key,value){
		data[value.name]=value.value;
	});
	$.ajax({
		url : 'createupdateweddingcardfrontimg',
		type : 'post',
		contentType : 'application/json',
		data : JSON.stringify(data),
		success : repetedCode,
	});
}
function editweddingcardfrontimg(id){
	$("#frontImageName").val($("#" + id + "").val());
	$("#id").val(id);
	$("li#litab1").toggleClass("active");
	$("li#litab2").toggleClass("active");
	$("div#tab1").toggleClass("active");
	$("div#tab2").toggleClass("active");
}

function deleteweddingcardfrontimg(id){
	var data = {};
	data['id']=id;
	data['frontImageName']='';
	console.log(data);
	$.ajax({
		url : 'deletweddingcardfrontimg',
		type : 'post',
		contentType : 'application/json',
		data : JSON.stringify(data),
		success : function(data){
			$("#listview tbody").empty();
			$.each(data,function(key, value) {
				$("#listview tbody").append("<tr><td><input type='hidden' id="+ value.id+ " value='"+ value.frontImageName+ "'/>"+ value.frontImageName+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editweddingcardfrontimg("+ value.id+ ");'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deleteweddingcardfrontimg("+ value.id+ ");></span></td></tr>");
			});
		},
	});
	
}

function repetedCode(data){
	$("#listview tbody").empty();
	$.each(data,function(key, value) {
		$("#listview tbody").append("<tr><td><input type='hidden' id="+ value.id+ " value='"+ value.frontImageName+ "'/>"+ value.frontImageName+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editweddingcardfrontimg("+ value.id+ ");'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deleteweddingcardfrontimg("+ value.id+ ");></span></td></tr>");
	});
	$("li#litab1").toggleClass("active");
	$("li#litab2").toggleClass("active");
	$("div#tab1").toggleClass("active");
	$("div#tab2").toggleClass("active");
	$('#validate')[0].reset();
}