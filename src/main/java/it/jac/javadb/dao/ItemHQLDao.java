package it.jac.javadb.dao;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import it.jac.javadb.entity.Item;
import it.jac.javadb.util.HibernateUtil;

public class ItemHQLDao extends ItemDao {

	private static final Logger log = LogManager.getLogger(ItemHQLDao.class);
	
	@Override
	public List<Item> findByValidDate(Date date) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Query<Item> query = session
					.createQuery("from Item where :data between validFrom and validTo", Item.class);

			query.setParameter("data", date);
			
			List<Item> list = query.list();

			log.debug("found [" + list.size() + "] entities");

			return list;

		}	
	
	}

}
