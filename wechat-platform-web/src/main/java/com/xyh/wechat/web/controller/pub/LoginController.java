package com.xyh.wechat.web.controller.pub;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xyh.wechat.service.platform.IPlatformUserService;
import com.xyh.wechat.web.controller.BaseController;
import com.xyh.wechat.web.model.pub.LoginModel;
import com.xyh.wechat.web.validator.pub.LoginValidator;

@Controller
@RequestMapping("/public/login")
public class LoginController extends BaseController {
	@Autowired
	private IPlatformUserService platformUserService;
	
	@InitBinder  
	public void initBinder(DataBinder binder) {  
		binder.setValidator(new LoginValidator());  
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(ModelMap model){
		LoginModel user = new LoginModel();
		model.addAttribute("user", user);		
		return "/public/login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(HttpSession httpSession, @ModelAttribute("user") @Valid LoginModel user, BindingResult result, ModelMap model) {		
		
		if (!result.hasFieldErrors()) {
			if (platformUserService != null) {
				boolean authenticated = platformUserService.authenticateUser(user.getUsername(), user.getPassword());
				if (!authenticated) {
					result.rejectValue("username", "login.loginfailed");
				}
			}
		}
		
		if (result.hasErrors()) return "/public/login";
		httpSession.setAttribute("user", user);
		return "/common/main";
	}
}
