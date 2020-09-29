/**
 * question 스크립트
 * 수정일 2020-09-29
 */
(function ($) {
	
	$('#scoreCheck').click(function(){
		var scoreSid = $('#scoreCheckSid').val();
	
		var request = $.ajax({
			  url: "/ScoreCheck",
			  method: "POST",
			  data: { scoreSid : scoreSid },
			  dataType: "json"
			});
			request.done(function(data) {
				
				var html = '';
				html += '<tr>';
				html += '<th scope="row">응시자</th>';
				html += '<td>'+data.mr_name+'</td>';
				html += '</tr>';
				html += '<tr>';
				html += '<th scope="row">점수</th>';
				html += '<td>'+data.qe_score+'</td>';
				html += '</tr>';
				html += '<tr>';
				html += '<th scope="row">응시일자</th>';
				html += '<td>'+data.qc_date+'</td>';
				html += '</tr>';
				html += '<tr>';
				html += '<th scope="row">추천반</th>';
				html += '<td>'+data.scoreClass+'</td>';
				html += '</tr>';
			
				$("#scoreCheckTable").empty();
				$("#scoreCheckTable").append(html);
			});
			request.fail(function( jqXHR, textStatus ) {
				 alert( "Request failed: " + textStatus );
			});
	});
	
	
	$(document).on('click','.questionCodeName',function(){
		var questionSid = $('#questionSid').val();
		var questionName = $(this).parent().children('#questionCodeName').val();
		if(questionSid != null && questionSid != undefined && questionSid != ''){
			var request = $.ajax({
				url: "/QuestionSidCheck",
				method: "POST",
				data: { questionSid : questionSid , questionName : questionName},
				dataType: "json"
			});
			request.done(function(data) {
				if(data === 0){
					window.open('/Question?questionName='+questionName,'문제출제', 'width=600, height=285 left=600 top=100');
				}else{
					alert('해당 문제를 완료했던 아이디입니다.');
				}
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
		}else{
			alert('로그인을 해주세요.');
			return false;
		}
		
		
	});
	
	
	$('.Questionbtn').click(function(){
		var qeAnswer = $("input[type=radio][name=QuestionCheckbox]:checked").val();
		var qeCode = $('#QuestionCode').text();
		if(qeAnswer != null){
			var request = $.ajax({
				url: "/QuestionScoreCheckdate",
				method: "GET",
				data: { qeAnswer : qeAnswer , qeCode : qeCode},
				dataType: "json"
			});
			request.done(function(data) {
				
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
		}else{
			alert('답을 체크해주세요.');
			return false;
		}
	});
})(jQuery); 
