package it.jac.javadb.util;

import it.jac.javadb.dao.ItemCriteriaDao;
import it.jac.javadb.dao.ItemDao;
import it.jac.javadb.dao.ItemHQLDao;
import it.jac.javadb.dao.ItemNativeDao;

public class DaoFactory {

	public static ItemDao createItemNativeDao() {
		
		return new ItemNativeDao();
	}
	
	public static ItemDao createItemHQLDao() {
	
		return new ItemHQLDao();
	}
	
	public static ItemDao createItemCriteriaDao() {
		
		return new ItemCriteriaDao();
	}
}
