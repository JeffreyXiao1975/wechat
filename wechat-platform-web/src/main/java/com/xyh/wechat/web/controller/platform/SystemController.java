package com.xyh.wechat.web.controller.platform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SystemController {
	@RequestMapping(value="/platform/systemSetting", method=RequestMethod.GET)
	public void initSystemSettingForm(ModelMap model) {
		
	}
}
