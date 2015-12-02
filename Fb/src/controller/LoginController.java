package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UserUtil;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
      String email;
      String upass;
      Statement stmt;
      ResultSet rs;
      RequestDispatcher dispatch;
     Connection conn;
     public LoginController(){
			con=UserUtil.getConnection();
			
		}
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		email=request.getParameter("email");        
		upass=request.getParameter("password");
		
			
		try {
			 String sql="SELECT * FROM fb.reg where email='"+email+"'and password='"+upass+"'";
			 PreparedStatement prep=con.prepareStatement(sql);
			 
			
			
		   
		    rs = prep.executeQuery(sql);
		   
		    if(rs.next()){
		    	if((email.equalsIgnoreCase(rs.getString("email")) &&  upass.equalsIgnoreCase(rs.getString("password")))){
			
				dispatch=request.getRequestDispatcher("home.jsp");
				dispatch.forward(request,response);
				 
				}
		
		} 
		    else{
			 	dispatch=request.getRequestDispatcher("error.jsp");
				dispatch.forward(request,response);
		 }
		    }catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
	}}
