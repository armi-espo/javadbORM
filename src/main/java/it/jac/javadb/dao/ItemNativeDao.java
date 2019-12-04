package it.jac.javadb.dao;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import it.jac.javadb.entity.Item;
import it.jac.javadb.util.HibernateUtil;

public class ItemNativeDao extends ItemDao {

	private static final Logger log = LogManager.getLogger(ItemNativeDao.class); 
	
	public List<Item> findByValidDate(Date date) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			NativeQuery<Item> query = session
					.createNativeQuery("select * from item where ? between validFrom and validTo", Item.class);

			query.setParameter(1, date);

			List<Item> list = query.list();

			log.debug("found [" + list.size() + "] entities");

			return list;

		}
	}

}
