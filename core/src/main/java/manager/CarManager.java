package manager;

import vehicles.Car;


public class CarManager extends AbstractVehicleManager<Car>{

	private static CarManager instance;

	private CarManager() {
	}

	public static CarManager getInstance() {
		if (instance == null) {
			instance = new CarManager();
		}
		return instance;
	}


}
