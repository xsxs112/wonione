/**
 * 2020-09-24 새로 생성
 * 2020-09-26 직원공제계 등록, 직원급여 등록
 */
 
	$(function(){
	
		
 		// 직원 아이디값 받아 넘기기
 		$('.callOfficersInfo').click(function(){
 		var tr = $(this).parent().parent();
 		var td = tr.children();
 		var mrId = td.eq(0).text();
		var request = $.ajax({
			  url: "/callOfficersInfo",
			  method: "POST",
			  data: { mrId : mrId },
			  dataType: "json"
			});
			request.done(function(data) {
				$('#mrId').val(data.mrId);
				$('#mrName').val(data.mrName);
				$('#mrJoinDate').val(data.mrJoinDate);
				$('#pmRTitle').val(data.pmRTitle);
				$('#mrAccountNum').val(data.mrAccountNum);
				$('#opcCode').val(data.opcCode);
				
			});
			request.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
			});	
 		});
 		
 		//회원정보와 시급, 지급월 넘기기
 		$('#OfficersCalformBtn').click(function(){
			
			var mrId = $('input[name=mrId]').val();
			var mrName = $('input[name=mrName]').val();
			var pRTitle = $('select[name=pRTitle] option:selected').val();
			var opcHourlyWage = $('select[name=HourlyWage] option:selected').val();
				if(mrId == ''){
					alert('회원정보 선택해주세요.');
					return;
				}
				if(pRTitle == '::지급월::'){
					alert('지급월을 선택해주세요.');
					return;
				}
				if(opcHourlyWage == '::시급::'){
					alert('시급을 선택해주세요.');
					return;
				}
			var request = $.ajax({
				  url: "/callOfficersInfo",
				  method: "POST",
				  data: { mrId : mrId
					  , mrName : mrName
					  , pRTitle : pRTitle
					  , opcHourlyWage : opcHourlyWage
					  },
				  dataType: "json"
				});
				request.done(function(data) {
					
					$('#cMrId').val(data.mrId);
					$('#cMrName').val(data.mrName);
					$('#cpRTitle').val(data.pRTitle);
					$('#opcHourlyWage').val(data.opcHourlyWage);
					
				});
				request.fail(function( jqXHR, textStatus ) {
					  alert( "Request failed: " + textStatus );
					});	
			});  			  	
 		// 숫자 아닌경우 
 		$(document).on('keyup','#opcTotalHour', function(){
 			var regexp =  /^[0-9]*$/;
 			var regexpChange =  /[^0-9]/gi;
 			var v = $('#opcTotalHour').val();
 			if(!regexp.test(v)){ //숫자가 아니라면 				
 				$('#opcTotalHour').val(v.replace(regexpChange, ""));
 			}
 		});
 		
 		//근무시간 입력시 기본급 계산 
		$('#OfficersCalBaseBtn').click(function(){
		var baseMulti = 0;
		var pRTitle = $('#cpRTitle').val();
		var mrId = $('#cMrId').val();
		if($('#opcTotalHour').val() == null){
			alert('근무시간을 입력해주세요.');
			return;
		}
		baseMulti += Number($('#opcHourlyWage').val()) * Number($('#opcTotalHour').val());
			$('#opcBasePay').val(baseMulti);
			$('#cpRTitle').val(pRTitle);
			$('#cMrId').val(mrId);
		}); 			
	 	
	 	//급여계 총액 구하기	 		
		$('#OfficersCalTotalBtn').click(function(){
		var calSum = 0;
		var opcBasePay = Number($('#opcBasePay').val());
		var opcFoodExpenses = Number($('#opcFoodExpenses').val());
		var opcTransportation = Number($('#opcTransportation').val());
		var opcWelfare = Number($('#opcWelfare').val());
		var opcBonus = Number($('#opcBonus').val());
		var opcEct = Number($('#opcEct').val());
		calSum += opcBasePay 
				+ opcFoodExpenses 						
				+ opcTransportation 						
				+ opcWelfare 						
				+ opcBonus 						
				+ opcEct; 						
			$('#opcFoodExpenses').val(opcFoodExpenses);
			$('#opcTransportation').val(opcTransportation);
			$('#opcWelfare').val(opcWelfare);
			$('#opcBonus').val(opcBonus);
			$('#opcEct').val(opcEct);
			$('#opcTotal').val(calSum);
		}); 			

 		//직원 급여계 입력
		$('#offiCalInsertBtn').click(function(){
			var foinForm = $('#offiCalFoinForm');
			var opcCode = $('#opcCode').val();
			var mrId = $('#cMrId').val();
			var pRTitle = $('#cpRTitle').val();
			var opcHourlyWage = $('#opcHourlyWage').val();
			var opcTotalHour = $('#opcTotalHour').val();
			var opcBasePay = $('#opcBasePay').val();
			var opcFoodExpenses = $('#opcFoodExpenses').val();
			var opcTransportation = $('#opcTransportation').val();
			var opcWelfare = $('#opcWelfare').val();
			var opcBonus = $('#opcBonus').val();
			var opcEct = $('#opcEct').val();
			var opcTotal = $('#opcTotal').val();		
			
			var request = $.ajax({
				  url: "/addOffiCalpay",
				  method: "POST",
				  data: { opcCode : opcCode
					  	, mrId : mrId
					  	, pRTitle : pRTitle
					  	, opcHourlyWage : opcHourlyWage
					  	, opcTotalHour : opcTotalHour
					  	, opcBasePay : opcBasePay
					  	, opcFoodExpenses : opcFoodExpenses
					  	, opcTransportation : opcTransportation
					  	, opcWelfare : opcWelfare
					  	, opcBonus : opcBonus
					  	, opcEct : opcEct
					  	, opcTotal : opcTotal },
				  dataType: "json"
				});
					request.done(function(data) {
					$('#opcCode').val(data.opcCode);
					$('#mrId').val(data.mrId);
					$('#pRTitle').val(data.pRTitle);
					$('#opcHourlyWage').val(data.opcHourlyWage);
					$('#opcTotalHour').val(data.opcTotalHour);
					$('#opcBasePay').val(data.opcBasePay);
					$('#opcFoodExpenses').val(data.opcFoodExpenses);
					$('#opcTransportation').val(data.opcTransportation);
					$('#opcWelfare').val(data.opcWelfare);
					$('#opcBonus').val(data.opcBonus);
					$('#opcEct').val(data.opcEct);
					$('#opcTotal').val(data.opcTotal);	
					$('#opdCode').val(data.opcCode);
					$('#dpRTitle').val(data.pRTitle);
					$('#dMrId').val(data.mrId);				
						alert( "입력이 완료되었습니다.");				
				});
					request.fail(function( jqXHR, textStatus ) {
					  alert( "Request failed: " + textStatus );
				});	
				
		});	
 		
 		
 		
 		
 		
	});
		
 