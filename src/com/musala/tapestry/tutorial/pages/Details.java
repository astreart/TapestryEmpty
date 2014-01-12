package com.musala.tapestry.tutorial.pages;

import java.text.Format;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.SessionState;

import com.musala.tapestry.tutorial.data.IDataSource;
import com.musala.tapestry.tutorial.data.MockDataSource;
import com.musala.tapestry.tutorial.model.Celebrity;
import com.musala.tapestry.tutorial.util.Formats;

public class Details {

	// @Persist
	// private Celebrity celebrity;

	@SessionState
	private IDataSource dataSource;
	//private MockDataSource dataSource;
	private Celebrity celebrity;

	void onActivate(long id) {
		celebrity = dataSource.getCelebrityById(id);
	}

	public void setCelebrity(Celebrity c) {
		this.celebrity = c;
	}

	public Celebrity getCelebrity() {
		return celebrity;
	}

	public Format getDateFormat() {
		return Formats.getDateFormat();
	}

}
