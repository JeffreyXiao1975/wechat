package com.xyh.wechat.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
public class BaseDao {
	protected static Logger logger = Logger.getLogger(BaseDao.class);
	
	@PersistenceContext(unitName="wechat-jpa")
	protected EntityManager entityManager;
}
