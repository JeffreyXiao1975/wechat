package com.xyh.wechat.web.controller.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.xyh.wechat.convertor.service.ServiceAccountConvertor;
import com.xyh.wechat.service.platform.IPlatformLegalEntity;
import com.xyh.wechat.service.service.IServiceAccountService;
import com.xyh.wechat.vo.platform.PlatformLegalEntityVo;
import com.xyh.wechat.vo.service.ServiceAccountVo;
import com.xyh.wechat.web.model.service.QueryServiceAccountCriteriaModel;
import com.xyh.wechat.web.model.service.ServiceAccountModel;
import com.xyh.wechat.web.validator.service.ServiceAccountValidator;

@Controller
public class ServiceController {
	@Autowired
	private IServiceAccountService serviceAccountService;
	
	@Autowired
	private IPlatformLegalEntity platformLegalEntity;
	
	@InitBinder("serviceAccountModel") 
	public void initBinder(DataBinder binder) {  
		binder.setValidator(new ServiceAccountValidator());  
	}
	
	@RequestMapping("/service/servicemain")
	public void initQueryServiceAccountForm(ModelMap model) {
		QueryServiceAccountCriteriaModel queryModel = new QueryServiceAccountCriteriaModel();
		queryModel.setDisabled(false);
		queryModel.setDeleted(false);
		this.queryServiceAccount(queryModel, model, null);
	}
	
	@RequestMapping(value="/service/servicemain", method=RequestMethod.POST)
	public ModelAndView postQueryServiceAccountForm(HttpSession httpSession, @ModelAttribute("queryServiceAccountCriteriaModel") QueryServiceAccountCriteriaModel queryModel, BindingResult result, ModelMap model) {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("/service/servicemain");
		this.queryServiceAccount(queryModel, model, mv);
		return mv;
	}
	
	@RequestMapping(value="/service/createServiceAccount", method=RequestMethod.GET)
	public void initCreateServiceAccountForm(ModelMap model) {
		model.addAttribute("serviceAccountModel", new ServiceAccountModel());
	}
	
