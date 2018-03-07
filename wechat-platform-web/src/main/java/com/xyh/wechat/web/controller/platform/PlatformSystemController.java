package com.xyh.wechat.web.controller.platform;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlatformSystemController {
	@RequestMapping(value="/platform/platformSystemSetting", method=RequestMethod.GET)
	public void initSystemSettingForm(ModelMap model) {
		
	}
}
