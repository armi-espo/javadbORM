package it.jac.javadb;

import java.util.Scanner;

import it.jac.javadb.dao.CittaDao;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("App Started");

		do {

			System.out.print("Scegliere la funzione: ");
			Scanner in = new Scanner(System.in);
			String s = in.nextLine();

			switch (s) {
			case "1": {

				System.out.println("Test connessione");
				CittaDao dao = new CittaDao();
				
				boolean test = dao.testConnessione();
				if (test) {
				
					System.out.println("Test OK");
				}
				
				break;
			}
			case "2": {

				System.out.println("Stampa lista");

				CittaDao dao = new CittaDao();
				
				break;
			}
			default: {

				System.out.println("Scelta non gestita, l'applicazione termina");
				return;
			}
			}

		} while (true);

	}
}
