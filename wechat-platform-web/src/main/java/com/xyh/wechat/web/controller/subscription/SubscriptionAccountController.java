package com.xyh.wechat.web.controller.subscription;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import com.xyh.wechat.convertor.subscription.SubscriptionAccountConvertor;
import com.xyh.wechat.service.platform.IPlatformLegalEntityService;
import com.xyh.wechat.service.subscription.ISubscriptionAccountService;
import com.xyh.wechat.vo.platform.PlatformLegalEntityVo;
import com.xyh.wechat.vo.subscription.SubscriptionAccountVo;
import com.xyh.wechat.web.controller.BaseController;
import com.xyh.wechat.web.model.subscription.SubscriptionAccountCriteriaModel;
import com.xyh.wechat.web.model.subscription.SubscriptionAccountModel;

@Controller
@RequestMapping("/subscription")
public class SubscriptionAccountController extends BaseController {
	@Autowired
	ISubscriptionAccountService subscriptionAccountService;
	
	@Autowired
	private IPlatformLegalEntityService platformLegalEntityService;
	
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
	
	@RequestMapping(value="/service/createSubscriptionAccount", method=RequestMethod.GET)
	public void initCreateSubscriptionAccountForm(ModelMap model) {
		model.addAttribute("subscriptionAccountModel", new SubscriptionAccountModel());
	}
	
	@RequestMapping(value="/service/createSubscriptionAccount", method=RequestMethod.POST)
	public String postCreateSubscriptionAccountForm(HttpSession httpSession, @ModelAttribute("subscriptionAccountModel") @Valid SubscriptionAccountModel subscriptionAccountModel, BindingResult result, ModelMap model) {
		SubscriptionAccountVo subscriptionAccountVo = SubscriptionAccountConvertor.convertToVo(subscriptionAccountModel);
		subscriptionAccountService.createSubscriptionAccount(subscriptionAccountVo);
		subscriptionAccountVo = subscriptionAccountService.getSubscriptionAccountbyName(subscriptionAccountVo.getAccountName());
		return "redirect:viewSubscriptionAccount.do?result=CreatedSuccessfully&id=" + subscriptionAccountVo.getId();
	}
	
	@RequestMapping(value="/service/viewSubscriptionAccount", method=RequestMethod.GET)
	public void initViewServiceAccountForm(HttpServletRequest request, ModelMap model) {
		this.initializeSubscriptionAccount(request, model);
	}
	
	@RequestMapping(value="/service/updateServiceAccount", method=RequestMethod.GET)
	public void initUpdateServiceAccountForm(HttpServletRequest request, ModelMap model) {
		this.initializeSubscriptionAccount(request, model);
	}
	
	@RequestMapping(value="/service/updateServiceAccount", method=RequestMethod.POST)
	public String postUpdateServiceAccountForm(@ModelAttribute("subscriptionAccountModel") @Valid SubscriptionAccountModel subscriptionAccountModel, BindingResult result, ModelMap model) {
		SubscriptionAccountVo subscriptionAccountVo = SubscriptionAccountConvertor.convertToVo(subscriptionAccountModel);
		subscriptionAccountService.updateSubscriptionAccount(subscriptionAccountVo);
		subscriptionAccountVo = subscriptionAccountService.getSubscriptionAccountbyId(subscriptionAccountVo.getId());
		return "redirect:viewSubscriptionAccount.do?result=CreatedSuccessfully&id=" + subscriptionAccountVo.getId();
	}
	
	private void querySubscriptionAccount(SubscriptionAccountCriteriaModel queryModel, ModelMap model, ModelAndView mv) {
		List<SubscriptionAccountVo> subscriptionAccountVos = null;
		
		subscriptionAccountVos = subscriptionAccountService.getAllSubscriptionAccounts(queryModel.isDisabled(), queryModel.isDeleted());
		queryModel.setSubscriptionAccountList(subscriptionAccountVos);
		model.addAttribute("subscriptionAccountCriteriaModel", queryModel);
	}
	
	@ModelAttribute("legalEntities")
	public Map<String, String> getLegalEntities() {
		List<PlatformLegalEntityVo> platformLegalEntityVos = null;
		Map<String, String> legalEntities = new HashMap<String, String>();
		
		platformLegalEntityVos = platformLegalEntityService.getAllLegalEntities(false, false);
		if (platformLegalEntityVos != null && platformLegalEntityVos.size() > 0) {
			Iterator<PlatformLegalEntityVo> iterator = platformLegalEntityVos.iterator();
			while (iterator.hasNext()) {
				PlatformLegalEntityVo platformLegalEntityVo = iterator.next();
				legalEntities.put(String.valueOf(platformLegalEntityVo.getId()), platformLegalEntityVo.getNameCN());
			}
		}

		return legalEntities;
	}
	
	private void initializeSubscriptionAccount(HttpServletRequest request, ModelMap model) {
		long accountId = 0;
		SubscriptionAccountVo subscriptionAccountVo = null;
		SubscriptionAccountModel subscriptionAccountModel = new SubscriptionAccountModel();

		if (model != null && model.get("subscriptionAccountModel") != null) {
			subscriptionAccountModel = (SubscriptionAccountModel) model.get("subscriptionAccountModel");
		} else {
			if (request.getParameter("id") != null) {
				accountId = Long.parseLong(request.getParameter("id"));
				subscriptionAccountVo = subscriptionAccountService.getSubscriptionAccountbyId(accountId);
				if (subscriptionAccountVo != null) {
					subscriptionAccountModel.setId(subscriptionAccountVo.getId());
					subscriptionAccountModel.setLegalEntityId(subscriptionAccountVo.getLegalEntityId());
					subscriptionAccountModel.setAccountName(subscriptionAccountVo.getAccountName());
					subscriptionAccountModel.setAccountDesc(subscriptionAccountVo.getAccountDesc());
					subscriptionAccountModel.setDeleted(subscriptionAccountVo.isDeleted());
					subscriptionAccountModel.setDisabled(subscriptionAccountVo.isDisabled());
					subscriptionAccountModel.setCreatedTime(subscriptionAccountVo.getCreatedTime());
					subscriptionAccountModel.setUpdatedTime(subscriptionAccountVo.getUpdatedTime());
				}
				
				if (request.getParameter("result") != null) {
					model.put("result", request.getParameter("result"));
				}
			}
		}
		
		model.addAttribute("subscriptionAccountModel", subscriptionAccountModel);
	}
}
