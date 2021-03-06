/**
 * consulting 스크립트
 * 수정일 2020-09-22
 */

(function ($) {
 

	
	//상담수정
	$('#upConsulting').click(function(){
		var consultingTitle = $('#consultingTitle');
		var consultingForm = $('#consultingForm');
		if(consultingTitle.val() != ''){
			if(confirm('수정하시겠습니까?')){
				alert('수정되었습니다.');
				consultingForm.submit();
			}else{
				alert('취소하셨습니다.');
			}
		}else{
			alert('제목을 써주세요.');
		}
	
	});
	
	//상담삭제                           
	$('#deleteConsulting').click(function(){
		var consultingTitle = $('#consultingTitle');
		if(consultingTitle.val() != ''){
		if(confirm('삭제하시겠습니까?')){
			var csCode =  $('#consultingCode').val();
			var request = $.ajax({
				url: "/deleteConsulting",
				method: "POST",
				data: { csCode : csCode},
				dataType: "json"
			});
			request.done(function(data) {
				if(data = '1'){
					alert('삭제되었습니다.');
					location.href="/consultingList";

				}else{
					alert('삭제에 실패하였습니다.');
				}
			});
			request.fail(function( jqXHR, textStatus ) {
				 alert( "Request failed: " + textStatus );
			});
			}else{
				alert('취소하셨습니다.');
			}
		}else{
			alert('제목을 써주세요.');
		}
		
	});
	
	
	//상담상세내용출력
	$('.consultingTitle').click(function(){
		var csCode = $(this).parent().children('input[name=consultingCode]').val(); 
		var request = $.ajax({
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
			});
	});
	//상담등록consultingWrite유효성검사
	$('#addconsultingbtn').click(function(){
		var consultingTitle = $('input[name=consultingTitle]');
		var consultingTeacher = $('select[name=consultingTeacher] option:selected').index();
		var consultingClass = $('select[name=consultingClass] option:selected').index();
		var consultingStudent = $('input[name=consultingStudent]');
		var consultingData = $('input[name=consultingData]');
		
		if(consultingTitle.val() == ''){
			alert('제목을 입력해주세요.');
			consultingTitle.focus();
			return false;
		}
		if(consultingTitle.val().replace(/\s|　/gi, "").length == 0){
			alert('제목에 공백으로 시작했습니다.');
			consultingTitle.focus();
			return false;
		}
		if(consultingTeacher == ''){
			alert('상담자체크가 안됬습니다.');
			$('select[name=consultingTeacher]:eq(0)').focus();
			return false;
		}
		if(consultingClass == ''){
			alert('강의반체크가 안됬습니다.');
			$('select[name=consultingClass]:eq(0)').focus();
			return false;
		}
		if(consultingStudent.val() == ''){
			alert('내담자를 입력해주세요.');
			consultingStudent.focus();
			return false;
		}
		if(consultingStudent.val().replace(/\s|　/gi, "").length == 0){
			alert('내담자입력에 공백으로 시작했습니다.');
			consultingStudent.focus();
			return false;
		}
		
		return true;
	});

 
})(jQuery); 