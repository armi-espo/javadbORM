package it.jac.javadb.gui.model;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class DataTableColumnModel extends DefaultTableColumnModel {

	private static final String[] tableHeader = new String[] {
			"ID",
			"NOME",
			"DESCRIZIONE"
		};

	public DataTableColumnModel() {
		
		int i = 0;
		for (String header : tableHeader) {
			
			TableColumn col = new TableColumn(i++);
			col.setIdentifier("col_" + header);
			col.setHeaderValue(header);
			super.addColumn(col);
		}
	}
}
