package it.jac.javadb.gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataTableModel extends AbstractTableModel {

	private static final Logger log = LogManager.getLogger(DataTableModel.class);
	
	private static final int PAGE_SIZE = 3;
	
	private List<String[]> tableContent = new ArrayList<>();
	private int currentPage = 0;
	
	public DataTableModel(List<String[]> tableContent) {
		
		this.tableContent.addAll(tableContent);
	}
	
	@Override
	public int getRowCount() {
		return PAGE_SIZE;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		log.debug("getValueAt [" + rowIndex + "," + columnIndex + "]");
		
		int index = (currentPage * PAGE_SIZE) + rowIndex;
		if (index < this.tableContent.size()) {
			return this.tableContent.get(index)[columnIndex];
		}
		return "";
	}

	@Override
	public String getColumnName(int columnIndex) {
		return "column" + columnIndex;
	}

	public void goToPrevPage() {
		
		log.info("go to previous page");		
		this.currentPage = Math.max(0, this.currentPage -1);
		log.debug("currenPage " + this.currentPage);
		fireTableDataChanged();
	}

	public void goToNextPage() {
		
		log.info("go to next page");		
		this.currentPage = Math.min(this.currentPage + 1, (this.tableContent.size() / PAGE_SIZE));
		log.debug("currenPage " + this.currentPage);
		fireTableDataChanged();
	}

}
