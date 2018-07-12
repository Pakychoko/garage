package dao;

import java.util.List;

import fileManager.FileManager;
import vehicles.Bicycle;
import vehicles.Car;
import vehicles.MotorBike;

public class FileDAO {

	public static void loadData() {
		
		List<List> bicycles = FileManager.loadData("./src/com/everis/alicante/courses/beca/garage/bicycles.txt");
		
		for(List b: bicycles) {
			System.out.println(b.get(0).toString());
			BicycleDAO.getInstance().save(new Bicycle(b.get(0).toString(), b.get(1).toString()));
		}
		
		List<List> motorbikes = FileManager.loadData("./src/com/everis/alicante/courses/beca/garage/motorbikes.txt");
		
		for(List b: motorbikes) {
			MotorBikeDAO.getInstance().save(new MotorBike(b.get(0).toString(), b.get(1).toString(), b.get(2).toString()));
		}
		
		List<List> cars = FileManager.loadData("./src/com/everis/alicante/courses/beca/garage/cars.txt");
		
		for(List b: cars) {
			CarDAO.getInstance().save(new Car(b.get(0).toString(), b.get(1).toString(), b.get(2).toString()));
		}
		
	}
}
