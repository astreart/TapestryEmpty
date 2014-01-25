package com.musala.tapestry.tutorial.components;

import java.util.Locale;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

import com.musala.tapestry.tutorial.pages.AddCelebrity;
import com.musala.tapestry.tutorial.pages.Index;
import com.musala.tapestry.tutorial.pages.Registration;
import com.musala.tapestry.tutorial.pages.ShowAll;

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

	@Inject
	private ComponentResources resources;

	public String getPageName() {
		org.apache.tapestry5.runtime.Component page = resources.getContainer();
		return page.getClass().getName();
	}

	public boolean isNotIndex() {
		return !getPageName().equals(Index.class.getName());
	}

	public boolean isRegistration() {
		return getPageName().equals(Registration.class.getName());
	}

	public boolean isShowAll() {
		return getPageName().equals(ShowAll.class.getName());
	}

	public boolean isAddCelebrity() {
		return getPageName().equals(AddCelebrity.class.getName());
	}

	@Parameter(required = true, defaultPrefix = "literal")
	private String pageTitle;

	public String getPageTitle() {
		return pageTitle;
	}

}
