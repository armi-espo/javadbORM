package it.jac.javadb.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import it.jac.javadb.dao.ItemDao;
import it.jac.javadb.entity.Item;
import it.jac.javadb.util.DaoFactory;

public class ItemService {

	private ItemDao dao = DaoFactory.createItemNativeDao();

	public Item findItemById(int id) {
		return dao.findItemById(id);
	}

	public List<Item> findAll() {
		return dao.findAll();
	}

	public List<Item> findByValidDate(Date date) {
		
		return dao.findByValidDate(date);
	}

	public List<Item> findLimitResults(int firstIndex, int pageSize) {

		return dao.findLimitResults(firstIndex, pageSize);
	}

	public void saveItem(Item item) {
		
		item.setValidFrom(new Date());
		item.setValidTo(DateUtils.addDays(new Date(), 100));
		
		item.setCreationUser("system");
		item.setCreationTime(new Date());
		
		dao.save(item);
	}

	public void updateItem(Item item) {

		item.setUpdateUser("system");
		item.setUpdateTime(new Date());
		
		dao.update(item);
	}
	
	public void deleteItem(Item item) {
		
		dao.delete(item);
	}

}
