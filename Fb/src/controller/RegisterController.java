package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import dao.UserDAO;
import dao.UserDAOImplementation;
import model.Login;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



@WebServlet("/RegisterController")

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String uname;
    String upass;
    Statement stmt;
    ResultSet rs;
    RequestDispatcher dispatch;
    private static Connection conn;
	private UserDAO lo;
  
    public RegisterController() {
       lo=new UserDAOImplementation();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Login l = new Login();
        l.setEmail( request.getParameter( "email" ) );
        l.setPassword( request.getParameter( "password" ) );
        l.setFirstname( request.getParameter( "firstname" ) );
        l.setLastname( request.getParameter( "lastname" ) );
        l.setDob( request.getParameter( "dob" ) );
        l.setGender( request.getParameter( "gender" ) );
        
       lo.addUser(l);
       
       dispatch=request.getRequestDispatcher("login.jsp");       
       dispatch.forward(request, response);
		
		
	}

}
