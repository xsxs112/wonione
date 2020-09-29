/**
 * question 스크립트
 * 수정일 2020-09-29
 */
(function ($) {
	
	//삭제처리
	$('.deleteQuestionTitle').click(function(){
		var questionName = $(this).parents().children().children('#questionCodeName').val();
		if(confirm('삭제하시겠습니까?')){
			var request = $.ajax({
				url: "/deleteQuestionTitle",
				method: "POST",
				data: { questionName : questionName },
				dataType: "json"
			});
			request.done(function(data) {
				alert('삭제되었습니다.');
				
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
		}else{
			alert('취소하셨습니다.');
		}
	});
	
	
	//문제타이틀추가
	$('#nextQuestion').click(function(){
		var qtCodeName = $('input[name=qtCodeName]').val();
		var qtTitle = $('input[name=qtTitle]').val();
		var qtTeacher = $('input[name=qtTeacher]').val();
		var request = $.ajax({
			  url: "/insertQuestionTitle",
			  method: "POST",
			  data: { qtCodeName : qtCodeName , qtTitle : qtTitle , qtTeacher : qtTeacher },
			  dataType: "json"
		});
		request.done(function(data) {
			alert('등록되었습니다.');
			location.href='secondsPage';
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});
	});
	
	
	$('#enrollmentQuestion').click(function(){
		localhost.href('/insertQuestion');
		
	});
	
	//문제등록페이지 
	$('#insertQuestion').click(function(){
		if(questionSid != null && questionSid != undefined && questionSid != ''){
			if(confirm('등록하시겠습니까?')){
				window.open('/insertQuestionTitle','문제등록', 'width=550, height=201 left=600 top=100','status=no');
			}else{
				alert('취소하셨습니다.');
			}
		}else{
			alert('로그인을 해주세요.');
			return false;
		}
		
	});
	
	
	
	//점수확인페이지
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
	
	//리스트유효성검사및 페이지이동
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
