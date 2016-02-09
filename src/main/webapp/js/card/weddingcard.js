function weddingcard() {

	var formData = new FormData();
	$
			.each(
					$("#validate input[type=text],#validate input[type=number],input[type=file], #validate select"),
					function(key, value) {
						if(value.type=='file'){
							formData.append(value.name, value.files[0]);
						}else{
							formData.append(value.name, value.value);
						}
					});
	$.ajax({
		url : 'cuweddingcard',
		type : 'post',
		processData : false,
		contentType : false,
		cache : false,
		data : formData,
		success : repetedCode
	});
}

$(document).ready(
		function() {
			$("#tab1").attr("class", "tab-pane active");
			$("#id").val("");
			$("#type").val("");
			$.ajax({
						url : 'getweddingcards',
						type : 'get',
						contentType : 'application/json',
						dataType : 'json',
						success : function(data) {
						$.each(data,function(key, value) {
							$.each(value, function(k, v) {
							    console.log(k + ' is ' + v);
							});
							$("#listview tbody").append("<tr><td>"+ value.cardNumber+ "</td> <td>"+ value.activeYear+ "</td> <td>"+ value.cardType+ "</td> <td>"+ value.weddingCardFrontImage+ "</td> <td>"+ value.userCast+ "</td> <td>"+ value.minOrder+ "</td> <td>"+ value.priceLTHundred+ "</td> <td>"+ value.priceGTHundred+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editWeddingCard("+ value+ ");'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deletecast("+ value.id+ ");></span></td></tr>");
						});
						},
					});
});

function resetWeddingCardFrom(){
	$.ajax({
		url : 'getweddingcardbasedata',
		type : 'post',
		contentType : 'application/json',
		success : function(data) {
			
			$("#activeYearId").append('<option value="">example active</option>');
			$.each(data.activeyear,function(key,value){
				$("#activeYearId").append('<option value="'+value.id+'">'+value.year+'</option>');
			});
			
			$("#cardTypeId").append('<option value="">example cardtype</option>');
			$.each(data.cardtype,function(key,value){
				$("#cardTypeId").append('<option value="'+value.id+'">'+value.type+'</option>');
			});
			
			$("#weddingCardFrontImageId").append('<option value="">example frontImageName</option>');
			$.each(data.weddingcardfrontimage,function(key,value){
				$("#weddingCardFrontImageId").append('<option value="'+value.id+'">'+value.frontImageName+'</option>');
			});
			
			$("#userCastId").append('<option value="">example usercast</option>');
			$.each(data.usercast,function(key,value){
				$("#userCastId").append('<option value="'+value.id+'">'+value.cast+'</option>');
			});
		}
	});
	$("#validate")[0].reset();
}


function editWeddingCard(object){
	$.each(object, function(k, v) {
	    console.log(k + ' is ' + v);
	});
}


function repetedCode(data){
	$("#listview tbody").empty();
	$.each(data,function(key, value) {
		$("#listview tbody").append("<tr><td>"+ value.cardNumber+ "</td> <td>"+ value.activeYear+ "</td> <td>"+ value.cardType+ "</td> <td>"+ value.weddingCardFrontImage+ "</td> <td>"+ value.userCast+ "</td> <td>"+ value.minOrder+ "</td> <td>"+ value.priceLTHundred+ "</td> <td>"+ value.priceGTHundred+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editcast("+ value.id+ ");'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deletecast("+ value.id+ ");></span></td></tr>");
	});
	$("li#litab1").toggleClass("active");
	$("li#litab2").toggleClass("active");
	$("div#tab1").toggleClass("active");
	$("div#tab2").toggleClass("active");
	//$('#validate')[0].reset();
}