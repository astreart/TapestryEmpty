package com.musala.tapestry.tutorial.pages;

import java.text.Format;

import org.apache.tapestry5.annotations.Persist;

import com.musala.tapestry.tutorial.model.Celebrity;
import com.musala.tapestry.tutorial.util.Formats;

public class Details {

	@Persist
	private Celebrity celebrity;

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
