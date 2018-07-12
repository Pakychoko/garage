package vehicles;

public class Bicycle extends AbstractVehicle{

	private String color, model;
	private Integer numWheels;

	public Bicycle(String color, String model) {
		super(color, model, 2);
	}

	@Override
	public String toString() {
		return this.color + "\t\t\t\t" + AbstractVehicle.getModel() + "\n";
	}

}
