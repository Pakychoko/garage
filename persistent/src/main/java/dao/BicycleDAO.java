package dao;

import vehicles.Bicycle;

public class BicycleDAO extends AbstractGarageDAO<Bicycle>{

	private static BicycleDAO instance;

	private BicycleDAO() {
	}

	public static BicycleDAO getInstance() {
		if (instance == null) {
			instance = new BicycleDAO();
		}
		return instance;
	}
	
	
}
