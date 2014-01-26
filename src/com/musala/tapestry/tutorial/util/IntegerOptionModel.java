package com.musala.tapestry.tutorial.util;

import java.util.Map;

import org.apache.tapestry5.OptionModel;

public class IntegerOptionModel implements OptionModel {
	private Number number;

	public IntegerOptionModel(Number num) {
		number = num;
	}

	public Map<String, String> getAttributes() {
		return null;
	}

	public String getLabel() {
		return "" + number;
	}

	public Object getValue() {
		return number;
	}

	public boolean isDisabled() {
		return false;
	}
}