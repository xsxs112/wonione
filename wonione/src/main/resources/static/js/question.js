/**
 * question 스크립트
 * 수정일 2020-10-04
 */
(function ($) {
	//삭제처리
	$(document).on('click','.deleteQuestion',function(){
		var deleteQeCode = $('#qeCode').val();
		var deleteQeCodeName = $('input[name=qtCodeName]').val();
		if(confirm('삭제하시겠습니까?')){
			var request = $.ajax({
				url: "/deleteQuestion",
				method: "POST",
				data: { deleteQeCode : deleteQeCode },
				dataType: "json"
			});
			request.done(function(data) {
				alert('삭제되었습니다.');
				location.href='titleQuestionList?qtCodeName='+deleteQeCodeName;
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
			
		}else{
			alert('취소하셨습니다.');
		}
	});
	
	//수정처리
	$(document).on('click','#modifyQuestion',function(){
		if(confirm('수정하시겠습니까?')){
			$('#modifyViewForm').submit();
			alert('수정되었습니다.');
		}else{
			alert('취소하셨습니다.');
		}
	});
	//문제등록
	$('#insertQuestion').click(function(){
		var qtCodeName = $('#titleQuestionListView').text();
		if(confirm('등록하시겠습니까?')){
			window.open('/insertQuestion?qtCodeName='+qtCodeName,'문제등록', 'width=540, height=610 left=600 top=100','status=no');
		}else{
			alert('취소하셨습니다.');
		}
	});
	
	//타이틀리스트 상세보기
	$('.titleQuestionListView').click(function(){
		var qeCode = $(this).parents().children('input[name=qeCode]').val();
		var request = $.ajax({
			url: "/titleQuestionListView",
			method: "POST",
			data: { qeCode : qeCode },
			dataType: "json"
		});
		request.done(function(data) {
			var html = '';
			html += '<h4>문제상세보기</h4>';
			html += '<table class="modifyQuestionViewTable">';
			html += '<tr>';
			html += '<th scope="row">타이틀</th>';
			html += '<td><input type="text" class="form-control" value="'+data.qt_codename+'" readonly  style="inline-size: -webkit-fill-available;" name="qtCodeName"></td>';
			html += '<td hidden=""><input type="hidden" name="qeCode" value="'+data.qe_code+'" id="qeCode"></td>';
			html += '</tr>';
			html += '<tr>';
			html += '<th scope="row">문제 내용</th>';
			html += '<td><textarea style = "resize : none;" name="qeData">'+data.qe_data+'</textarea></td>';
			html += '</tr>';
			html += '<tr>';
			html += '<th scope="row">답안</th>';
			html += '<td><input type="text" class="form-control" value="'+data.qe_answer+'"  style="inline-size: -webkit-fill-available;" name="qeAnswer"></td>';
			html += '</tr>';
			html += '<tr>';
			html += '<th scope="row">A문항</th>';
			html += '<td><input type="text" class="form-control" value="'+data.qe_A+'"  style="inline-size: -webkit-fill-available;" name="qeA"></td>';
			html += '</tr>';
			html += '<tr>';
			html += '<th scope="row">B문항</th>';
			html += '<td><input type="text" class="form-control" value="'+data.qe_B+'"  style="inline-size: -webkit-fill-available;" name="qeB"></td>';
			html += '</tr>';
			html += '<tr>';
			html += '<th scope="row">C문항</th>';
			html += '<td><input type="text" class="form-control" value="'+data.qe_C+'"  style="inline-size: -webkit-fill-available;" name="qeC"></td>';
			html += '</tr>';
			html += '<tr>';
			html += '<th scope="row">D문항</th>';
			html += '<td><input type="text" class="form-control" value="'+data.qe_D+'"  style="inline-size: -webkit-fill-available;" name="qeD"></td>';
			html += '</tr>';
			html += '<tr>';
			html += '<th scope="row">점수</th>';
			html += '<td><input type="number" class="form-control" value="'+data.qe_score+'"  style="inline-size: -webkit-fill-available;" name="qeScore"></td>';
			html += '</tr>';
			html += '<tr>';
			html += '<th scope="row">출제일</th>';
			html += '<td><input type="text" class="form-control" value="'+data.qe_date+'"  style="inline-size: -webkit-fill-available;" readonly></td>';
			html += '</tr>';
			html += '</table>';
			html += '<div style="text-align: center;">';
			html += '<input type="button" class="btn btn-defult" value="수정" style="margin-right: 50px;" id="modifyQuestion">';
			html += '<input type="button" class="btn btn-defult deleteQuestion" value="삭제">';
			html += '</div>';
			$("#modifyViewForm").empty();
			$("#modifyViewForm").append(html);
			
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});
	});
	
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
				location.href='QuestionList';
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
		}else{
			alert('취소하셨습니다.');
		}
	});
	
	
	//문제타이틀추가
	$('#insertQuestionTitle').click(function(){
		var qtCodeName = $('input[name=qtCodeName]').val();
		var qtTitle = $('input[name=qtTitle]').val();
		var qtTeacher = $('input[name=qtTeacher]').val();
		if(confirm('등록하시겠습니까?')){
			if(qtCodeName != '' && qtTitle != ''){
				var request = $.ajax({
					url: "/insertQuestionTitle",
					method: "POST",
					data: { qtCodeName : qtCodeName , qtTitle : qtTitle , qtTeacher : qtTeacher },
					dataType: "json"
				});
				request.done(function(data) {
					alert('등록되었습니다.');
					opener.parent.location.reload();
					window.close();
					
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});
			}else{
				alert('값을 입력해주세요.');
			}
		}else{
			alert('취소하셨습니다.');
		}
	});
	
	
	$('#enrollmentQuestion').click(function(){
		localhost.href('/insertQuestion');
		
	});
	
	//문제타이틀등록페이지 
	$('#insertQuestionTitlePage').click(function(){
		if(questionSid != null && questionSid != undefined && questionSid != ''){
			if(confirm('등록하시겠습니까?')){
				window.open('/insertQuestionTitle','문제타이틀등록', 'width=550, height=201 left=600 top=100','status=no');
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
