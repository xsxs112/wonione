/**
 * 2020-10-15 새로 생성
 * 2020-10-27 미지급, 월별, 년도별 조회 완료
 * (수정 필요) 숫자 3자리마다 콤마, 값 없을경우 목록 안뜨게 수정
 * 
 */
 
 
	 $(function(){	
	 	//숫자 3자리마다 콤마
	 	function numberFormat(inputNumber) {
		   return inputNumber.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}
		
	 	//강사 년도별 조회
	 	$(document).on('change', '#iyCode',(function(){
	 		var iyCode = $('select[name=iyCode] option:selected').val();
	 		var request = $.ajax({
					url: "/yearStaffPay",
					method: "POST",
					data: {	iyCode : iyCode },
					dataType: "json"
				});
				request.done(function(data){
					html = '';
					
					for(var i=0; i<data.length; i++){
					
					html += '<tr>';
					html += '<td style="text-align: center;">'+data[i].spCode+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrId+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrName+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].spDate+'</td>';
		  			html += '<td style="text-align: center;">'+numberFormat(data[i].spPay)+'원</td>';
		  			html += '<td style="text-align: center;">'+data[i].spRegDate+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].spWriter+'</td>';
		  			html += '</tr>'
					
					$("#searchPayList2").empty();
					$("#searchPayList2").append(html);		
					};		
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				
	 	}));	 
	 
	 	//직원 년도별 조회
	 	$(document).on('change', '#iyCode',(function(){
	 		var iyCode = $('select[name=iyCode] option:selected').val();
	 		var request = $.ajax({
					url: "/yearOffiPay",
					method: "POST",
					data: {	iyCode : iyCode },
					dataType: "json"
				});
				request.done(function(data){
					html = '';
					
					for(var i=0; i<data.length; i++){
					
					html += '<tr>';
					html += '<td style="text-align: center;">'+data[i].opCode+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrId+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrName+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opDate+'</td>';
		  			html += '<td style="text-align: center;">'+numberFormat(data[i].opPay)+'원</td>';
		  			html += '<td style="text-align: center;">'+data[i].opRegDate+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opWriter+'</td>';
		  			html += '</tr>'
					
					$("#searchPayList").empty();
					$("#searchPayList").append(html);		
					};		
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				
	 	}));
	 	
	 	//강사 월별 조회
	 	$(document).on('change', '#pRTitle',(function(){
	 		var pRTitle = $('select[name=pRTitle] option:selected').val();
	 		var request = $.ajax({
					url: "/monthStaffPay",
					method: "POST",
					data: {	pRTitle : pRTitle },
					dataType: "json"
				});
				request.done(function(data){
					html = '';
					
					for(var i=0; i<data.length; i++){
					
					html += '<tr>';
					html += '<td style="text-align: center;">'+data[i].spCode+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrId+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrName+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].spDate+'</td>';
		  			html += '<td style="text-align: center;">'+numberFormat(data[i].spPay)+'원</td>';
		  			html += '<td style="text-align: center;">'+data[i].spRegDate+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].spWriter+'</td>';
		  			html += '</tr>'
					
					$("#searchPayList2").empty();
					$("#searchPayList2").append(html);		
					};		
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				
	 	}));	 
	 
	 	//직원 월별 조회
	 	$(document).on('change', '#pRTitle',(function(){
	 		var pRTitle = $('select[name=pRTitle] option:selected').val();
	 		var request = $.ajax({
					url: "/monthOffiPay",
					method: "POST",
					data: {	pRTitle : pRTitle },
					dataType: "json"
				});
				request.done(function(data){
					html = '';
					
					for(var i=0; i<data.length; i++){
					
					html += '<tr>';
					html += '<td style="text-align: center;">'+data[i].opCode+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrId+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrName+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opDate+'</td>';
		  			html += '<td style="text-align: center;">'+numberFormat(data[i].opPay)+'원</td>';
		  			html += '<td style="text-align: center;">'+data[i].opRegDate+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opWriter+'</td>';
		  			html += '</tr>'
					
					$("#searchPayList").empty();
					$("#searchPayList").append(html);		
					};		
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				
	 	}));
	 		 
	 	//강사 미지급목록 조회
	 	$(document).on('click', '#nonPay',(function(){
	 		var request = $.ajax({
					url: "/nonStaffPay",
					method: "POST",
					dataType: "json"
				});
				request.done(function(data){
					html = '';
					
					for(var i=0; i<data.length; i++){
					
					html += '<tr>';
					html += '<td style="text-align: center;">'+data[i].spCode+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrId+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrName+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].spDate+'</td>';
		  			html += '<td style="text-align: center;">'+numberFormat(data[i].spPay)+'원</td>';
		  			html += '<td style="text-align: center;">'+data[i].spRegDate+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].spWriter+'</td>';
		  			html += '</tr>'
					
					$("#searchPayList2").empty();
					$("#searchPayList2").append(html);		
					};		
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				
	 	}));
	 	
	 	//직원 미지급목록 조회
	 	$(document).on('click', '#nonPay',(function(){
	 		var request = $.ajax({
					url: "/nonOffiPay",
					method: "POST",
					dataType: "json"
				});
				request.done(function(data){
					html = '';
					
					for(var i=0; i<data.length; i++){
					
					html += '<tr>';
					html += '<td style="text-align: center;">'+data[i].opCode+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrId+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrName+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opDate+'</td>';
		  			html += '<td style="text-align: center;">'+numberFormat(data[i].opPay)+'원</td>';
		  			html += '<td style="text-align: center;">'+data[i].opRegDate+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opWriter+'</td>';
		  			html += '</tr>'
					
					$("#searchPayList").empty();
					$("#searchPayList").append(html);		
					};		
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				
	 	}));
	 
	 	//직원급여검색
	 	$(document).on('click', '#offiSearchBtn', (function(){

			var offisk = $('select[name=offisk] option:selected').val();
			var offisv = $('input[name=offisv]').val();
			var request = $.ajax({
					url: "/getSearchOPL",
					method: "POST",
					data: {	  offisk : offisk	
							, offisv : offisv },
					dataType: "json"
				});
				request.done(function(data){
					html = '';
					
					for(var i=0; i<data.length; i++){
					
					html += '<tr>';
					html += '<td style="text-align: center;">'+data[i].opCode+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrId+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrName+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opDate+'</td>';
		  			html += '<td style="text-align: center;">'+numberFormat(data[i].opPay)+'원</td>';
		  			html += '<td style="text-align: center;">'+data[i].opRegDate+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opWriter+'</td>';
		  			html += '</tr>'
					
					$("#searchPayList").empty();
					$("#searchPayList").append(html);		
					};		
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
				
	 	})); 
	 	
	 	//강사 급여 검색
	 	$(document).on('click', '#staffSearchBtn', (function(){

			var staffsk = $('select[name=staffsk] option:selected').val();
			var staffsv = $('input[name=staffsv]').val();
			var request = $.ajax({
					url: "/getSearchSPL",
					method: "POST",
					data: {	  staffsk : staffsk	
							, staffsv : staffsv },
					dataType: "json"
				});
				request.done(function(data){
					html = '';
					
					for(var i=0; i<data.length; i++){
					
	  				html += '<tr>';
	  				html += '<td style="text-align: center;">'+data[i].spCode+'</td>';
	  				html += '<td style="text-align: center;">'+data[i].mrId+'</td>';
	  				html += '<td style="text-align: center;">'+data[i].mrName+'</td>';
	  				html += '<td style="text-align: center;">'+data[i].spDate+'</td>';
	  				html += '<td style="text-align: center;">'+numberFormat(data[i].spPay)+'원</td>';
	  				html += '<td style="text-align: center;">'+data[i].spRegDate+'</td>';
	  				html += '<td style="text-align: center;">'+data[i].spWriter+'</td>';
	  				html += '</tr>';
					
					$("#searchPayList").empty();
					$("#searchPayList").append(html);		
					};		
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
	 	})); 
	 	
	 	

	 });