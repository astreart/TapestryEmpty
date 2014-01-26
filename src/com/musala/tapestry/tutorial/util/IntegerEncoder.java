package com.musala.tapestry.tutorial.util;

import org.apache.tapestry5.ValueEncoder;

public class IntegerEncoder implements ValueEncoder {
	
	public String toClient(Object i) {
		return i.toString();
	}

	public Object toValue(String s) {
		return new Integer(s);
	}
}