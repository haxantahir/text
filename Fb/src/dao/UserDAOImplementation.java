package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 

import model.Login;

import util.UserUtil;

public class UserDAOImplementation implements UserDAO {
	 private Connection conn;
	 
	    public UserDAOImplementation() {
	        conn = UserUtil.getConnection();
	    }
	    @Override
	    public void addUser( Login log ) {
	        try {
	            String query = "insert into reg (email,password,firstname,lastname,dob,gender) values (?,?,?,?,?,?)";
	            PreparedStatement preparedStatement = conn.prepareStatement( query );
	            preparedStatement.setString( 1, log.getEmail() );
	            preparedStatement.setString( 2, log.getPassword() );
	            preparedStatement.setString( 3, log.getFirstname() );
	            preparedStatement.setString( 4, log.getLastname() );
	            
	            preparedStatement.setString( 5, log.getDob() );
	            preparedStatement.setString( 6, log.getGender() );
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	   
	    
	  
		
			  
			
		}

