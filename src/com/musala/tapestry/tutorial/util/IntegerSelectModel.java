package com.musala.tapestry.tutorial.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;

public class IntegerSelectModel extends AbstractSelectModel {
	private List<OptionModel> options = new ArrayList<OptionModel>();

	public IntegerSelectModel(int numFrom, int numTo) {
		int increment = numTo > numFrom ? 1 : -1;
		for (int i = numFrom; i <= numTo; i += increment) {
			options.add(new IntegerOptionModel(i));
		}
	}

	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		return options;
	}
}
