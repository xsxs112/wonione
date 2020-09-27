/**
 * 20-09-27 생성
 * 
 */
 
 	$(function(){	
	// 강사 아이디값 받아 넘기기
 		$('.callStaffInfo').click(function(){
 		var tr = $(this).parent().parent();
 		var td = tr.children();
 		var mrId = td.eq(0).text(); 	
 		
		console.log(mrId + ' < -- mrId');
		var request = $.ajax({
			  url: "/callStaffInfo",
			  method: "POST",
			  data: { mrId : mrId },
			  dataType: "json"
			});
			request.done(function(data) {
				console.log(data);
				$('#mrId').val(data.mrId);
				$('#mrName').val(data.mrName);
				$('#pmRTitle').val(data.pmRTitle);
				$('#mrAccountNum').val(data.mrAccountNum);
				
			});
			request.fail(function( jqXHR, textStatus ) {
				if (jqXHR.status === 0) {
		            alert('Not connect.\n Verify Network.');
		        } 
		        else if (jqXHR.status == 400) {
		            alert('Server understood the request, but request content was invalid. [400]');
		        } 
		        else if (jqXHR.status == 401) {
		            alert('Unauthorized access. [401]');
		        } 
		        else if (jqXHR.status == 403) {
		            alert('Forbidden resource can not be accessed. [403]');
		        } 
		        else if (jqXHR.status == 404) {
		            alert('Requested page not found. [404]');
		        } 
		        else if (jqXHR.status == 500) {
		            alert('Internal server error. [500]');
		        } 
		        else if (jqXHR.status == 503) {
		            alert('Service unavailable. [503]');
		        } 
		        else if (exception == 'parsererror') {
		            alert('Requested JSON parse failed. [Failed]');
		        } 
		        else if (exception == 'timeout') {
		            alert('Time out error. [Timeout]');
		        } 
		        else if (exception == 'abort') {
		            alert('Ajax request aborted. [Aborted]');
		        } 
		        else {
		            alert('Uncaught Error.n' + jqXHR.responseText);
		        }
			});
		});
	});
