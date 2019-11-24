package it.jac.javadb.gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class DataTableModel implements TableModel {

	private List<String[]> tableContent = new ArrayList<>();
	
	public DataTableModel(List<String[]> tableContent) {
		
		this.tableContent.addAll(tableContent);
	}
	
	@Override
	public int getRowCount() {
		return 3;
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
		return this.tableContent.get(rowIndex)[columnIndex];
	}

	@Override
	public String getColumnName(int columnIndex) {
		return "column" + columnIndex;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		
	}

}
