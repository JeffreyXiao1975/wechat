package com.xyh.wechat.web.controller.common;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xyh.wechat.web.controller.BaseController;

/*
 * 
 */
@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {
	@RequestMapping("/main")
	public void main() {
		
	}
	
	@RequestMapping("/menu")
	public void menu() {
		
	}
	
	@RequestMapping("/help")
	public void help() {
		
	}
	
	@RequestMapping("/welcome")
	public void welcome() {
		
	}
}
