/**
 * 20-09-27 생성
 * 
 */
  
 	$(function(){
 	
 	
 	
 		//원천징수금액 구하기
 		$('#StaffBusiTaxBtn').click(function(){

			var spdCode = $('input[name=spdCode]').val();
			var iyCode = $('select[name=iyCode] option:selected').val();
			var pRTitle = $('#dpRTitle').val();
			var mrId = $('#dMrId').val();	

			if(iyCode == '::시행년도::'){
				alert('시행년도를 선택해주세요.');
				return;
			}						
				
  			var spdTheBusinessTax = Number($('#spdTheBusinessTax').val());	
  			console.log(spdTheBusinessTax +' <--spdTheBusinessTax');
  				
			var request = $.ajax({
				  url: "/StaffPayDedu",
				  method: "POST",
				  data: { spdCode : spdCode						 
						 , iyCode : iyCode
						 },
				  dataType: "json"
				});
			request.done(function(data){
				console.log(JSON.stringify(data));
								
				$('#spdCode').val(spdCode);
				$('#dpRTitle').val(pRTitle);
				$('#dMrId').val(mrId);
				$('#iyCode').val(iyCode);
				$('#spdTheBusinessTax').val(data.spdTheBusinessTax);				
			});
			request.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
			});	

		});	
 		
 	
		//강사 급여계 입력
		$('#staffCalInsertBtn').click(function(){
			var foinForm = $('#staffCalFoinForm');
			var spcCode = $('#spcCode').val();
			var mrId = $('#cMrId').val();
			var pRTitle = $('#cpRTitle').val();
			var spcHourlyWage = $('#spcHourlyWage').val();
			var spcTotalHour = $('#spcTotalHour').val();
			var spcBasePay = $('#spcBasePay').val();
			var spcIncentivePer = $('#spcIncentivePer').val();
			var spcIncentive = $('#spcIncentive').val();
			var spcTotal = $('#spcTotal').val();	
				
			if($('#spcTotal').val() == null || $('#spcTotal').val() == undefined || $('#spcTotal').val() == '' || $('#spcTotal').val() == 0){
			alert('총액을 다시 입력해주세요.');
			return;
			}
			var request = $.ajax({
				  url: "/addStaffCalPay",
				  method: "POST",
				  data: { spcCode : spcCode
					  	, mrId : mrId
					  	, pRTitle : pRTitle
					  	, spcHourlyWage : spcHourlyWage
					  	, spcTotalHour : spcTotalHour
					  	, spcBasePay : spcBasePay
					  	, spcIncentivePer : spcIncentivePer
					  	, spcIncentive : spcIncentive
					  	, spcTotal : spcTotal 
					  	},
				  dataType: "json"
				});
					request.done(function(data) {
					$('#spcCode').val(data.spcCode);
					$('#cMrId').val(data.mrId);
					$('#cpRTitle').val(data.pRTitle);
					$('#spcHourlyWage').val(data.spcHourlyWage);
					$('#spcTotalHour').val(data.spcTotalHour);
					$('#spcBasePay').val(data.spcBasePay);
					$('#spcIncentivePer').val(data.spcIncentivePer);
					$('#spcIncentive').val(data.spcIncentive);
					$('#spcTotal').val(data.spcTotal);
					$('#spdCode').val(data.spcCode);
					$('#dpRTitle').val(data.pRTitle);
					$('#dMrId').val(data.mrId);
		
						alert( "입력이 완료되었습니다.");				
				});
					request.fail(function( jqXHR, textStatus ) {
					  alert( "Request failed: " + textStatus );
				});	
				
		});	
		
	 	//급여계 총액 구하기	 		
		$('#StaffCalTotalBtn').click(function(){
			var calSum = 0;
			var spcBasePay = Number($('#spcBasePay').val());
			var spcIncentivePer = $('#spcIncentivePer').val();	
			var spcIncentive = spcBasePay * spcIncentivePer;
			
			calSum += spcBasePay 
					+ spcIncentive 						
									
				$('#spcBasePay').val(spcBasePay);
				$('#spcIncentivePer').val(spcIncentivePer);
				$('#spcIncentive').val(spcIncentive);
				$('#spcTotal').val(calSum);
		}); 
					 	 	
 		//근무시간 입력시 기본급 계산 
		$('#StaffCalBaseBtn').click(function(){
			var baseMulti = 0;
			var pRTitle = $('#cpRTitle').val();
			var mrId = $('#cMrId').val();
			if($('#spcTotalHour').val() == null || $('#spcTotalHour').val() == undefined || $('#spcTotalHour').val() == ''){
				alert('근무시간을 입력해주세요.');
				return;
			}
			baseMulti += Number($('#spcHourlyWage').val()) * Number($('#spcTotalHour').val());
				$('#spcBasePay').val(baseMulti);
				$('#cpRTitle').val(pRTitle);
				$('#cMrId').val(mrId);
		}); 	 	
 	
  		//강사정보와 시급, 지급월, 인센티브 넘기기
 		$(document).on('click','#StaffCalformBtn',function(){
			
			var mrId = $('input[name=mrId]').val();
			var mrName = $('input[name=mrName]').val();
			var pRTitle = $('select[name=pRTitle] option:selected').val();
			var spcHourlyWage = $('select[name=HourlyWage] option:selected').val();
			var spcIncentivePer = $('select[name=incentive] option:selected').val();
			
				if(mrId == null || mrId == undefined || mrId == ''){
					alert('강사정보 선택해주세요.');
					return;
				}
				if(pRTitle == '::지급월::'){
					alert('지급월을 선택해주세요.');
					return;
				}
				if(spcHourlyWage == '::시급::'){
					alert('시급을 선택해주세요.');
					return;
				}
				if(spcIncentivePer == '::인센티브::'){
					alert('인센티브를 선택해주세요.');
					return;
				}	
				

			var request = $.ajax({
				  url: "/callStaffInfo",
				  method: "POST",
				  data: { mrId : mrId
					  , mrName : mrName
					  , pRTitle : pRTitle
					  , spcHourlyWage : spcHourlyWage
					  , spcIncentivePer : spcIncentivePer
					  },
				  dataType: "json"
				});
				request.done(function(data) {
					$('#cMrId').val(data.mrId);
					$('#cMrName').val(data.mrName);
					$('#cpRTitle').val(data.pRTitle);
					$('#spcHourlyWage').val(data.spcHourlyWage);
					$('#spcIncentivePer').val(data.spcIncentivePer);
					
				});

				request.fail(function( jqXHR, textStatus ) {
					  alert( "Request failed: " + textStatus );
				});	
			});  	 	
 	
	// 강사 아이디값 받아 넘기기
 		$('.callStaffInfo').click(function(){
 		var tr = $(this).parent().parent();
 		var td = tr.children();
 		var mrId = td.eq(0).text(); 	
		var request = $.ajax({
			  url: "/callStaffInfo",
			  method: "POST",
			  data: { mrId : mrId },
			  dataType: "json"
			});
			request.done(function(data) {
				$('#mrId').val(data.mrId);
				$('#mrName').val(data.mrName);
				$('#pmRTitle').val(data.pmRTitle);
				$('#mrAccountNum').val(data.mrAccountNum);
				$('#spcCode').val(data.spcCode);
				
			});
			request.fail(function( jqXHR, textStatus ) {
				  alert( "Request failed: " + textStatus );
			});
			
		});
		
		
		
 		// 숫자 아닌경우 
 		$(document).on('keyup','#spcTotalHour', function(){
 			var regexp =  /^[0-9]*$/;
 			var regexpChange =  /[^0-9]/gi;
 			var v = $('#spcTotalHour').val();
 			if(!regexp.test(v)){ //숫자가 아니라면 				
 				$('#spcTotalHour').val(v.replace(regexpChange, ""));
 			}
 		});		
		
	});
