package no.hib.dat152;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class LocaleService {
	public static ResourceBundle getLabels(HttpServletRequest request) {
		String userLocale = (String) request.getSession().getAttribute("userLocale");
		if (userLocale.equals("")) {
			Locale locale = request.getLocale();
			return ResourceBundle.getBundle("Labels", locale);
		} else {
			return ResourceBundle.getBundle("Labels", new Locale("userLocale"));
		}
	}
}
