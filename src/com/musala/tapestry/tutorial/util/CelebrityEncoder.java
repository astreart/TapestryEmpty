package com.musala.tapestry.tutorial.util;

import org.apache.tapestry5.ValueEncoder;

import com.musala.tapestry.tutorial.data.IDataSource;
import com.musala.tapestry.tutorial.model.Celebrity;

public class CelebrityEncoder implements ValueEncoder {
	private IDataSource source;

	public CelebrityEncoder(IDataSource source) {
		this.source = source;
	}

	public String toClient(Object obj) {
		return "" + ((Celebrity) obj).getId();
	}

	public Object toValue(String str) {
		return source.getCelebrityById(Integer.parseInt(str));
	}
}