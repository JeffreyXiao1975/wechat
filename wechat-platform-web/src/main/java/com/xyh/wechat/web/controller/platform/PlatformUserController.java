package com.xyh.wechat.web.controller.platform;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xyh.wechat.service.platform.IPlatformUserService;
import com.xyh.wechat.util.WeChatPlatformConstants;
import com.xyh.wechat.util.WeChatPlatformMath;
import com.xyh.wechat.vo.platform.PlatformUserVo;
import com.xyh.wechat.web.controller.BaseController;
import com.xyh.wechat.web.model.platform.PlatformUserCriteriaModel;
import com.xyh.wechat.web.model.platform.PlatformUserModel;

@Controller
public class PlatformUserController extends BaseController {
	@Autowired
	IPlatformUserService platformUserService;
		
	@RequestMapping(value="/platform/platformUserSetting", method=RequestMethod.GET)
	public void initQueryUserForm(ModelMap model) {
		PlatformUserCriteriaModel platformUserCriteriaModel = new PlatformUserCriteriaModel();
		platformUserCriteriaModel.setUsername("");
		platformUserCriteriaModel.setCurrentPageNumber(1);
		platformUserCriteriaModel.setFirstPage(true);
		platformUserCriteriaModel.setLastPage(true);
		platformUserCriteriaModel.setPageSize(WeChatPlatformConstants.pageSize);
		this.QueryPlatformUsers(platformUserCriteriaModel, model, null);
	}
	
	@RequestMapping(value="/platform/platformUserSetting", method=RequestMethod.POST)
	public ModelAndView postQueryUserForm(HttpSession httpSession, @ModelAttribute("platformUserCriteriaModel") @Valid PlatformUserCriteriaModel platformUserCriteriaModel, BindingResult result, ModelMap model) {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("/platform/platformUserSetting");
		this.QueryPlatformUsers(platformUserCriteriaModel, model, mv);
		return mv;
	}
	
	@RequestMapping(value="/platform/createPlatformUser", method=RequestMethod.GET)
	public void initCreateUserForm(ModelMap model) {
		
	}
	
	@RequestMapping(value="/platform/createPlatformUser", method=RequestMethod.POST)
	public String postCreateUserForm(HttpSession httpSession, @ModelAttribute("platformUserModel") @Valid PlatformUserModel userModel, BindingResult result, ModelMap model) {
		return "";
	}
	
	@RequestMapping(value="/platform/viewPlatformUser", method=RequestMethod.GET)
	public void initViewUserForm(HttpServletRequest request, ModelMap model) {
		
	}
	
	@RequestMapping(value="/platform/updatePlatformUser", method=RequestMethod.GET)
	public void initUpdateUserForm(HttpServletRequest request, ModelMap model) {
		
	}
	
	@RequestMapping(value="/platform/updatePlatformUser", method=RequestMethod.POST)
	public void postUpdateUserForm(HttpSession httpSession, @ModelAttribute("platformUserModel") @Valid PlatformUserModel userModel, BindingResult result, ModelMap model) {
		
	}
	
	private void QueryPlatformUsers(PlatformUserCriteriaModel platformUserCriteriaModel, ModelMap model, ModelAndView mv) {
		long totalUserCount = 0;
		List<PlatformUserVo> queryPlatformUserResult = null;
		
		totalUserCount = platformUserService.queryPlatformUserCount(platformUserCriteriaModel);		
		queryPlatformUserResult = platformUserService.queryPlatformUsers(platformUserCriteriaModel);
		if (totalUserCount > 0) {
			platformUserCriteriaModel.setTotalPageNumber(WeChatPlatformMath.GetTotalPageNumber(totalUserCount, platformUserCriteriaModel.getPageSize()));
			platformUserCriteriaModel.setCurrentPageNumber(1);
			platformUserCriteriaModel.setFirstPage(true);
			platformUserCriteriaModel.setLastPage(false);
			platformUserCriteriaModel.setPageSize(WeChatPlatformConstants.pageSize);
		} else {
			platformUserCriteriaModel.setCurrentPageNumber(1);
			platformUserCriteriaModel.setFirstPage(true);
			platformUserCriteriaModel.setLastPage(true);
			platformUserCriteriaModel.setPageSize(WeChatPlatformConstants.pageSize);
		}
		platformUserCriteriaModel.setUserlist(queryPlatformUserResult);
		model.addAttribute("platformUserCriteriaModel", platformUserCriteriaModel);
	}

}
