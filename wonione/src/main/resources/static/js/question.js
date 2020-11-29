/**
 * question 스크립트
 * 수정일 2020-10-06
 */
(function ($) {
	//테스트용 문제 제거방지
	$('#notDeleteQuestionTitle').click(function(){
		alert('해당 문제는 삭제할수 없습니다. \n새로 타이틀을 생성해주세요.');
	});
	
	//인원확인에서 삭제버튼
	$(document).on('click','.deleteCandidateQuestion',function(){
		var candidateQuestionId = $(this).parents().children('#candidateQuestionId').text();
		var candidateQuestionCodeName = $('.candidateQuestionCodeName').val();
		if(confirm('삭제 하시겠습니까?')){
			var request = $.ajax({
				url: "/deleteCandidateQuestion",
				method: "POST",
				data: {candidateQuestionId : candidateQuestionId , candidateQuestionCodeName : candidateQuestionCodeName},
				dataType: "json"
			});
			request.done(function(data) {
				alert('삭제되었습니다.');
				location.href='candidateQuestionList?qtCodeName='+candidateQuestionCodeName;
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
			
		}else{
			alert('취소하셨습니다.');
		}
		
	});
	//검색기능
	$(document).on('click','#selectcandidateQuestionId',function(){
		var candidateQuestionCodeName = $('.candidateQuestionCodeName').val();
		var selectcandidateQuestionId = $('input[name=selectcandidateQuestionId]').val();
		var selectcandidateQuestionIdCheck = $('input[name=selectcandidateQuestionId]');
		if(selectcandidateQuestionId == ''){
			alert('검색값을 입력해주세요.');
			selectcandidateQuestionIdCheck.focus();
		}else{
			var request = $.ajax({
				url: "/selectcandidateQuestionId",
				method: "POST",
				data: {selectcandidateQuestionId : selectcandidateQuestionId , candidateQuestionCodeName : candidateQuestionCodeName},
				dataType: "json"
			});
			request.done(function(data) {
				if(data != 0){
					html = '';
					for(var i=0; i<data.length; i++){
						html += '<tr>';
						html += '<td>'+data[i].rowNum+'</td>';
						html += '<td hidden="" id="candidateQuestionId">'+data[i].qc_student+'</td>';
						html += '<td>'+data[i].mr_name+'</td>';
						html += '<td id="candidateQuestionCodeName">'+data[i].qt_codename+'</td>';
						html += '<td>'+data[i].qe_score+'</td>';
						html += '<td>'+data[i].qc_date+'</td>';
						html += '<td><button type="button" class="btn btn-default deleteCandidateQuestion">삭제</button></td>';
						html += '</tr>';
					}
					$("#changeDataCandidateQuestionList").empty();
					$("#changeDataCandidateQuestionList").append(html);
				}else{
					Writing = '';
					Writing += '<tr>';
					Writing += '<td colspan="6">검색값이 없습니다.</td>';
					Writing += '</tr>';
					
					$("#changeDataCandidateQuestionList").empty();
					$("#changeDataCandidateQuestionList").append(Writing);
				}
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
		}
	});
	//응시초기화
	$('#candidateQuestionInitialization').click(function(){
		var candidateQuestionCodeName = $('.candidateQuestionCodeName').val();
		if(candidateQuestionCodeName == ''){
			alert('응시자가 없습니다.');
		}else{
			if(confirm('정말삭제하시겠습니까?\n*해당 문제를 응시했던 모든인원이 삭제됩니다.')){
				var request = $.ajax({
					url: "/candidateQuestionInitialization",
					method: "POST",
					data: { candidateQuestionCodeName : candidateQuestionCodeName},
					dataType: "json"
				});
				request.done(function(data) {
					alert('삭제되었습니다.');
					location.href='candidateQuestionList?qtCodeName='+candidateQuestionCodeName;
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});
			}else{
				alert('취소하셨습니다.');
			}
		}
	});
	
	//학생화면의 점수확인
	$('.questionScoreCheck').click(function(){
		var questionSid = $(this).parents().children().children('#questionSid').val();
		var questionCodeName = $(this).parents().children().children('#questionCodeName').val();
		var request = $.ajax({
			url: "/questionScoreCheck",
			method: "POST",
			data: { questionSid : questionSid , questionCodeName : questionCodeName},
			dataType: "json"
		});
		request.done(function(data) {
			if(data.qc_date == null){
				swal('해당 시험을 응시하지않았습니다.');
			}else{
				var html = '';
				html += '수고하셨습니다.\n';
				html += '이름 : '+data.mr_name+'\n';
				html += '점수 : '+data.qe_score+'\n';
				html += '응시일 : '+data.qc_date+'\n';
				html += '추천반 : '+data.scoreClass;
				swal(html);
			}
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});
		
	});
	
	
	//타이틀수정ajax
	$('#modifyQuestionTitlebtn').click(function(){
		var qtCodeName = $(this).parents().children('input[name=qtCodeName]').val();
		var qtTitle = $('input[name=qtTitle]').val();
		var qtTitleFocus = $('input[name=qtTitle]');
		if(qtTitle != ''){
			var request = $.ajax({
				url: "/modifyQuestionTitle",
				method: "POST",
				data: { qtCodeName : qtCodeName , qtTitle : qtTitle },
				dataType: "json"
			});
			request.done(function(data) {
				alert('수정되었습니다.');
				opener.parent.location.reload();
				window.close();
				
			});
			request.fail(function( jqXHR, textStatus ) {
				alert( "Request failed: " + textStatus );
			});
		}else{
			alert('수정값을 입력해주세요.');
			qtTitleFocus.focus();
		}
		
	});
	
	//타이틀수정
	$('.modifyQuestionTitle').click(function(){
		var questionCodeName = $(this).parents().children('#questionCodeName').val();
		var questionTitle = $(this).parents().children('#questionCodeTitle').text();
		if(confirm('타이틀수정 하시겠습니까?')){
			window.open('/modifyQuestionTitle?questionCodeName='+questionCodeName+'&questionTitle='+questionTitle,'타이틀수정', 'width=550, height=201 left=600 top=100','status=no');
		}else{
			alert('취소하셨습니다.');
		}
		
	});
	
	//문제등록유효성검사
	$('#insertQuestionbtn').click(function(){
		var qeA = $('input[name=qeA]');
		var qeB = $('input[name=qeB]');
		var qeC = $('input[name=qeC]');
		var qeD = $('input[name=qeD]');
		var qeScore = $('input[name=qeScore]');
		if(qeA.val() == ''){
			alert('A보기 값을 넣어주세요.');
			qeA.focus();
			return false;
		}
		if(qeA.val().replace(/\s|　/gi, "").length == 0){
			alert('공백이 들어갔습니다.');
			qeA.focus();
			return false;
		}
		if(qeB.val() == ''){
			alert('B보기 값을 넣어주세요.');
			qeB.focus();
			return false;
		}
		if(qeB.val().replace(/\s|　/gi, "").length == 0){
			alert('공백이 들어갔습니다.');
			qeB.focus();
			return false;
		}
		if(qeC.val() == ''){
			alert('C보기 값을 넣어주세요.');
			qeC.focus();
			return false;
		}
		if(qeC.val().replace(/\s|　/gi, "").length == 0){
			alert('공백이 들어갔습니다.');
			qeC.focus();
			return false;
		}
		if(qeD.val() == ''){
			alert('D보기 값을 넣어주세요.');
			qeD.focus();
			return false;
		}
		if(qeD.val().replace(/\s|　/gi, "").length == 0){
			alert('공백이 들어갔습니다.');
			qeD.focus();
			return false;
		}
		if(qeScore.val() == ''){
			alert('문제점수를 작성해주세요.');
			qeScore.focus();
			return false;
		}
	});
	
	
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
			alert('수정되었습니다.');
		}else{
			alert('취소하셨습니다.');
		}
	});
	//한글입력방지
	function checkNoKr(e) {
		 var objTarget = e.srcElement || e.target;
		 if(objTarget.type == 'text') {
		  var value = objTarget.value;
		  if(/[ㄱ-ㅎㅏ-ㅡ가-핳]/.test(value)) {
		   alert('한글은 사용하실 수 없습니다.');
		   objTarget.value = objTarget.value.replace(/[ㄱ-ㅎㅏ-ㅡ가-핳]/g,'');
		  }
		 }
		};

	//문제등록
	$('#insertQuestion').click(function(){
		var qtCodeName = $('.titleQuestionListCodeName').val();
		if(confirm('등록하시겠습니까?')){
			window.open('/insertQuestion?qtCodeName='+qtCodeName,'문제등록', 'width=540, height=725 left=600 top=100','status=no');
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
			html += '<th scope="row">문제 풀이</th>';
			html += '<td><textarea style = "resize : none;" name="qeData">'+data.qe_problem_solving+'</textarea></td>';
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
			html += '<input type="submit" class="btn btn-defult" value="수정" style="margin-right: 50px;" id="modifyQuestion">';
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
		var qtCodeNameFocus = $('input[name=qtCodeName]');
		var qtTitle = $('input[name=qtTitle]').val();
		var qtTitleFocus = $('input[name=qtTitle]');
		var qtTeacher = $('input[name=qtTeacher]').val();
		if(confirm('등록하시겠습니까?')){
		var request = $.ajax({
			url: "/QuestionTitleNameCheck",
			method: "POST",
			data: { qtCodeName : qtCodeName},
			dataType: "json"
		});
		request.done(function(data) {
			if(data == 0){
				if(qtCodeName != ''){
					if(qtTitle != ''){
						var request = $.ajax({
							url: "/insertQuestionTitle",
							method: "POST",
							data: { qtCodeName : qtCodeName , qtTitle : qtTitle , qtTeacher : qtTeacher },
							dataType: "json"
						});
						request.done(function(data) {
							alert('등록되었습니다.');
							window.top.location.reload();
							
						});
						request.fail(function( jqXHR, textStatus ) {
							alert( "Request failed: " + textStatus );
						});
					}else{
						alert('LIST TITLE를 써주세요.');
						qtTitleFocus.trigger('focus');
					}
				}else{
					alert('문제이름을 써주세요.');
					qtCodeNameFocus.trigger('focus');
				}
			}else{
				alert('문제이름이 중복입니다.');
				qtCodeNameFocus.trigger('focus');
			}
		});
		request.fail(function( jqXHR, textStatus ) {
			alert( "Request failed: " + textStatus );
		});
		}else{
			alert('취소하셨습니다.');
		}
	});
	
	
	$('#enrollmentQuestion').click(function(){
		localhost.href('/insertQuestion');
		
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
				if(data == 0){
					window.open('/Question?questionName='+questionName,'문제출제', 'width=600, height=320 left=600 top=100');
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
		}else{
			alert('답을 체크해주세요.');
			return false;
		}
	});
	//점수 확인
	$('#QuestionbtnCompletion').click(function(){
		alert('고생하셨습니다.\n점수확인해주세요.');
		opener.parent.location.reload();
		window.close();
	});
	
})(jQuery); 
