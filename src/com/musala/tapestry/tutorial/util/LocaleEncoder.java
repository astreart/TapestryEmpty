package com.musala.tapestry.tutorial.util;

import java.util.Locale;

import org.apache.tapestry5.ValueEncoder;

public class LocaleEncoder implements ValueEncoder {
	public String toClient(Object obj) {
		Locale loc = (Locale) obj;
		return loc.getLanguage();
	}

	public Object toValue(String str) {
		return new Locale(str);
	}
}