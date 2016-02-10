$(document).ready(function() {
	
	var a = document.createElement('a');
	a.href = window.location.href;
	var domainName = a.hostname;
	
	
	if ($("#validate").length > 0)
		$("#validate, #validate_custom").validationEngine('attach', {
			promptPosition : "topLeft"
		});
	var btnCust = '<button type="button" class="btn btn-default" title="Add picture tags" '
		+ 'onclick="alert(\'Call your custom code here.\')">'
		+ '<i class="glyphicon glyphicon-tag"></i>' + '</button>';
$(".avatar")
		.fileinput(
				{
					overwriteInitial : true,
					maxFileSize : 1500,
					showClose : false,
					showCaption : false,
					browseLabel : '',
					removeLabel : '',
					browseIcon : '<i class="glyphicon glyphicon-folder-open"></i>',
					removeIcon : '<i class="glyphicon glyphicon-remove"></i>',
					removeTitle : 'Cancel or reset changes',
					elErrorContainer : '#kv-avatar-errors',
					msgErrorClass : 'alert alert-block alert-danger',
					defaultPreviewContent : '<img src="/HimanshiPrinters/img/default_avatar_male.jpg" alt="Your Avatar" style="width:160px">',
					layoutTemplates : {
						main2 : '{preview} ' + btnCust
								+ ' {remove} {browse}'
					},
					allowedFileExtensions : [ "jpg", "png", "gif" ]
				});
       var pathName=window.location.pathname.substring(window.location.pathname.lastIndexOf("/") + 1);
       $('#'+pathName).addClass("active1");
       console.log("pathname "+window.location.pathname);
       console.log("href "+window.location.href);

});	
function resetform(){
	$('#validate')[0].reset();
}
var domainName=document.location.origin;
