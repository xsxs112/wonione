/**
 * 20-09-27 생성
 * 
 */
 
 	$(function(){	
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
			
			console.log(pRTitle+"<-pRTitle");
			console.log(spcIncentivePer+"<-spcIncentivePer");
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
					console.log(JSON.stringify(data));
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
				console.log(data);
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
	});
