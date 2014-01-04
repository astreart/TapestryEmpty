function init(){
	$('a.ajax').click(loadPage);//For
	
	collapsibleFieldsets('collapsible');
	
	$('.datepicker').datepicker({
			language: 'bg', 
			weekStart: 1, 
			format: 'dd.mm.yyyy'
	}).on('changeDate', function(ev){
		$('.datepicker').datepicker('hide');
	});
	
	$("select.ext").select2({
		width: 'copy'
	});
	
//	$(".section").corner("10px");
//	$(".btn").corner("5px");
//	$(".label").corner("3px");
}

function loadPage(){
	if(this.href){
		link = this.href;
	}else{
		link = this.location.href;
	}
	var hash = link.substring(link.indexOf('#')+1);
	var type = hash.substring(hash.lastIndexOf('.')+1);
	
	if(!hash){
		return;
	}
	
	if(type == 'html'){
		$.ajax({
			url: 'mockups/' + hash,
			'beforeSend' : function(xhr) {
				xhr.overrideMimeType('text/html;charset=windows-1251');
			},
			success: function(data){
				$('#content').html(data);
				init();
			}
		});
		
	}else{
		var imgTag = '<img style="float:right; width: 900px" src="mockups/' + hash + '.png"/>';
		$('#content').html(imgTag);
	}
}

// служи за mixins Confirm
(function ($){
	T5.extendInitializers(function(){
			function confirmation(spec){
				$("#"+spec.elementId).bind("click", function(event){
					if(!confirm(spec.confirmationMessage))
						event.preventDefault();
						event.stopPropagation();
				});
			}
			return { confirmation : confirmation}
	});
}) (jQuery);

(function ($){
	T5.extendInitializers(function(){
			function addPopover(spec){
				
				$("#" + spec.elementId).live('click', function(event) {
					
					event.preventDefault();
					event.stopPropagation();
					
					if ($("#" + spec.elementId).attr('popup-status') == 'visible') {
						$("#" + spec.elementId).popover('hide');
						$("#" + spec.elementId).attr('popup-status', 'hidden');
					} else {
						if (spec.popovercontent != "undefined") {
							
							$("#" + spec.elementId).popover({
								placement: spec.popoverplacement,
								html: true,
								content: spec.popovercontent,
								title: spec.popovertitle
							}).popover('show');
						} else {
							$.ajax({
								type: 'GET',
								url: $("#" + spec.elementId).attr('href'),
								dataType: 'html',
								success: function(content) {
									$("#" + spec.elementId).popover({
										placement: spec.popoverplacement,
										html: true,
										content: content,
										title: spec.popovertitle
									}).popover('show');
								}
							});
						}
						
						$("#" + spec.elementId).attr('popup-status', 'visible');
					}
					
				});
			}
			return { addPopover : addPopover}
	});
}) (jQuery);