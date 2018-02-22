package com.xyh.wechat.web.validator.pub;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xyh.wechat.web.model.pub.UserModel;

@Component("userValidator")
public class UserValidator implements Validator {
	public boolean supports(Class<?> arg0) {
		return UserModel.class.isAssignableFrom(arg0);
	}

	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "login.username.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "login.password.required");		
	}
}
