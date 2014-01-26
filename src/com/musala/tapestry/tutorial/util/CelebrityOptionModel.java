package com.musala.tapestry.tutorial.util;

import java.util.Map;

import org.apache.tapestry5.OptionModel;

import com.musala.tapestry.tutorial.model.Celebrity;

public class CelebrityOptionModel implements OptionModel {
	private Celebrity celebrity;

	public CelebrityOptionModel(Celebrity celebrity) {
		this.celebrity = celebrity;
	}

	public String getLabel() {
		return celebrity.getFirstName() + " " + celebrity.getLastName();
	}

	public boolean isDisabled() {
		return false;
	}

	public Map<String, String> getAttributes() {
		return null;
	}

	public Object getValue() {
		return celebrity;
	}
}