	/**
	 * 
	 * @param httpSession
	 * @param serviceAccountModel
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/service/createServiceAccount", method=RequestMethod.POST)
	public String postCreateServiceAccountForm(HttpSession httpSession, @ModelAttribute("serviceAccountModel") @Valid ServiceAccountModel serviceAccountModel, BindingResult result, ModelMap model) {
		ServiceAccountVo serviceAccountVo = ServiceAccountConvertor.convertToVo(serviceAccountModel);
		serviceAccountService.createServiceAccount(serviceAccountVo);
		serviceAccountVo = serviceAccountService.getServiceAccountbyName(serviceAccountVo.getAccountName());
		serviceAccountModel = ServiceAccountConvertor.convertToModel(serviceAccountVo);
		return "redirect:viewServiceAccount.do?result=CreatedSuccessfully&id=" + serviceAccountVo.getId();
	}
	
	@RequestMapping(value="/service/viewServiceAccount", method=RequestMethod.GET)
	public void initViewServiceAccountForm(HttpServletRequest request, ModelMap model) {
		this.initializeServiceAccount(request, model);
	}
	
	@RequestMapping(value="/service/updateServiceAccount", method=RequestMethod.GET)
	public void initUpdateServiceAccountForm(HttpServletRequest request, ModelMap model) {
		this.initializeServiceAccount(request, model);
	}
	
	@RequestMapping(value="/service/updateServiceAccount", method=RequestMethod.POST)
	public void postUpdateServiceAccountForm(@ModelAttribute("serviceAccountModel") @Valid ServiceAccountModel serviceAccountModel, BindingResult result, ModelMap model) {
		model.addAttribute("serviceAccountModel", new ServiceAccountModel());
	}
	
	@RequestMapping(value="/service/disableServiceAccount", method=RequestMethod.GET)
	@ResponseBody  
	public Map<String, Object> disableServiceAccount(HttpServletRequest request,HttpServletResponse response) {
		String accountId = "";
		ServiceAccountVo serviceAccountVo = null; 
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		accountId = request.getParameter("accountId");
		serviceAccountVo = serviceAccountService.getServiceAccountbyId(Long.parseLong(accountId));
		if (serviceAccountVo != null) {
			if (serviceAccountVo.isDeleted()) {
				//the service account has been marked as deleted by others
				modelMap.put("success", "false");
				modelMap.put("message", "The service account has been deleted by others!");
			} else {
				if (serviceAccountVo.isDisabled()) {
					//the service account has been marked as disabled by others
					modelMap.put("success", "false");
					modelMap.put("message", "The service account has been disabled by others!");
				} else {
					serviceAccountService.disableServiceAccount(serviceAccountVo);
					modelMap.put("success", "false");
					modelMap.put("message", "The service account was disabled successfully!");
				}
			}
			
		} else {
			//the service account has been physically deleted by others
			modelMap.put("success", "false");
			modelMap.put("message", "The service account has been physically deleted by others!");
		}
		
		return modelMap;
	}
	
	@RequestMapping(value="/service/enableServiceAccount", method=RequestMethod.GET)
	@ResponseBody  
	public Map<String, Object> enableServiceAccount(HttpServletRequest request,HttpServletResponse response) {
		String accountId = "";
		ServiceAccountVo serviceAccountVo = null; 
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		accountId = request.getParameter("accountId");
		serviceAccountVo = serviceAccountService.getServiceAccountbyId(Long.parseLong(accountId));
		if (serviceAccountVo != null) {
			if (serviceAccountVo.isDeleted()) {
				//the service account has been marked as deleted by others
				modelMap.put("success", "false");
				modelMap.put("message", "The service account has been deleted by others!");
			} else {
				if (serviceAccountVo.isDisabled()) {
					serviceAccountService.enableServiceAccount(serviceAccountVo);
					modelMap.put("success", "false");
					modelMap.put("message", "The service account was enabled successfully!");
				} else {
					//the service account has been enabled by others
					modelMap.put("success", "false");
					modelMap.put("message", "The service account has been enabled by others!");
				}
			}
			
		} else {
			//the service account has been physically deleted by others
			modelMap.put("success", "false");
			modelMap.put("message", "The service account has been physically deleted by others!");
		}
		
		return modelMap;
	}
	
	@RequestMapping(value="/service/deleteServiceAccount", method=RequestMethod.GET)
	@ResponseBody  
	public Map<String, Object> deleteServiceAccount(HttpServletRequest request,HttpServletResponse response) {
		String accountId = "";
		ServiceAccountVo serviceAccountVo = null; 
		Map<String, Object> modelMap = new HashMap<String, Object>();
		RequestContext requestContext = new RequestContext(request);  
		//requestContext.getMessage("");  

		
		accountId = request.getParameter("accountId");
		serviceAccountVo = serviceAccountService.getServiceAccountbyId(Long.parseLong(accountId));
		if (serviceAccountVo != null) {
			if (serviceAccountVo.isDeleted()) {
				//the service account has been marked as deleted by others
				modelMap.put("success", "false");
				modelMap.put("message", requestContext.getMessage("")); //"The service account has been deleted by others!");
			} else {
				serviceAccountService.deleteServiceAccount(serviceAccountVo);
				modelMap.put("success", "false");
				modelMap.put("message", "The service account was disabled successfully!");
			}
			
		} else {
			//the service account has been physically deleted by others
			modelMap.put("success", "false");
			modelMap.put("message", "The service account has been physically deleted by others!");
		}
		
		return modelMap;
	}
	
	private void queryServiceAccount(QueryServiceAccountCriteriaModel queryModel, ModelMap model, ModelAndView mv) {
		List<ServiceAccountVo> serviceAccountList = null;
		
		serviceAccountList = serviceAccountService.getAllServiceAccounts(queryModel.isDisabled(), queryModel.isDeleted());
		queryModel.setServiceAccountList(serviceAccountList);
		model.addAttribute("queryServiceAccountCriteriaModel", queryModel);
	}
	
	private void initializeServiceAccount(HttpServletRequest request, ModelMap model) {
		long accountId = 0;
		ServiceAccountVo serviceAccountVo = null;
		ServiceAccountModel serviceAccountModel = new ServiceAccountModel();

		if (model != null && model.get("serviceAccountModel") != null) {
			serviceAccountModel = (ServiceAccountModel) model.get("serviceAccountModel");
		} else {
			if (request.getParameter("id") != null) {
				accountId = Long.parseLong(request.getParameter("id"));
				serviceAccountVo = serviceAccountService.getServiceAccountbyId(accountId);
				if (serviceAccountVo != null) {
					serviceAccountModel.setId(serviceAccountVo.getId());
					serviceAccountModel.setLegalEntityId(serviceAccountVo.getLegalEntityId());
					serviceAccountModel.setAccountName(serviceAccountVo.getAccountName());
					serviceAccountModel.setAccountDesc(serviceAccountVo.getAccountDesc());
					serviceAccountModel.setDeleted(serviceAccountVo.isDeleted());
					serviceAccountModel.setDisabled(serviceAccountVo.isDisabled());
					serviceAccountModel.setCreatedTime(serviceAccountVo.getCreatedTime());
					serviceAccountModel.setUpdatedTime(serviceAccountVo.getUpdatedTime());
				}
				
				if (request.getParameter("result") != null) {
					model.put("result", request.getParameter("result"));
				}
			}
		}
		
		model.addAttribute("serviceAccountModel", serviceAccountModel);
	}
	
	@ModelAttribute("legalEntities")
	public Map<String, String> getLegalEntities() {
		List<PlatformLegalEntityVo> platformLegalEntityVos = null;
		Map<String, String> legalEntities = new HashMap<String, String>();
		
		platformLegalEntityVos = platformLegalEntity.getAllLegalEntities(false, false);
		if (platformLegalEntityVos != null && platformLegalEntityVos.size() > 0) {
			Iterator<PlatformLegalEntityVo> iterator = platformLegalEntityVos.iterator();
			while (iterator.hasNext()) {
				PlatformLegalEntityVo platformLegalEntityVo = iterator.next();
				legalEntities.put(String.valueOf(platformLegalEntityVo.getId()), platformLegalEntityVo.getNameCN());
			}
		}

		return legalEntities;
	}

}
