package com.musala.tapestry.tutorial.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;
import com.musala.tapestry.tutorial.data.IDataSource;
import  com.musala.tapestry.tutorial.model.Celebrity;

public class AddCelebrity {

	@SessionState
	private IDataSource dataSource;

	@Persist
	private Celebrity celebrity;

	/*Object onSubmitFromCelebrity() {
		dataSource.addCelebrity(celebrity);
		return ShowAll.class;
	}*/

	public Celebrity getCelebrity() {
		return celebrity;
	}

	public void setCelebrity(Celebrity celebrity) {
		this.celebrity = celebrity;
	
	}
}
