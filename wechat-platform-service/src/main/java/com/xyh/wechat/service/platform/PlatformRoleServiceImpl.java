package com.xyh.wechat.service.platform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.convertor.platform.PlatformRoleConvertor;
import com.xyh.wechat.dao.platform.IPlatformRoleDao;
import com.xyh.wechat.jpa.entities.WxPlatformRole;
import com.xyh.wechat.vo.platform.PlatformRoleVo;
import com.xyh.wechat.web.model.platform.PlatformRoleCriteriaModel;

@Service("platformRoleService")
public class PlatformRoleServiceImpl implements IPlatformRoleService {
	@Autowired  
	private IPlatformRoleDao platformRoleDao;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public long queryPlatformRoleCount(PlatformRoleCriteriaModel platformRoleCriteriaModel) {
		long roleCount = 0;
		roleCount = platformRoleDao.queryPlatformRoleCount(PlatformRoleConvertor.convertToVo(platformRoleCriteriaModel));
		return roleCount;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<PlatformRoleVo> queryPlatformRoles(PlatformRoleCriteriaModel platformRoleCriteriaModel) {
		return null;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public PlatformRoleVo getPlatformRoleById(long platformRoleId) {
		WxPlatformRole wxPlatformRole = null;
		
		wxPlatformRole = platformRoleDao.getPlatformRoleById(platformRoleId);
		return PlatformRoleConvertor.convertToVo(wxPlatformRole);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void createPlatformRole(PlatformRoleVo platformRoleVo) {
		WxPlatformRole wxPlatformRole = null;
		
		wxPlatformRole = PlatformRoleConvertor.convertToEntity(platformRoleVo);
		platformRoleDao.createPlatformRole(wxPlatformRole);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updatePlatformRole(PlatformRoleVo platformRoleVo) {
		WxPlatformRole wxPlatformRole = null;
		
		wxPlatformRole = platformRoleDao.getPlatformRoleById(platformRoleVo.getId());
		if (wxPlatformRole != null) {
			wxPlatformRole.setRoleName(platformRoleVo.getRolename());
			wxPlatformRole.setRoledesc(platformRoleVo.getRoledesc());
			platformRoleDao.updatePlatformRole(wxPlatformRole);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void deletePlatformRole(PlatformRoleVo platformRoleVo) {
		WxPlatformRole wxPlatformRole = null;
		
		wxPlatformRole = platformRoleDao.getPlatformRoleById(platformRoleVo.getId());
		if (wxPlatformRole != null) {
			wxPlatformRole.setDeleted(true);
			platformRoleDao.updatePlatformRole(wxPlatformRole);			
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void disablePlatformRole(PlatformRoleVo platformRoleVo) {
		WxPlatformRole wxPlatformRole = null;
		
		wxPlatformRole = platformRoleDao.getPlatformRoleById(platformRoleVo.getId());
		if (wxPlatformRole != null) {
			wxPlatformRole.setDisabled(true);
			platformRoleDao.updatePlatformRole(wxPlatformRole);			
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void enablePlatformRole(PlatformRoleVo platformRoleVo) {
		WxPlatformRole wxPlatformRole = null;
		
		wxPlatformRole = platformRoleDao.getPlatformRoleById(platformRoleVo.getId());
		if (wxPlatformRole != null) {
			wxPlatformRole.setDisabled(false);
			platformRoleDao.updatePlatformRole(wxPlatformRole);			
		}
	}
}
