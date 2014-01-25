package com.musala.tapestry.tutorial.components;

import java.util.Locale;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

public class Border {
	@Inject
	private PersistentLocale persistentLocale;
	@Inject
	private Locale currentLocale;
	@Persist
	private String localeLabel;

	public String getLocaleLabel() {
		if (localeLabel == null) {
			Locale.setDefault(Locale.ENGLISH);
		}
		
		if (currentLocale.equals(Locale.GERMAN)) {
			localeLabel = new Locale("en").getDisplayName(Locale.ENGLISH);
		} else {
			localeLabel = new Locale("de").getDisplayName(Locale.GERMAN);
		}
		return localeLabel;
	}

	@OnEvent(component = "switchlocale")
	void changeLocale() {
		localeLabel = currentLocale.getDisplayName(currentLocale);
		if (currentLocale.equals(Locale.GERMAN)) {
			persistentLocale.set(Locale.ENGLISH);
		} else {
			persistentLocale.set(Locale.GERMAN);
		}
	}
}
