/**
 * 
 */
package com.xyh.wechat.web.controller.platform;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xyh.wechat.service.platform.IPlatformRoleService;
import com.xyh.wechat.util.WeChatPlatformConstants;
import com.xyh.wechat.util.WeChatPlatformMath;
import com.xyh.wechat.web.model.platform.PlatformRoleCriteriaModel;
import com.xyh.wechat.web.model.platform.PlatformRoleModel;
import com.xyh.wechat.vo.platform.PlatformRoleVo;

@Controller
public class PlatformRoleController {
	@Autowired
	IPlatformRoleService platformRoleService;
	
	@RequestMapping(value="/platform/platformRoleSetting", method=RequestMethod.GET)
	public void initPlatformRoleSettingForm(ModelMap model) {
		PlatformRoleCriteriaModel platformRoleCriteriaModel = new PlatformRoleCriteriaModel();
		platformRoleCriteriaModel.setRolename("");
		platformRoleCriteriaModel.setCurrentPageNumber(1);
		platformRoleCriteriaModel.setFirstPage(true);
		platformRoleCriteriaModel.setLastPage(true);
		platformRoleCriteriaModel.setDisabledIncluded(false);
		platformRoleCriteriaModel.setDeletedIncluded(false);
		platformRoleCriteriaModel.setPageSize(WeChatPlatformConstants.pageSize);
		this.queryPlatformRoles(platformRoleCriteriaModel, model, null);
	}
	
	@RequestMapping(value="/platform/platformRoleSetting", method=RequestMethod.POST)
	public ModelAndView postPlatformRoleSettingForm(HttpSession httpSession, @ModelAttribute("platformRoleCriteriaModel") PlatformRoleCriteriaModel platformRoleCriteriaModel, BindingResult result, ModelMap model) {
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("/platform/platformRoleSetting");
		this.queryPlatformRoles(platformRoleCriteriaModel, model, mv);
		return mv; 
	}
	
	@RequestMapping(value="/platform/createPlatformRole", method=RequestMethod.GET)
	public void initCreatePlatformRoleForm(ModelMap model) {
		
	}
	
	@RequestMapping(value="/platform/createPlatformRole", method=RequestMethod.POST)
	public String postCreatePlatformRoleForm(HttpSession httpSession, @ModelAttribute("platformRoleModel") @Valid PlatformRoleModel platformRoleModel, BindingResult result, ModelMap model) {
		return "";
	}
	
	@RequestMapping(value="/platform/viewPlatformRole", method=RequestMethod.GET)
	public void initViewPlatformRoleForm(HttpServletRequest request, ModelMap model) {
		
	}
	
	@RequestMapping(value="/platform/updatePlatformRole", method=RequestMethod.GET)
	public void initUpdatePlatformRoleForm(HttpServletRequest request, ModelMap model) {
		
	}
	
	@RequestMapping(value="/platform/updatePlatformRole", method=RequestMethod.POST)
	public void postUpdatePlatformRoleForm(HttpSession httpSession, @ModelAttribute("platformRoleModel") @Valid PlatformRoleModel platformRoleModel, BindingResult result, ModelMap model) {
		
	}
	
	@RequestMapping(value="/service/disablePlatformRole", method=RequestMethod.GET)
	@ResponseBody  
	public Map<String, Object> disablePlatformRole(HttpServletRequest request,HttpServletResponse response) {
		long platformRoleId;
		PlatformRoleVo platformRoleVo = null;
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		platformRoleId = Long.parseLong(request.getParameter("id"));
		platformRoleVo = platformRoleService.getPlatformRoleById(platformRoleId);
		if (platformRoleVo != null) {
			if (platformRoleVo.isDeleted()) {
				modelMap.put("success", "false");
				modelMap.put("message", "The role has been deleted by others!");
			} else {
				if (platformRoleVo.isDisabled()) {
					modelMap.put("success", "false");
					modelMap.put("message", "The role has been disabled by others!");
				} else {
					platformRoleService.disablePlatformRole(platformRoleVo);
					modelMap.put("success", "true");
					modelMap.put("message", "The role was disabled successfully!");
				}
			}
		} else {
			modelMap.put("success", "false");
			modelMap.put("message", "The role has been physically deleted by others!");
		}
		return modelMap;
	}
	
