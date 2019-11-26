package it.jac.javadb;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.jac.javadb.dao.ItemDao;
import it.jac.javadb.entity.Item;
import it.jac.javadb.service.ItemService;
import it.jac.javadb.util.HibernateUtil;
import it.jac.javadb.util.Utils;

public class MainApp {

	private static final Logger log = LogManager.getLogger(MainApp.class);
	
	public static void main(String[] args) {
		
		log.info("App Started");

		HibernateUtil.getSessionFactory();
		
		do {

			System.out.println("Scegliere la funzione: ");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();

			switch (s) {
			case "1": {

				System.out.println("Test connessione");
				ItemDao dao = new ItemDao();
				
				boolean test = dao.testConnessione();
				if (test) {
				
					log.info("Test OK");
				}
				
				break;
			}
			case "2": {

				System.out.println("Stampa lista");

				ItemService service = new ItemService();
				List<Item> list = service.findAll();
				
				Utils.stampaLista(list);
				break;
			}
			case "3": {

				System.out.println("Stampa articolo singolo");

//				TODO implementare
				break;
			}
			case "4": {

				System.out.println("Aggiungi articolo alla lista");

				Item item = createItemFromUserInput();
				
				ItemService service = new ItemService();
				service.saveItem(item);
				
				break;
			}
			case "5": {

				System.out.println("Modifica articolo alla lista");

				
 				Item item = new Item();
 				
 				item.setId(2);
 				item.setCode("2");
 				item.setName("articolo modificato");
 				item.setDescription("descr art modificato");
				item.setLongDescription("descrizione articolo modificato");

				ItemService service = new ItemService();
				
				service.updateItem(item);
				
				break;
			}
			case "6": {

				System.out.println("Elimina articolo dalla lista");

// 				TODO implementare
				
				break;
			}
			case "7": {

				System.out.println("Stampa lista articoli validi alla data");

// 				TODO implementare
				
				break;
			}
			default: {

				System.out.println("Scelta non gestita, l'applicazione termina");

				log.info("App finished");
				return;
			}
			}

		} while (true);

	}

	private static Item createItemFromUserInput() {

		Item item = new Item();

		Scanner in = new Scanner(System.in);
		
		System.out.print("Inserire codice articolo: ");
		item.setCode(in.nextLine());

		System.out.print("Inserire nome articolo: ");
		item.setName(in.nextLine());

		System.out.print("Inserire descrizione articolo: ");
		item.setDescription(in.nextLine());

		System.out.print("Inserire descrizione articolo (estesa): ");
		item.setLongDescription(in.nextLine());

		return item;
	}
}
