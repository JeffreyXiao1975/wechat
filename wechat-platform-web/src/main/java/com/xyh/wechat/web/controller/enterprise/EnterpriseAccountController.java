package com.xyh.wechat.web.controller.enterprise;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xyh.wechat.service.enterprise.IEnterpriseAccountService;
import com.xyh.wechat.vo.enterprise.EnterpriseAccountVo;
import com.xyh.wechat.web.model.enterprise.EnterpriseAccountCriteriaModel;

@Controller
public class EnterpriseAccountController {
	@Autowired
	private IEnterpriseAccountService enterpriseAccountService;
	
	@RequestMapping(value="/enterprise/enterprisemain", method=RequestMethod.GET)
	public void initQueryEnterpriseAccountForm(ModelMap model) {
		EnterpriseAccountCriteriaModel queryModel = new EnterpriseAccountCriteriaModel();
		queryModel.setDisabled(false);
		queryModel.setDeleted(false);
		this.QueryEnterpriseAccount(queryModel, model, null);
	}
	
	@RequestMapping(value="/enterprise/enterprisemain", method=RequestMethod.POST)
	public ModelAndView postQueryServiceAccountForm(HttpSession httpSession, @ModelAttribute("enterpriseAccountCriteriaModel") EnterpriseAccountCriteriaModel queryModel, BindingResult result, ModelMap model) {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("/enterprise/enterprisemain");
		this.QueryEnterpriseAccount(queryModel, model, mv);
		return mv;
	}
	
	private void QueryEnterpriseAccount(EnterpriseAccountCriteriaModel queryModel, ModelMap model, ModelAndView mv) {
		List<EnterpriseAccountVo> enterpriseAccountList = null;
		
		enterpriseAccountList = enterpriseAccountService.getAllEnterpriseAccounts(queryModel.isDisabled(), queryModel.isDeleted());
		queryModel.setEnterpriseAccountList(enterpriseAccountList);
		model.addAttribute("enterpriseAccountCriteriaModel", queryModel);
	}
}
