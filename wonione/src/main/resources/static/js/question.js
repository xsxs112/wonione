/**
 * question 스크립트
 * 수정일 2020-09-23
 */
(function ($) {
	$('.questionCodeName').click(function(){
		var questionName = $('#questionCodeName').val();
		window.open('/Question?questionName='+questionName,'문제출제', 'width=600, height=600 left=600 top=100');
	});

})(jQuery); 
