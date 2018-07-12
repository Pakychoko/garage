package dao;

import vehicles.MotorBike;

public class MotorBikeDAO extends AbstractGarageDAO<MotorBike>{

	private static MotorBikeDAO instance;

	private MotorBikeDAO() {
	}

	public static MotorBikeDAO getInstance() {
		if (instance == null) {
			instance = new MotorBikeDAO();
		}
		return instance;
	}
	
	
}
