var obj = {};
var appendSelectData = {};

function weddingcard() {
	var formData = new FormData();
	$
			.each(
					$("#validate input[type=text],#validate input[type=number],#validate input[type=hidden],input[type=file], #validate select"),
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
							appendSelectData['activeyear']=data.activeyear;
							appendSelectData['cardtype']=data.cardtype;
							appendSelectData['weddingcardfrontimage']=data.weddingcardfrontimage;
							appendSelectData['usercast']=data.usercast;
						$.each(data.weddingcard,function(key, value) {
							obj[''+key+'']=value;
							$("#listview tbody").append("<tr><td>"+ value.cardNumber+ "</td> <td>"+ value.activeYear+ "</td> <td>"+ value.cardType+ "</td> <td>"+ value.weddingCardFrontImage+ "</td> <td>"+ value.userCast+ "</td> <td>"+ value.minOrder+ "</td> <td>"+ value.priceLTHundred+ "</td> <td>"+ value.priceGTHundred+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editWeddingCard("+ key+ ");'></span></td><td><span class='glyphicon glyphicon-eye-open' onclick='showPleaseWait();'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deletecast("+ value.id+ ");></span></td></tr>");
						});
						},
					});
			console.log(obj);
});

function resetWeddingCardFrom(){
	/*$.ajax({
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
	});*/
	appenSelectDataFunction();
	$("#validate")[0].reset();
	$(".fileinput-remove").click();
}

function appenSelectDataFunction(){
	$("#activeYearId").append('<option value="">example active</option>');
	$.each(appendSelectData['activeyear'],function(key,value){
		$("#activeYearId").append('<option value="'+value.id+'">'+value.year+'</option>');
	});
	$("#activeYearId option[value='']").attr("selected","selected");
	
	$("#cardTypeId").append('<option value="">example cardtype</option>');
	$.each(appendSelectData['cardtype'],function(key,value){
		$("#cardTypeId").append('<option value="'+value.id+'">'+value.type+'</option>');
	});
	$("#cardTypeId option[value='']").attr("selected","selected");
	
	$("#weddingCardFrontImageId").append('<option value="">example frontImageName</option>');
	$.each(appendSelectData['weddingcardfrontimage'],function(key,value){
		$("#weddingCardFrontImageId").append('<option value="'+value.id+'">'+value.frontImageName+'</option>');
	});
	$("#weddingCardFrontImageId option[value='']").attr("selected","selected");
	
	$("#userCastId").append('<option value="">example usercast</option>');
	$.each(appendSelectData['usercast'],function(key,value){
		$("#userCastId").append('<option value="'+value.id+'">'+value.cast+'</option>');
	});
	$("#userCastId option[value='']").attr("selected","selected");
}


function editWeddingCard(key) {
	appenSelectDataFunction();
	console.log("obj : " + obj + " obj.key: " + obj[key] + " key :" + key);
	var singleObj = obj[key];
	$.each(singleObj, function(k, v) {
		if (JSON.stringify(v).indexOf("img") > -1) {
			console.log("if: " + v);
			$("#" + k + "Div img").attr("src",
					"" + domainName + "/" + "HimanshiPrinters/" + v + "");
		} else if ($("#" + k + "").is("select")) {
			$("#" + k + " option[value=" + v+"]").attr("selected","selected");
		} else {
			$("#" + k + "").val(v);
		}

	});
	$("li#litab1").toggleClass("active");
	$("li#litab2").toggleClass("active");
	$("div#tab1").toggleClass("active");
	$("div#tab2").toggleClass("active");

	console.log("document.URL : " + document.URL);
	console.log("document.location.href : " + document.location.href);
	console.log("document.location.origin : " + document.location.origin);
	console.log("document.location.hostname : " + document.location.hostname);
	console.log("document.location.host : " + document.location.host);
	console.log("document.location.pathname : " + document.location.pathname);
}


function repetedCode(data){
	$("#listview tbody").empty();
	$.each(data,function(key, value) {
		obj[''+key+'']=value;
		$("#listview tbody").append("<tr><td>"+ value.cardNumber+ "</td> <td>"+ value.activeYear+ "</td> <td>"+ value.cardType+ "</td> <td>"+ value.weddingCardFrontImage+ "</td> <td>"+ value.userCast+ "</td> <td>"+ value.minOrder+ "</td> <td>"+ value.priceLTHundred+ "</td> <td>"+ value.priceGTHundred+ "</td><td><span class='glyphicon glyphicon-pencil' onclick='editWeddingCard("+ key+ ");'></span></td><td><span class='glyphicon glyphicon-eye-open' onclick='showPleaseWait();'></span></td><td><span class='glyphicon glyphicon-trash' onclick=javascript:deletecast("+ value.id+ ");></span></td></tr>");
	});
	$("li#litab1").toggleClass("active");
	$("li#litab2").toggleClass("active");
	$("div#tab1").toggleClass("active");
	$("div#tab2").toggleClass("active");
	//$('#validate')[0].reset();
}
function showPleaseWait(){
	  $('#myModal').modal('show');
}
function hidePleaseWait(){
	$('#pleaseWaitDialog').modal('hide');
}