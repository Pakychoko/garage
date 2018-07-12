package vehicles;

public class MotorBike extends AbstractVehicle{

	private String plate;
	
	public MotorBike(String plate, String color, String model) {
		super(color, model, 2);
		this.plate = plate;
	}

	@Override
	public String toString() {

		return plate + "\t\t\t\t" + AbstractVehicle.getModel() + "\n";
		
	}

	/**
	 * @return the plate
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * @param plate the plate to set
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}
	

}
