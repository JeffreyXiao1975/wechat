package com.xyh.wechat.web.controller;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	protected static Logger logger = Logger.getLogger(BaseController.class);
	
	@Resource(name="messageSource")
	protected MessageSource messageResource;
}
