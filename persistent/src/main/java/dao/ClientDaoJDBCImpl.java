package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import clients.Client;
import vehicles.Vehicle;

public class ClientDaoJDBCImpl implements ClientDaoJDBC<Vehicle> {
	
	private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
	private String user = "root";
	private String pass = "admin";
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String urlDB = "jdbc:mysql://localhost:3306/garage?serverTimezone=UTC";


	@Override
	public Client create(Client client) {
        
		try {
			
			statement = connection.createStatement();
			preparedStatement = connection.prepareStatement("insert into  garage.clients values ( ?, ?, ?, ?)");
			
	        preparedStatement.setString(1, client.getDni());
	        preparedStatement.setString(2, client.getName());
	        preparedStatement.setString(3, client.getSurname());
	        java.util.Date date = new java.util.Date();
	        preparedStatement.setDate(4, new java.sql.Date(date.getTime()));
	        preparedStatement.executeUpdate();

	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return client;
	}

	@Override
	public Client readById() {	
       
		Client c = new Client();
		
        try {
        	preparedStatement = connection.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from new_schema.comments");
			resultSet = preparedStatement.executeQuery();
			
	        c.setDni(resultSet.getString(0));
	        c.setName(resultSet.getString(1));
	        c.setSurname(resultSet.getString(2));
	        c.setBirth((Date)(resultSet.getObject(3)));
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return c;

	}

	@Override
	public boolean delete() {
		
        try {
			preparedStatement = connection.prepareStatement("delete from new_schema.comments where myuser= ? ; ");
	        preparedStatement.setString(1, "Test");
	        preparedStatement.executeUpdate();
	        return true;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
		return false;
	}

	@Override
	public ResultSet readAll() {

        try {
        	preparedStatement = connection.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from new_schema.comments");
			resultSet = preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return resultSet;
	}

	@Override
	public Connection getConnection() throws Exception {
		
    	try {
            Class.forName(driver);
            System.out.println("MySQL JDBC Driver Registered!");

            try {
                connection = DriverManager.getConnection(urlDB, user, pass);
                
            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            throw e;
            
        } 
          
    	return connection;
        
	}
	
	
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {

        }
    }

}
