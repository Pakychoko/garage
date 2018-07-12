package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Iterator;

import clients.Client;
import vehicles.Vehicle;

public interface ClientDaoJDBC<E extends Vehicle> {

	Client create(Client client);
	Client readById();
	boolean delete();
	Iterator<E> readAll();
	
	Connection getConnection() throws Exception;
}
