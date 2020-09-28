/**
 * 2020-09-24 새로 생성
 * 2020-09-26 직원공제계 등록, 직원급여 등록
 * 2020-09-27 등록완료 (유효성검사 검토필요)
 */
 
	$(function(){
	
	
	 	//직원급여 총액 구하기	 		
		$('#OfficersPayTotalBtn').click(function(){
		var totalPay = 0;
		
		var opcTotal = Number($('#opcTotal').val());
		var opdTotal = Number($('#opdTotal').val());
		totalPay += opcTotal 
					- opdTotal;
			
		$('#opPay').val(totalPay);
		});	
	
		 //직원 공제계 입력
		$('#offiDeduInsertBtn').click(function(){
			var foinForm = $('#offiDeduFoinForm');
			var opdCode = $('#opdCode').val();
			var opcCode = $('#opcCode').val();
			var mrId = $('#dMrId').val();
			var pRTitle = $('#dpRTitle').val();
			var iyCode = $('#iyCode').val();
			var opdIncomeTax = $('#opdIncomeTax').val();
			var opdResidentIncomTax = $('#opdResidentIncomTax').val();
			var opdEmploymentInsurance = $('#opdEmploymentInsurance').val();
			var opdNationalPension = $('#opdNationalPension').val();
			var opdHealthInsurance = $('#opdHealthInsurance').val();
			var opdLongtermNursingInsurance = $('#opdLongtermNursingInsurance').val();
			var opdTotal = $('#opdTotal').val();
			
			var request = $.ajax({
				  url: "/addOffiDedupay",
				  method: "POST",
				  data: { opdCode : opdCode
						, opcCode : opcCode
					  	, mrId : mrId
					  	, pRTitle : pRTitle
					  	, iyCode : iyCode
					  	, opdIncomeTax : opdIncomeTax
					  	, opdResidentIncomTax : opdResidentIncomTax
					  	, opdEmploymentInsurance : opdEmploymentInsurance
					  	, opdNationalPension : opdNationalPension
					  	, opdHealthInsurance : opdHealthInsurance
					  	, opdLongtermNursingInsurance : opdLongtermNursingInsurance
					  	, opdTotal : opdTotal },
				  dataType: "json"
				});
					request.done(function(data) {
					$('#opdCode').val(data.opdCode);
					$('#dMrId').val(data.mrId);
					$('#dpRTitle').val(data.pRTitle);
					$('#iyCode').val(data.iyCode);
					$('#opdIncomeTax').val(data.opdIncomeTax);
					$('#opdResidentIncomTax').val(data.opdResidentIncomTax);
					$('#opdEmploymentInsurance').val(data.opdEmploymentInsurance);
					$('#opdNationalPension').val(data.opdNationalPension);
					$('#opdHealthInsurance').val(data.opdHealthInsurance);
					$('#opdLongtermNursingInsurance').val(data.opdLongtermNursingInsurance);
					$('#opdTotal').val(data.opdTotal);
						
						alert( "입력이 완료되었습니다.");				
				});
					request.fail(function( jqXHR, textStatus ) {
					  alert( "Request failed: " + textStatus );
				});	
				
		});	
				 
		//요율시행년도, 소득세 넘기기
 		$('#OfficersDeduBtn').click(function(){

			var opdCode = $('input[name=opdCode]').val();
			var opdIncomeTax = $('input[name=opdIncomeTax]').val();
			var iyCode = $('select[name=iyCode] option:selected').val();
			var pRTitle = $('#dpRTitle').val();
			var mrId = $('#dMrId').val();	
			
			if(opdIncomeTax == null || opdIncomeTax == undefined || opdIncomeTax == ''){
				alert('소득세를 입력해주세요.');
				return;
			}
			if(iyCode == '::시행년도::'){
				alert('시행년도를 선택해주세요.');
				return;
			}
						
  			var opdResidentIncomTax = Number($('#opdResidentIncomTax').val());
			var opdEmploymentInsurance = Number($('#opdEmploymentInsurance').val());
			var opdNationalPension = Number($('#opdNationalPension').val());
			var opdHealthInsurance = Number($('#opdHealthInsurance').val());
			var opdLongtermNursingInsurance = Number($('#opdLongtermNursingInsurance').val()); 
			
				
			var request = $.ajax({
				  url: "/OfficersDedu",
				  method: "POST",
				  data: { opdCode : opdCode
						 , opdIncomeTax : opdIncomeTax
						 , iyCode : iyCode
						 },
				  dataType: "json"
				});
			request.done(function(data){
				
				$('#opdCode').val(opdCode);
				$('#dpRTitle').val(pRTitle);
				$('#dMrId').val(mrId);
				$('#iyCode').val(iyCode);
				$('#opdIncomeTax').val(data.opdIncomeTax);
				$('#opdResidentIncomTax').val(data.opdResidentIncomTax);
				$('#opdEmploymentInsurance').val(data.opdEmploymentInsurance);
				$('#opdNationalPension').val(data.opdNationalPension);
				$('#opdHealthInsurance').val(data.opdHealthInsurance);
				$('#opdLongtermNursingInsurance').val(data.opdLongtermNursingInsurance);
				
			});
			request.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
			});	

		});	
		
	 	//공제계 총액 구하기	 		
		$('#OfficersDeduTotalBtn').click(function(){
		var deduSum = 0;
		var opdIncomeTax = Number($('#opdIncomeTax').val());
		var opdResidentIncomTax = Number($('#opdResidentIncomTax').val());
		var opdEmploymentInsurance = Number($('#opdEmploymentInsurance').val());
		var opdNationalPension = Number($('#opdNationalPension').val());
		var opdHealthInsurance = Number($('#opdHealthInsurance').val());
		var opdLongtermNursingInsurance = Number($('#opdLongtermNursingInsurance').val());
		
		if(opdResidentIncomTax == null || opdResidentIncomTax == undefined || opdResidentIncomTax == ''){
			alert('보험료 계산을 해주세요.');
			return;
		}
		
		deduSum += opdIncomeTax 
				+ opdResidentIncomTax 						
				+ opdEmploymentInsurance 						
				+ opdNationalPension 						
				+ opdHealthInsurance 						
				+ opdLongtermNursingInsurance; 						
			$('#opdIncomeTax').val(opdIncomeTax);
			$('#opdResidentIncomTax').val(opdResidentIncomTax);
			$('#opdEmploymentInsurance').val(opdEmploymentInsurance);
			$('#opdNationalPension').val(opdNationalPension);
			$('#opdHealthInsurance').val(opdHealthInsurance);
			$('#opdLongtermNursingInsurance').val(opdLongtermNursingInsurance);
			$('#opdTotal').val(deduSum);
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
				
			if($('#opcTotal').val() == null || $('#opcTotal').val() == undefined || $('#opcTotal').val() == '' || $('#opcTotal').val() == 0){
			alert('총액을 다시 입력해주세요.');
			return;
			}
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
		
 		//근무시간 입력시 기본급 계산 
		$('#OfficersCalBaseBtn').click(function(){
			var baseMulti = 0;
			var pRTitle = $('#cpRTitle').val();
			var mrId = $('#cMrId').val();
			if($('#opcTotalHour').val() == null || $('#opcTotalHour').val() == undefined || $('#opcTotalHour').val() == ''){
				alert('근무시간을 입력해주세요.');
				return;
			}
			baseMulti += Number($('#opcHourlyWage').val()) * Number($('#opcTotalHour').val());
				$('#opcBasePay').val(baseMulti);
				$('#cpRTitle').val(pRTitle);
				$('#cMrId').val(mrId);
		}); 
		
 		//직원정보와 시급, 지급월 넘기기
 		$('#OfficersCalformBtn').click(function(){
			
			var mrId = $('input[name=mrId]').val();
			var mrName = $('input[name=mrName]').val();
			var pRTitle = $('select[name=pRTitle] option:selected').val();
			var opcHourlyWage = $('select[name=HourlyWage] option:selected').val();
				if(mrId == null || mrId == undefined || mrId == ''){
					alert('직원정보 선택해주세요.');
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
 		
 		
 		 		// 숫자 아닌경우 
 		$(document).on('keyup','#opcTotalHour', function(){
 			var regexp =  /^[0-9]*$/;
 			var regexpChange =  /[^0-9]/gi;
 			var v = $('#opcTotalHour').val();
 			if(!regexp.test(v)){ //숫자가 아니라면 				
 				$('#opcTotalHour').val(v.replace(regexpChange, ""));
 			}
 		});
 		$(document).on('keyup','#opcFoodExpenses', function(){
 			var regexp =  /^[0-9]*$/;
 			var regexpChange =  /[^0-9]/gi;
 			var v = $('#opcFoodExpenses').val();
 			if(!regexp.test(v)){ //숫자가 아니라면 				
 				$('#opcFoodExpenses').val(v.replace(regexpChange, ""));
 			}
 		});
 		$(document).on('keyup','#opcTransportation', function(){
 			var regexp =  /^[0-9]*$/;
 			var regexpChange =  /[^0-9]/gi;
 			var v = $('#opcTransportation').val();
 			if(!regexp.test(v)){ //숫자가 아니라면 				
 				$('#opcTransportation').val(v.replace(regexpChange, ""));
 			}
 		});
 		$(document).on('keyup','#opcWelfare', function(){
 			var regexp =  /^[0-9]*$/;
 			var regexpChange =  /[^0-9]/gi;
 			var v = $('#opcWelfare').val();
 			if(!regexp.test(v)){ //숫자가 아니라면 				
 				$('#opcWelfare').val(v.replace(regexpChange, ""));
 			}
 		});
 		$(document).on('keyup','#opcBonus', function(){
 			var regexp =  /^[0-9]*$/;
 			var regexpChange =  /[^0-9]/gi;
 			var v = $('#opcBonus').val();
 			if(!regexp.test(v)){ //숫자가 아니라면 				
 				$('#opcBonus').val(v.replace(regexpChange, ""));
 			}
 		});
 		$(document).on('keyup','#opcEct', function(){
 			var regexp =  /^[0-9]*$/;
 			var regexpChange =  /[^0-9]/gi;
 			var v = $('#opcEct').val();
 			if(!regexp.test(v)){ //숫자가 아니라면 				
 				$('#opcEct').val(v.replace(regexpChange, ""));
 			}
 		});
 		$(document).on('keyup','#opdIncomeTax', function(){
 			var regexp =  /^[0-9]*$/;
 			var regexpChange =  /[^0-9]/gi;
 			var v = $('#opdIncomeTax').val();
 			if(!regexp.test(v)){ //숫자가 아니라면 				
 				$('#opdIncomeTax').val(v.replace(regexpChange, ""));
 			}
 		});
 		
 		
 		
	});
		
 