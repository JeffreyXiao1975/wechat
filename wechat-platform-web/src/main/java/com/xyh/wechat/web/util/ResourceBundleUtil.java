package com.xyh.wechat.web.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class ResourceBundleUtil {	
	public static String getMessage(HttpServletRequest request, String messageKey) {
		ResourceBundle resourceBundle = null;
		
		if (request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME) == null) {
			resourceBundle = ResourceBundle.getBundle("messages", Locale.PRC);
		} else {
			Locale locale = (Locale) request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
			resourceBundle = ResourceBundle.getBundle("messages", locale);
		}
		
		return resourceBundle.getString(messageKey);
	}

}
