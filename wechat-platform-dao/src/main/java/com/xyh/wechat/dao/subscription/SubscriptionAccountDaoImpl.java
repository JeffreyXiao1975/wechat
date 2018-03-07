package com.xyh.wechat.dao.subscription;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.dao.BaseDao;
import com.xyh.wechat.jpa.entities.WxSubscriptionAccount;

@Component("subscriptionAccountDao")
@Scope("singleton")
@Transactional
public class SubscriptionAccountDaoImpl extends BaseDao implements ISubscriptionAccountDao {

	@SuppressWarnings("unchecked")
	public List<WxSubscriptionAccount> getAllSubscriptionAccounts(boolean includeDisabled, boolean includeDeleted) {
		String strSQL = "";
		List<WxSubscriptionAccount> lWxSubscriptionAccounts =  null;
		
		try {
			strSQL = "select wxSubscriptionAccount from WxSubscriptionAccount as wxSubscriptionAccount where 1 = 1 ";
			if (includeDisabled) {
				if (!includeDeleted) {
					strSQL = strSQL + " and wxSubscriptionAccount.deleted = 0 ";
				}
			} else {
				if (includeDeleted) {
					strSQL = strSQL + " and wxSubscriptionAccount.disabled = 0 ";
				} else {
					strSQL = strSQL + " and wxSubscriptionAccount.disabled = 0 and wxSubscriptionAccount.deleted = 0 ";
				}
			}
			Query query = this.entityManager.createQuery(strSQL);
			lWxSubscriptionAccounts = (List<WxSubscriptionAccount>) query.getResultList();
		} catch (Exception ex) {
			logger.error(ex);
			lWxSubscriptionAccounts = null;
		}
		return lWxSubscriptionAccounts;
	}

	public WxSubscriptionAccount getSubscriptionAccountbyId(long accountId) {
		WxSubscriptionAccount wxSubscriptionAccount = null;
		try {
			wxSubscriptionAccount = this.entityManager.find(WxSubscriptionAccount.class, accountId);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return wxSubscriptionAccount;
	}

	public void createSubscriptionAccount(WxSubscriptionAccount wxSubscriptionAccount) {
		try {
			this.entityManager.persist(wxSubscriptionAccount);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public void updateSubscriptionAccount(WxSubscriptionAccount wxSubscriptionAccount) {
		try {
			this.entityManager.merge(wxSubscriptionAccount);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	public WxSubscriptionAccount getSubscriptionAccountbyName(String accountName) {
		WxSubscriptionAccount wxSubscriptionAccount =  null;
		
		try {
			Query query = this.entityManager.createQuery("select wxSubscriptionAccount from WxSubscriptionAccount as wxSubscriptionAccount where wxSubscriptionAccount.accountName = :accountName ");
			query.setParameter("accountName", accountName);
			wxSubscriptionAccount = (WxSubscriptionAccount) query.getSingleResult();
		} catch (Exception ex) {
			logger.error(ex);
			wxSubscriptionAccount = null;
		}
		return wxSubscriptionAccount;
	}

}
