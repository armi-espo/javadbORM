package it.jac.javadb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.jac.javadb.dao.ItemDao;
import it.jac.javadb.entity.Item;
import it.jac.javadb.service.ItemService;
import it.jac.javadb.util.DaoFactory;
import it.jac.javadb.util.HibernateUtil;
import it.jac.javadb.util.Utils;

public class MainApp {

	private static final Logger log = LogManager.getLogger(MainApp.class);
	
	public static void main(String[] args) throws ParseException {
		
		log.info("App Started");

		HibernateUtil.getSessionFactory();
		
		do {

			System.out.println("Scegliere la funzione: ");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();

			switch (s) {
			case "1": {

				System.out.println("Test connessione");
				ItemDao dao = DaoFactory.createItemNativeDao();
				
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

				ItemService service = new ItemService();
				
				Utils.stampaLista(Arrays.asList(service.findItemById(2)));
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
				
				ItemService service = new ItemService();
				
				service.deleteItem(service.findItemById(3));
				
				break;
			}
			case "7": {

				System.out.println("Stampa lista articoli validi alla data");

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				ItemService service = new ItemService();

				List<Item> list = service.findByValidDate(sdf.parse("05/12/2019"));
				
				Utils.stampaLista(list);
				
				break;
			}
			case "8": {

				System.out.println("Stampa lista articoli (paginata)");

				ItemService service = new ItemService();

				List<Item> list = service.findLimitResults(2, 3);
				
				Utils.stampaLista(list);
				
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
