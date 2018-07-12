package dao;

import java.util.ArrayList;
import java.util.List;

import vehicles.Vehicle;


public abstract class AbstractGarageDAO<T extends Vehicle> {
	
	List<T> elements = new ArrayList<>();
	
	protected List<T> getElements() {
		return elements;
	}
	
	public List<T> list() { return getElements(); }

	public void save(final T element) { getElements().add(element); }

	public void delete(final T element) { getElements().remove(element); }

	public T get(final int i) { return getElements().get(i); }
	

}