	@RequestMapping(value="/service/deletePlatformRole", method=RequestMethod.GET)
	@ResponseBody  
	public Map<String, Object> deletePlatformRole(HttpServletRequest request,HttpServletResponse response) {
		long platformRoleId;
		PlatformRoleVo platformRoleVo = null;
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		platformRoleId = Long.parseLong(request.getParameter("id"));
		platformRoleVo = platformRoleService.getPlatformRoleById(platformRoleId);
		if (platformRoleVo != null) {
			if (platformRoleVo.isDeleted()) {
				modelMap.put("success", "false");
				modelMap.put("message", "The role has been deleted by others!");
			} else {
				platformRoleService.deletePlatformRole(platformRoleVo);
				modelMap.put("success", "true");
				modelMap.put("message", "The role was deleted successfully!");
			}
		} else {
			modelMap.put("success", "false");
			modelMap.put("message", "The role has been physically deleted by others!");
		}
		return modelMap;
	}
	
	@RequestMapping(value="/service/enablePlatformRole", method=RequestMethod.GET)
	@ResponseBody  
	public Map<String, Object> enablePlatformRole(HttpServletRequest request,HttpServletResponse response) {
		long platformRoleId;
		PlatformRoleVo platformRoleVo = null;
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		platformRoleId = Long.parseLong(request.getParameter("id"));
		platformRoleVo = platformRoleService.getPlatformRoleById(platformRoleId);
		if (platformRoleVo != null) {
			if (platformRoleVo.isDeleted()) {
				modelMap.put("success", "false");
				modelMap.put("message", "The role has been deleted by others!");
			} else {
				if (platformRoleVo.isDisabled()) {
					platformRoleService.enablePlatformRole(platformRoleVo);
					modelMap.put("success", "true");
					modelMap.put("message", "The role was enabled successfully!");
				} else {
					modelMap.put("success", "false");
					modelMap.put("message", "The role has been enabled by others!");
				}
			}
		} else {
			modelMap.put("success", "false");
			modelMap.put("message", "The role has been physically deleted by others!");
		}
		return modelMap;
	}
	
	private void queryPlatformRoles(PlatformRoleCriteriaModel platformRoleCriteriaModel, ModelMap model, ModelAndView mv) {
		long totalRoleCount = 0;
		List<PlatformRoleVo> queryPlatformRoleResult = null;
		
		totalRoleCount = platformRoleService.queryPlatformRoleCount(platformRoleCriteriaModel);
		queryPlatformRoleResult = platformRoleService.queryPlatformRoles(platformRoleCriteriaModel);
		if (totalRoleCount > 0) {
			platformRoleCriteriaModel.setTotalPageNumber(WeChatPlatformMath.GetTotalPageNumber(totalRoleCount, platformRoleCriteriaModel.getPageSize()));
			platformRoleCriteriaModel.setCurrentPageNumber(1);
			platformRoleCriteriaModel.setFirstPage(true);
			platformRoleCriteriaModel.setLastPage(false);
			platformRoleCriteriaModel.setPageSize(WeChatPlatformConstants.pageSize);
		} else {
			platformRoleCriteriaModel.setCurrentPageNumber(1);
			platformRoleCriteriaModel.setFirstPage(true);
			platformRoleCriteriaModel.setLastPage(true);
			platformRoleCriteriaModel.setPageSize(WeChatPlatformConstants.pageSize);
		}
		
		platformRoleCriteriaModel.setRolelist(queryPlatformRoleResult);
		model.addAttribute("platformRoleCriteriaModel", platformRoleCriteriaModel);
	}
}
