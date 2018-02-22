package com.xyh.wechat.web.controller.enterprise;

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

import com.xyh.wechat.service.enterprise.IEnterpriseAccountService;
import com.xyh.wechat.vo.enterprise.EnterpriseAccountVo;
import com.xyh.wechat.web.model.enterprise.QueryEnterpriseAccountCriteriaModel;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {
	@Autowired
	private IEnterpriseAccountService enterpriseAccountService;
	
	@RequestMapping("/enterprisemain")
	public void initQueryForm(ModelMap model) {
		QueryEnterpriseAccountCriteriaModel queryModel = new QueryEnterpriseAccountCriteriaModel();
		queryModel.setDisabled(false);
		queryModel.setDeleted(false);
		this.QueryEnterpriseAccount(queryModel, model, null);
	}
	
	@RequestMapping(value="/enterprisemain", method=RequestMethod.POST)
	public ModelAndView queryUser(HttpSession httpSession, @ModelAttribute("queryEnterpriseAccountCriteriaModel") @Valid QueryEnterpriseAccountCriteriaModel queryModel, BindingResult result, ModelMap model) {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("/enterprise/enterprisemain");
		this.QueryEnterpriseAccount(queryModel, model, mv);
		return mv;
	}
	
	private void QueryEnterpriseAccount(QueryEnterpriseAccountCriteriaModel queryModel, ModelMap model, ModelAndView mv) {
		List<EnterpriseAccountVo> enterpriseAccountList = null;
		
		enterpriseAccountList = enterpriseAccountService.getAllEnterpriseAccounts(queryModel.isDisabled(), queryModel.isDeleted());
		queryModel.setEnterpriseAccountList(enterpriseAccountList);
		model.addAttribute("queryEnterpriseAccountCriteriaModel", queryModel);
	}
}
