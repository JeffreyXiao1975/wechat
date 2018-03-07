package com.xyh.wechat.web.controller.subscription;

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

import com.xyh.wechat.service.subscription.ISubscriptionAccountService;
import com.xyh.wechat.vo.subscription.SubscriptionAccountVo;
import com.xyh.wechat.web.controller.BaseController;
import com.xyh.wechat.web.model.subscription.SubscriptionAccountCriteriaModel;

@Controller
@RequestMapping("/subscription")
public class SubscriptionAccountController extends BaseController {
	@Autowired
	ISubscriptionAccountService subscriptionAccountService;
	
	@RequestMapping(value="/subscriptionmain", method=RequestMethod.GET)
	public void initSubscriptionAccountForm(ModelMap model) {
		SubscriptionAccountCriteriaModel queryModel = new SubscriptionAccountCriteriaModel();
		queryModel.setDisabled(false);
		queryModel.setDeleted(false);
		this.querySubscriptionAccount(queryModel, model, null);
	}
	
	@RequestMapping(value="/subscriptionmain", method=RequestMethod.POST)
	public ModelAndView postSubscriptionAccountForm(HttpSession httpSession, @ModelAttribute("subscriptionAccountCriteriaModel") @Valid SubscriptionAccountCriteriaModel queryModel, BindingResult result, ModelMap model) {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("/subscription/subscriptionmain");
		this.querySubscriptionAccount(queryModel, model, mv);
		return mv;
	}
	
	private void querySubscriptionAccount(SubscriptionAccountCriteriaModel queryModel, ModelMap model, ModelAndView mv) {
		List<SubscriptionAccountVo> subscriptionAccountVos = null;
		
		subscriptionAccountVos = subscriptionAccountService.getAllSubscriptionAccounts(queryModel.isDisabled(), queryModel.isDeleted());
		queryModel.setSubscriptionAccountList(subscriptionAccountVos);
		model.addAttribute("subscriptionAccountCriteriaModel", queryModel);
	}
}
