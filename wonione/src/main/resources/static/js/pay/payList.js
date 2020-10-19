/**
 * 2020-10-15 새로 생성
 * 
 * 
 * 
 */
 
	 $(function(){	
	 
	 	//미지급목록 조회
	 	$(#nonPay).click(function(){
	 		var opDate = 
	 	});
	 
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
		  			html += '<td style="text-align: center;">'+data[i].opPay+'</td>';
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
	  				html += '<td style="text-align: center;">'+data[i].spPay+'</td>';
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