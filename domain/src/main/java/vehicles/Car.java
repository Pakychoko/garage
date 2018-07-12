package vehicles;

public class Car extends AbstractVehicle{

	private String plate;
	
	public Car(String plate, String color, String model) {
		super(color, model, 4);
		this.plate = plate;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return plate + "\t\t\t\t" + AbstractVehicle.getModel() + "\n";
	}

	
	
	
}
