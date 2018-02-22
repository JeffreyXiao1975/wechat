package com.xyh.wechat.dao.enterprise;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.dao.BaseDao;
import com.xyh.wechat.jpa.entities.WxEnterpriseAccount;
import com.xyh.wechat.jpa.entities.WxEnterpriseSubaccount;

@Component("enterpriseAccountDao")
@Scope("singleton")
@Transactional
public class EnterpriseAccountDaoImpl extends BaseDao implements IEnterpriseAccountDao {

	@SuppressWarnings("unchecked")
	public List<WxEnterpriseAccount> getAllEnterpriseAccounts(boolean includeDisabled, boolean includeDeleted) {
		String strSQL = "";
		List<WxEnterpriseAccount> lWxEnterpriseAccounts =  null;
		
		try {
			strSQL = "select wxEnterpriseAccount from WxEnterpriseAccount as wxEnterpriseAccount where 1 = 1 ";
			if (includeDisabled) {
				if (!includeDeleted) {
					strSQL = strSQL + " and wxEnterpriseAccount.deleted = 0 ";
				}
			} else {
				if (includeDeleted) {
					strSQL = strSQL + " and wxEnterpriseAccount.disabled = 0 ";
				} else {
					strSQL = strSQL + " and wxEnterpriseAccount.disabled = 0 and wxEnterpriseAccount.deleted = 0 ";
				}
			}
			Query query = this.entityManager.createQuery(strSQL);
			lWxEnterpriseAccounts = (List<WxEnterpriseAccount>) query.getResultList();
		} catch (Exception ex) {
			logger.error(ex);
			lWxEnterpriseAccounts = null;
		}
		return lWxEnterpriseAccounts;
	}

	public WxEnterpriseAccount createEnterpriseAccount(WxEnterpriseAccount wxEnterpriseAccount) {
		try {
			this.entityManager.persist(wxEnterpriseAccount);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return wxEnterpriseAccount;
	}

	public WxEnterpriseAccount updateEnterpriseAccount(WxEnterpriseAccount wxEnterpriseAccount) {
		return this.entityManager.merge(wxEnterpriseAccount);
	}

	public WxEnterpriseAccount getEnterpriseAccountbyId(long accountId) {
		WxEnterpriseAccount wxEnterpriseAccount = null;
		try {
			wxEnterpriseAccount = this.entityManager.find(WxEnterpriseAccount.class, accountId);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return wxEnterpriseAccount;
	}

	public WxEnterpriseAccount getEnterpriseAccountbyName(String accountName) {
		WxEnterpriseAccount wxEnterpriseAccount = null;
		try {
			Query query = this.entityManager.createQuery("select wxEnterpriseAccount from WxEnterpriseAccount as wxEnterpriseAccount where 1 = 1 and wxEnterpriseAccount.accountNae = :accountName ");
			query.setParameter("accountName", accountName);
			wxEnterpriseAccount = (WxEnterpriseAccount) query.getSingleResult();
		} catch (Exception ex) {
			logger.error(ex);
		}
		return wxEnterpriseAccount;
	}

	@SuppressWarnings("unchecked")
	public List<WxEnterpriseSubaccount> getAllEnterpriseSubaccounts(long parentAccountId, boolean includeDisabled,
			boolean includeDeleted) {
		String strSQL = "";
		List<WxEnterpriseSubaccount> lWxEnterpriseSubaccounts =  null;
		
		try {
			strSQL = "select wxEnterpriseSubaccount from WxEnterpriseSubaccount as wxEnterpriseSubaccount where 1 = 1 "
					+ " wxEnterpriseSubaccount.parentAccount.accountId = :parentAccountId ";
			if (includeDisabled) {
				if (!includeDeleted) {
					strSQL = strSQL + " and wxEnterpriseSubaccount.deleted = 0 ";
				}
			} else {
				if (includeDeleted) {
					strSQL = strSQL + " and wxEnterpriseSubaccount.disabled = 0 ";
				} else {
					strSQL = strSQL + " and wxEnterpriseSubaccount.disabled = 0 and wxEnterpriseSubaccount.deleted = 0 ";
				}
			}
			Query query = this.entityManager.createQuery(strSQL);
			query.setParameter("parentAccountId", parentAccountId);
			lWxEnterpriseSubaccounts = (List<WxEnterpriseSubaccount>) query.getResultList();
		} catch (Exception ex) {
			logger.error(ex);
			lWxEnterpriseSubaccounts = null;
		}
		return lWxEnterpriseSubaccounts;
	}

	public WxEnterpriseSubaccount getEnterpriseSubaccountbyId(long subaccountId) {
		WxEnterpriseSubaccount wxEnterpriseSubaccount = null;
		try {
			wxEnterpriseSubaccount = this.entityManager.find(WxEnterpriseSubaccount.class, subaccountId);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return wxEnterpriseSubaccount;
	}

	public WxEnterpriseSubaccount createEnterpriseSubAccount(WxEnterpriseSubaccount wxEnterpriseSubaccount) {
		try {
			this.entityManager.persist(wxEnterpriseSubaccount);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return wxEnterpriseSubaccount;
	}

	public WxEnterpriseSubaccount updateEnterpriseSubaccount(WxEnterpriseSubaccount wxEnterpriseSubaccount) {
		return this.entityManager.merge(wxEnterpriseSubaccount);
	}
}
