package com.xyh.wechat.web.controller.platform;

import java.util.List;

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
import com.xyh.wechat.web.model.platform.QueryPlatformUserCriteriaModel;

@Controller
public class UserController extends BaseController {
	@Autowired
	IPlatformUserService platformUserService;
		
	@RequestMapping(value="/platform/queryUser", method=RequestMethod.GET)
	public void initQueryForm(ModelMap model) {
		QueryPlatformUserCriteriaModel queryPlatformUserCriteriaModel = new QueryPlatformUserCriteriaModel();
		queryPlatformUserCriteriaModel.setUsername("");
		queryPlatformUserCriteriaModel.setCurrentPageNumber(1);
		queryPlatformUserCriteriaModel.setFirstPage(true);
		queryPlatformUserCriteriaModel.setLastPage(true);
		queryPlatformUserCriteriaModel.setPageSize(WeChatPlatformConstants.pageSize);
		this.QueryPlatformUser(queryPlatformUserCriteriaModel, model, null);
	}
	
	@RequestMapping(value="/platform/queryUser", method=RequestMethod.POST)
	public ModelAndView queryUser(HttpSession httpSession, @ModelAttribute("queryPlatformUserCriteriaModel") @Valid QueryPlatformUserCriteriaModel queryPlatformUserCriteriaModel, BindingResult result, ModelMap model) {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("/platform/queryUser");
		this.QueryPlatformUser(queryPlatformUserCriteriaModel, model, mv);
		return mv;
	}
	
	private void QueryPlatformUser(QueryPlatformUserCriteriaModel queryPlatformUserCriteriaModel, ModelMap model, ModelAndView mv) {
		long totalUserCount = 0;
		List<PlatformUserVo> queryPlatformUserResult = null;
		
		totalUserCount = platformUserService.queryPlatformUserCount(queryPlatformUserCriteriaModel);		
		queryPlatformUserResult = platformUserService.queryPlatformUsers(queryPlatformUserCriteriaModel);
		if (totalUserCount > 0) {
			queryPlatformUserCriteriaModel.setTotalPageNumber(WeChatPlatformMath.GetTotalPageNumber(totalUserCount, queryPlatformUserCriteriaModel.getPageSize()));
			queryPlatformUserCriteriaModel.setCurrentPageNumber(1);
			queryPlatformUserCriteriaModel.setFirstPage(true);
			queryPlatformUserCriteriaModel.setLastPage(false);
			queryPlatformUserCriteriaModel.setPageSize(WeChatPlatformConstants.pageSize);
		} else {
			queryPlatformUserCriteriaModel.setCurrentPageNumber(1);
			queryPlatformUserCriteriaModel.setFirstPage(true);
			queryPlatformUserCriteriaModel.setLastPage(true);
			queryPlatformUserCriteriaModel.setPageSize(WeChatPlatformConstants.pageSize);
		}
		queryPlatformUserCriteriaModel.setUserlist(queryPlatformUserResult);
		model.addAttribute("queryPlatformUserCriteriaModel", queryPlatformUserCriteriaModel);
	}

}
