package com.xyh.wechat.web.validator.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.xyh.wechat.web.model.service.ServiceAccountModel;

public class ServiceAccountValidator implements Validator {
	public boolean supports(Class<?> arg0) {
		return ServiceAccountModel.class.isAssignableFrom(arg0);
	}

	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "legalEntityId", "wechat.service.account.le.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountName", "wechat.service.account.name.required");	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountDesc", "wechat.service.account.desc.required");
		
		ServiceAccountModel serviceAccountModel = (ServiceAccountModel) command;
		if (serviceAccountModel.getLegalEntityId() == 0) {
			errors.rejectValue("legalEntityId", "wechat.service.account.le.required");
		}
	}
}
