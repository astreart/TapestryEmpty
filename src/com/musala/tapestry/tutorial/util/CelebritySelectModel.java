package com.musala.tapestry.tutorial.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.OptionGroupModel;
import org.apache.tapestry5.OptionModel;
import org.apache.tapestry5.util.AbstractSelectModel;

import com.musala.tapestry.tutorial.model.Celebrity;

public class CelebritySelectModel extends AbstractSelectModel {
	private List <Celebrity>celebrities;

	public CelebritySelectModel(List<Celebrity> celebrities) {
		this.celebrities = celebrities;
	}

	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		List<OptionModel> list = new ArrayList<OptionModel>();
		for (Celebrity c : celebrities) {
			list.add(new CelebrityOptionModel(c));
		}
		return list;
	}
}