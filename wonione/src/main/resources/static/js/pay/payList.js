/**
 * 2020-10-15 새로 생성
 * 
 * 
 * 
 */
 
	 $(function(){	
	 	$(document).on('click', '.searchbtn', (function(){
	 		console.log('??????');
			var sk = $('select[name=sk] option:selected').val();
			var sv = $('input[name=sv]').val();
			var request = $.ajax({
					url: "/getSearchOPL",
					method: "POST",
					data: {	sk : sk	, sv : sv },
					dataType: "json"
				});
				request.done(function(data){
					html = '';
					
					for(var i=0; i<data.length; i++){
					if(data[i].opCode != undefined){
					html += '<tr>';
					html += '<td style="text-align: center;">'+data[i].opCode+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrId+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].mrName+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opDate+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opPay+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opRegDate+'</td>';
		  			html += '<td style="text-align: center;">'+data[i].opWriter+'</td>';
		  			html += '</tr>'
					}else{
	  				html += '<tr>';
	  				html += '<td style="text-align: center;">'+data[i].spCode+'</td>';
	  				html += '<td style="text-align: center;">'+data[i].mrId+'</td>';
	  				html += '<td style="text-align: center;">'+data[i].mrName+'</td>';
	  				html += '<td style="text-align: center;">'+data[i].spDate+'</td>';
	  				html += '<td style="text-align: center;">'+data[i].spPay+'</td>';
	  				html += '<td style="text-align: center;">'+data[i].spRegDate+'</td>';
	  				html += '<td style="text-align: center;">'+data[i].spWriter+'</td>';
	  				html += '</tr>';
					}
					$("#searchPayList").empty();
					$("#searchPayList").append(html);		
					};		
				});
				request.fail(function( jqXHR, textStatus ) {
					alert( "Request failed: " + textStatus );
				});	
	 	})); 
	 });