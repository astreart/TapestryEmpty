package com.musala.tapestry.tutorial.components;

import java.util.Locale;

import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

import com.musala.tapestry.tutorial.services.SupportedLocales;
import com.musala.tapestry.tutorial.util.LocaleEncoder;
import com.musala.tapestry.tutorial.util.LocaleSelectModel;

public class LocaleSwitcher {

	/*@Parameter(defaultPrefix = "literal", required = true)
	private String supportedLocales;*/
	@Inject
	private SupportedLocales supportedLocales;
	
	@Inject
	private PersistentLocale persistentLocale;

	public Locale getSelectedLocale() {
		return persistentLocale.get();
	}

	public void setSelectedLocale(Locale selectedLocale) {
		persistentLocale.set(selectedLocale);
	}

	public SelectModel getLocaleModel() {
		return new LocaleSelectModel(supportedLocales.getSupportedLocales());
	}

	public ValueEncoder getLocaleEncoder() {
		return new LocaleEncoder();
	}
}