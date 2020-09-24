/**
 * question 스크립트
 * 수정일 2020-09-23
 */
(function ($) {
	
	
	$('.questionCodeName').click(function(){
		var questionName = $(this).parent().children('#questionCodeName').val(); 
		window.open('/Question?questionName='+questionName,'문제출제', 'width=500, height=350 left=600 top=100');
	});
	
	
	$('#Questionbtn').click(function(){
		 var QuestionScoreCheckbox = $("input[type=radio][name=QuestionCheckbox]:checked").val();

		console.log(QuestionScoreCheckbox);
		/*var request = $.ajax({
			  url: "/consultingInformation",
			  method: "POST",
			  data: { csCode : csCode },
			  dataType: "json"
			});
			request.done(function(data) {
				var textareaVal = $("#consultingData");
				$('#consultingCode').attr('value',data.cs_code);
				$('#consultingTitle').attr('value',data.cs_title);
				$('#consultingDate').attr('value',data.cs_date);
				$('#consultingTeacherName').attr('value',data.mr_name);
				$('#consultingTeacher').attr('value',data.mr_o_id);
				$('#consultingStudent').attr('value',data.cs_s_name);
				$('#consultingClass').attr('value',data.cs_lec_name);
				$('#consultingData').attr('value',data.cs_data);
				textareaVal.text(data.cs_data);
				
			
				
			});
			request.fail(function( jqXHR, textStatus ) {
				 alert( "Request failed: " + textStatus );
			});*/
	});
})(jQuery); 
