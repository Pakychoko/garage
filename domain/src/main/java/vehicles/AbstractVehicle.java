package vehicles;

public abstract class AbstractVehicle implements Vehicle{

	private String color;
	
	private static String model;
	
	private Integer numWheels;
	
	public AbstractVehicle(String color, String model, Integer numWheels) {
		this.color = color;
		AbstractVehicle.model = model;
		this.numWheels = numWheels;
	}
	
	public abstract String toString();


	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the model
	 */
	public static String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		AbstractVehicle.model = model;
	}

	/**
	 * @return the numWheels
	 */
	public Integer getNumWheels() {
		return numWheels;
	}

	/**
	 * @param numWheels the numWheels to set
	 */
	public void setNumWheels(Integer numWheels) {
		this.numWheels = numWheels;
	}
}
