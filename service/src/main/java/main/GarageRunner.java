package main;

import dao.FileDAO;

public class GarageRunner {


		public static void main(String[] args) {

			FileDAO.loadData();

			String option;

			do {
				
				option = GarageMenu.generateMenu().play();
				GarageMenu.executeMenu(option);
				
			} while (!option.equals("0"));

		}
		
		


	

}
