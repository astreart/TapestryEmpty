package com.musala.tapestry.tutorial.pages;

import org.apache.tapestry5.Asset;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.annotations.SupportsInformalParameters;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.musala.tapestry.tutorial.data.IDataSource;
import  com.musala.tapestry.tutorial.model.Celebrity;

@SupportsInformalParameters
@Import(stylesheet = { "context:css/styles.css" })

public class AddCelebrity {

	private Asset styles;

	@SessionState
	private IDataSource dataSource;

	public Asset getStyles() {
		return styles;
	}
	
	@Persist
	private Celebrity celebrity;

	/*Object onSubmitFromCelebrity() {
		dataSource.addCelebrity(celebrity);
		return ShowAll.class;
	}*/

	public Celebrity getCelebrity() {
		/*if(celebrity == null){
			this.celebrity = new Celebrity();
		}*/
		return celebrity;
	}

	public void setCelebrity(Celebrity celebrity) {
		this.celebrity = celebrity;
	}
}
