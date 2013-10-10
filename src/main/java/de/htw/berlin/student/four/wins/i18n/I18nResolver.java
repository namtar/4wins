package de.htw.berlin.student.four.wins.i18n;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Helper class to resolve the internationalization strings.
 * 
 * @author Matthias Drummer
 */
public final class I18nResolver {

	/**
	 * Private constructor to prevent unwanted instantiation.
	 */
	private I18nResolver() {
	}

	/**
	 * Gets the resource string for the current locale.
	 * 
	 * @param key the key to get the internationalized string for
	 * @return the i18n string
	 */
	public static String getString(String key) {

		ResourceBundle bundle = PropertyResourceBundle.getBundle("i18n/I18N");
		if (bundle == null) {
			// load fallback bundle
			bundle = PropertyResourceBundle.getBundle("i18n/I18N", Locale.US);
		}

		return bundle.getString(key);
	}
}
