(function ($) {
 "use strict";

	/*----------------------------
	 jQuery MeanMenu
	------------------------------ */
	jQuery('nav#dropdown').meanmenu();	
	/*----------------------------
	 jQuery myTab
	------------------------------ */
	$('#myTab a').on('click', function (e) {
		  e.preventDefault()
		  $(this).tab('show')
		});
		$('#myTab3 a').on('click', function (e) {
		  e.preventDefault()
		  $(this).tab('show')
		});
		$('#myTab4 a').on('click', function (e) {
		  e.preventDefault()
		  $(this).tab('show')
		});
		$('#myTabedu1 a').on('click', function (e) {
		  e.preventDefault()
		  $(this).tab('show')
		});

	  $('#single-product-tab a').on('click', function (e) {
		  e.preventDefault()
		  $(this).tab('show')
		});
	
	$('[data-toggle="tooltip"]').tooltip(); 
	
	$('#sidebarCollapse').on('click', function () {
		 $('#sidebar').toggleClass('active');
	 });
	// Collapse ibox function
	$('#sidebar ul li').on('click', function () {
		var button = $(this).find('i.fa.indicator-mn');
		button.toggleClass('fa-plus').toggleClass('fa-minus');
		
	});
	/*-----------------------------
		Menu Stick
	---------------------------------*/
	$(".sicker-menu").sticky({topSpacing:0});
		
	$('#sidebarCollapse').on('click', function () {
		$("body").toggleClass("mini-navbar");
		SmoothlyMenu();
	});
	$(document).on('click', '.header-right-menu .dropdown-menu', function (e) {
		  e.stopPropagation();
	});
	/*----------------------------
	 wow js active
	------------------------------ */
	 new WOW().init();
	/*----------------------------
	 owl active
	------------------------------ */  
	$("#owl-demo").owlCarousel({
      autoPlay: false, 
	  slideSpeed:2000,
	  pagination:false,
	  navigation:true,	  
      items : 4,
	  /* transitionStyle : "fade", */    /* [This code for animation ] */
	  navigationText:["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"],
      itemsDesktop : [1199,4],
	  itemsDesktopSmall : [980,3],
	  itemsTablet: [768,2],
	  itemsMobile : [479,1],
	});
	/*----------------------------
	 price-slider active
	------------------------------ */  
	  $( "#slider-range" ).slider({
	   range: true,
	   min: 40,
	   max: 600,
	   values: [ 60, 570 ],
	   slide: function( event, ui ) {
		$( "#amount" ).val( "£" + ui.values[ 0 ] + " - £" + ui.values[ 1 ] );
	   }
	  });
	  $( "#amount" ).val( "£" + $( "#slider-range" ).slider( "values", 0 ) +
	   " - £" + $( "#slider-range" ).slider( "values", 1 ) );
	/*--------------------------
	 scrollUp
	---------------------------- */	
	$.scrollUp({
        scrollText: '<i class="fa fa-angle-up"></i>',
        easingType: 'linear',
        scrollSpeed: 900,
        animation: 'fade'
    });
	//상담등록
	$('#addconsultingbtn').click(function(){
		var addconsulting = $('#addconsulting');
		addconsulting.submit();
		
	});
	//상담수정
	$('#upConsulting').click(function(){
		var upconsulting = $('#upConsultingList');
		upconsulting.submit();
		
	});
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
				$('#consultingTeacher').attr('value',data.mr_o_id);
				$('#consultingStudent').attr('value',data.cs_lec_name);
				$('#consultingLecName').attr('value',data.cs_s_name);
				$('#consultingData').attr('value',data.cs_data);
				textareaVal.text(data.cs_data);
				
			
				
			});
			request.fail(function( jqXHR, textStatus ) {
				if (jqXHR.status === 0) {
		            alert('Not connect.\n Verify Network.');
		        } 
		        else if (jqXHR.status == 400) {
		            alert('Server understood the request, but request content was invalid. [400]');
		        } 
		        else if (jqXHR.status == 401) {
		            alert('Unauthorized access. [401]');
		        } 
		        else if (jqXHR.status == 403) {
		            alert('Forbidden resource can not be accessed. [403]');
		        } 
		        else if (jqXHR.status == 404) {
		            alert('Requested page not found. [404]');
		        } 
		        else if (jqXHR.status == 500) {
		            alert('Internal server error. [500]');
		        } 
		        else if (jqXHR.status == 503) {
		            alert('Service unavailable. [503]');
		        } 
		        else if (exception === 'parsererror') {
		            alert('Requested JSON parse failed. [Failed]');
		        } 
		        else if (exception === 'timeout') {
		            alert('Time out error. [Timeout]');
		        } 
		        else if (exception === 'abort') {
		            alert('Ajax request aborted. [Aborted]');
		        } 
		        else {
		            alert('Uncaught Error.n' + jqXHR.responseText);
		        }
			});
	});
 	
 
 
})(jQuery); 