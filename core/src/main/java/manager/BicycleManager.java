package manager;

import vehicles.Bicycle;

public class BicycleManager extends AbstractVehicleManager<Bicycle> {

	private static BicycleManager instance;

	private BicycleManager() {
	}

	public static BicycleManager getInstance() {
		if (instance == null) {
			instance = new BicycleManager();
		}
		return instance;
	}

}
