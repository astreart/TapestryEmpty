package com.musala.tapestry.tutorial.services;

import java.math.BigInteger;
import com.musala.tapestry.tutorial.data.*;

import java.security.SecureRandom;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.services.ApplicationDefaults;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.services.ApplicationStateContribution;
import org.apache.tapestry5.services.ApplicationStateCreator;
import org.apache.tapestry5.services.BeanBlockContribution;
import org.apache.tapestry5.services.BeanBlockOverrideSource;
import org.apache.tapestry5.services.DisplayBlockContribution;

public class ControlAppModule {

	@Contribute(SymbolProvider.class)
	@ApplicationDefaults
	public static void contributeApplicationDefaults(
			MappedConfiguration<String, String> configuration) {
		configuration.add(SymbolConstants.MINIFICATION_ENABLED, "false");
		// configuration.add(SymbolConstants.CHARSET, "windows-1251");
		configuration.add(SymbolConstants.HMAC_PASSPHRASE, new BigInteger(130,
				new SecureRandom()).toString(32));
		configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
		configuration.add("tapestry.supported-locales", "en,de");
	}

	public static void bind(ServiceBinder binder) {
		binder.bind(SupportedLocales.class, SupportedLocalesImpl.class);
	}

	/*
	 * @Contribute(BeanBlockOverrideSource.class) public static void
	 * overridePropertyBlocks( Configuration<BeanBlockContribution>
	 * configuration) { configuration.add(new DisplayBlockContribution("date",
	 * "system/AppPropertyDisplayBlocks", "dateBlock")); }
	 */

	public void contributeApplicationStateManager(
			MappedConfiguration<Class, ApplicationStateContribution> configuration) {
		ApplicationStateCreator<IDataSource> creator = new ApplicationStateCreator<IDataSource>() {
			public IDataSource create() {
				return new MockDataSource();
			}
		};
		configuration.add(IDataSource.class, new ApplicationStateContribution(
				"session", creator));
	}
	// public boolean equals(Object object){
	// return super.equals(object);
	// }
	//
	// public String toString(){
	// return super.toString();
	// }
}
