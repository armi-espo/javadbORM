package it.jac.javadb.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;

import it.jac.javadb.entity.Item;
import it.jac.javadb.util.HibernateUtil;

public class ItemCriteriaDao extends ItemDao {

	@Override
	public List<Item> findByValidDate(Date date) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Criteria criteria = session.createCriteria(Item.class);
			
			Conjunction conjunction = Restrictions.conjunction();
			conjunction.add(Restrictions.ge("validFrom", date));
			conjunction.add(Restrictions.le("validTo", date));
			
			criteria.add(conjunction);
			
			return criteria.list();
		}
		
	}

}
