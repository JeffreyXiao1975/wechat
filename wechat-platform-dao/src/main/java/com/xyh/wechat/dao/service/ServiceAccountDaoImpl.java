package com.xyh.wechat.dao.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.xyh.wechat.dao.BaseDao;
import com.xyh.wechat.jpa.entities.WxServiceAccount;

@Component("serviceAccountDao")
@Scope("singleton")
public class ServiceAccountDaoImpl extends BaseDao implements IServiceAccountDao {

	@SuppressWarnings("unchecked")
	public List<WxServiceAccount> getAllServiceAccounts(boolean includeDisabled, boolean includeDeleted) {
		String strSQL = "";
		List<WxServiceAccount> lWxServiceAccounts =  null;
		
		try {
			strSQL = "select wxServiceAccount from WxServiceAccount as wxServiceAccount where 1 = 1 ";
			if (includeDisabled) {
				if (!includeDeleted) {
					strSQL = strSQL + " and wxServiceAccount.deleted = 0 ";
				}
			} else {
				if (includeDeleted) {
					strSQL = strSQL + " and wxServiceAccount.disabled = 0 ";
				} else {
					strSQL = strSQL + " and wxServiceAccount.disabled = 0 and wxServiceAccount.deleted = 0 ";
				}
			}
			Query query = this.entityManager.createQuery(strSQL);
			lWxServiceAccounts = (List<WxServiceAccount>) query.getResultList();
		} catch (Exception ex) {
			logger.error(ex);
			lWxServiceAccounts = null;
		}
		return lWxServiceAccounts;
	}

	public WxServiceAccount getServiceAccountbyId(long accountId) {
		WxServiceAccount wxServiceAccount = null;
		
		try {
			wxServiceAccount = this.entityManager.find(WxServiceAccount.class, accountId);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return wxServiceAccount;
	}

	public void createServiceAccount(WxServiceAccount wxServiceAccount) {		
		this.entityManager.persist(wxServiceAccount);
	}

	public void updateServiceAccount(WxServiceAccount wxServiceAccount) {
		this.entityManager.merge(wxServiceAccount);
	}

	public WxServiceAccount getServiceAccountbyName(String accountName) {
		WxServiceAccount wxServiceAccount =  null;
		
		try {
			Query query = this.entityManager.createQuery("select wxServiceAccount from WxServiceAccount as wxServiceAccount where wxServiceAccount.accountName = :accountName ");
			query.setParameter("accountName", accountName);
			wxServiceAccount = (WxServiceAccount) query.getSingleResult();
		} catch (Exception ex) {
			logger.error(ex);
			wxServiceAccount = null;
		}
		return wxServiceAccount;
	}

}
