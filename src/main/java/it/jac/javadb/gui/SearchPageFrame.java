package it.jac.javadb.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.jac.javadb.gui.model.DataTableColumnModel;
import it.jac.javadb.gui.model.DataTableModel;

public class SearchPageFrame extends JFrame {

	private static final Logger log = LogManager.getLogger(SearchPageFrame.class);

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPageFrame frame = new SearchPageFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchPageFrame() {

		List<String[]> tableContent = new ArrayList<>();
		tableContent.add(new String[] {"1", "Art. 1", "Descrizione art. 1"});
		tableContent.add(new String[] {"2", "Art. 2", "Descrizione art. 2"});
		tableContent.add(new String[] {"3", "Art. 3", "Descrizione art. 3"});

		tableContent.add(new String[] {"4", "Art. 4", "Descrizione art. 4"});
		tableContent.add(new String[] {"5", "Art. 5", "Descrizione art. 5"});
		tableContent.add(new String[] {"6", "Art. 6", "Descrizione art. 6"});

		tableContent.add(new String[] {"7", "Art. 7", "Descrizione art. 7"});
		tableContent.add(new String[] {"8", "Art. 8", "Descrizione art. 8"});

		final DataTableModel dataTableModel = new DataTableModel(tableContent);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataTableModel.goToPrevPage();
			}
		});
		contentPane.add(button, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataTableModel.goToNextPage();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.EAST);
				
		table.setModel(dataTableModel);
		dataTableModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				log.debug("tableChanged...repaint");
				table.repaint();
			}
		});
		table.setColumnModel(new DataTableColumnModel());
	}

}
