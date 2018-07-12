package main;

import java.util.Scanner;

import dao.BicycleDAO;
import dao.CarDAO;
import dao.MotorBikeDAO;

import manager.BicycleManager;
import manager.CarManager;
import manager.MotorBikeManager;
import mingorance.enrique.commandlinemenu.Menu;
import mingorance.enrique.commandlinemenu.MenuBuilder;
import vehicles.Bicycle;
import vehicles.Car;
import vehicles.MotorBike;

public class GarageMenu {

	static Scanner in = new Scanner(System.in);
	
	public static Menu generateMenu() {
		
		Menu submenu1 = MenuBuilder.createSubMenu("Cars", 1)
	            .addSimpleOption(1, "1. List")
	            .addSimpleOption(2, "2. Save")
	            .addSimpleOption(3, "3. Delete")
	            .addExitOption(4, "4. Exit")
	            .build();
	    Menu submenu2 = MenuBuilder.createSubMenu("Motorbikes", 2)
	            .addSimpleOption(1, "1. List")
	            .addSimpleOption(2, "2. Save")
	            .addSimpleOption(3, "3. Delete")
	            .addExitOption(4, "4. Exit")
	            .build();
	    Menu submenu3 = MenuBuilder.createSubMenu("Bicycles", 3)
	            .addSimpleOption(1, "1. List")
	            .addSimpleOption(2, "2. Save")
	            .addSimpleOption(3, "3. Delete")
	            .addExitOption(4, "4. Exit")
	            .build();
	
	    return MenuBuilder.createMainMenu("AWESOME MENU")
	            .addSubMenuOption("1. Cars", submenu1)
	            .addSubMenuOption("2. Motorbikes", submenu2)
	            .addSubMenuOption("3. Bicycles", submenu3)
	            .addSimpleOption(4, "Options")
	            .addExitOption(0, "Exit")
	            .build();
	    
	    
	}
	
	public static void executeMenu(String option) {
		
		switch (option) {
		case "1.1":
			System.out.println(CarDAO.getInstance().list());
			break;
		case "1.2":
			CarDAO.getInstance().save(carBuilder());
			break;
		case "1.3":
			CarDAO.getInstance().delete(selectCar());
			break;
		case "2.1":
			System.out.println(MotorBikeDAO.getInstance().list());
			break;
		case "2.2":
			MotorBikeDAO.getInstance().save(motorBikeBuilder());
			break;
		case "2.3":
			MotorBikeDAO.getInstance().delete(selectMotorBike());
			break;
		case "3.1":
			System.out.println(BicycleDAO.getInstance().list());
			break;
		case "3.2":
			BicycleDAO.getInstance().save(bicycleBuilder());
			break;
		case "3.3":
			BicycleDAO.getInstance().delete(selectBicycle());
			break;
		}
	}
	
	
	private static Car carBuilder() {
		System.out.println("Introduzca matr�cula");
		String matricula = in.nextLine();
		System.out.println("Introduzca color");
		String color = in.nextLine();
		System.out.println("Introduzca modelo");
		String modelo = in.nextLine();

		return new Car(matricula, color, modelo);
	}

	private static Car selectCar() {
		System.out.println(CarManager.getInstance().list());
		System.out.println("Selecciona un elemento de la lista");
		int elemento = in.nextInt();
		return CarManager.getInstance().get(elemento - 1);
	}

	private static MotorBike motorBikeBuilder() {
		System.out.println("Introduzca matr�cula");
		String matricula = in.nextLine();
		System.out.println("Introduzca color");
		String color = in.nextLine();
		System.out.println("Introduzca modelo");
		String modelo = in.nextLine();

		return new MotorBike(matricula, color, modelo);
	}

	private static MotorBike selectMotorBike() {
		System.out.println(MotorBikeManager.getInstance().list());
		System.out.println("Selecciona un elemento de la lista: ");
		int elemento = in.nextInt();
		return MotorBikeManager.getInstance().get(elemento - 1);
	}

	private static Bicycle bicycleBuilder() {

		System.out.println("Introduzca color");
		String color = in.nextLine();
		System.out.println("Introduzca modelo");
		String modelo = in.nextLine();

		return new Bicycle(color, modelo);
	}

	private static Bicycle selectBicycle() {
		System.out.println(BicycleManager.getInstance().list());
		System.out.println("Selecciona un elemento de la lista");
		int elemento = in.nextInt();
		return BicycleManager.getInstance().get(elemento - 1);
	}
}
