//adds support for all multiple selects with first option <option value="all"...>...
var all;          //flag for the state of the "all" option
var change;     //prevents going into endless loops caused by on change  


$('select[multiple]').live("open", function(e) {
	if($("option:first",this).val()=="all"){ //execute only for selects with first option value all
		if($("option:selected:first",this).val()=="all")
			all=1; //allow on change to be executed
		else
			all=0; //all was not selected
		change=1;
	}
});

$('select[multiple]').live("change", function(e) {
	if($("option:first",this).val()=="all"){ //execute only for selects with first option value all
		if($("option:selected",this).val()==undefined){
			change=0;
			$(this).find('option[value="all"]').prop('selected', true);
			$(this).select2().trigger('change');
		}else
		if(change==1){// don't execute if there was no open event after the last on change
		change=0; 
		if(all==1){
			//remove all as something else was selected
			$(this).find('option[value="all"]').prop('selected', false);
 			$(this).select2().trigger('change');
		}else
			if($("option:selected:first",this).val()=="all"){
				//remove everything but all option as it was selected in the last on change
				$(this).find('option').prop('selected', false);
	 			$(this).find('option[value="all"]').prop('selected', true);
	 			$(this).select2().trigger('change');
			}
		}	
	}
});