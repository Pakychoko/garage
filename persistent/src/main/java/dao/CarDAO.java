package dao;

import vehicles.Car;

public class CarDAO extends AbstractGarageDAO<Car>{
	
	private static CarDAO instance;

	private CarDAO() {
	}

	public static CarDAO getInstance() {
		if (instance == null) {
			instance = new CarDAO();
		}
		return instance;
	}
	
	
}
