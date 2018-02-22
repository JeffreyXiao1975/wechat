package com.xyh.wechat.web.controller.pub;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xyh.wechat.web.controller.BaseController;
import com.xyh.wechat.web.model.pub.UserModel;

@Controller
public class PublicController extends BaseController {
	@RequestMapping("/public/filenotfound")
	public void filenotfound() {
		
	}
	
	@RequestMapping("/public/accessdenied")
	public void accessdenied() {
		
	}
	
	@RequestMapping(value="/public/resetpassword", method=RequestMethod.GET)
	public void resetpassword(ModelMap model) {
		UserModel userModel = new UserModel();
		userModel.setUsername("");
		userModel.setPassword("");
		model.addAttribute("userModel", userModel);
	}
}
