package com.servlet.vue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class newUser extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//on charge la bd
		try 
		{
			String newMdp=request.getParameter("newMdp");
			String newLog=request.getParameter("newLog");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/VINYLCOLLECTION";
			String user = "root";
			String passwd = "steeve";
			
			Connection conn = DriverManager.getConnection(url, user, passwd);
			

			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM Users");
			//ResultSetMetaData resultMeta = result.getMetaData();
			
			if ((newMdp.length() == 0) || (newLog.length() == 0))
			{
				conn.close();
				request.getRequestDispatcher("userDejaUtilise.jsp").forward(request, response);
			}
			else 
			{
				int pasBon = 0;
				while(result.next())
				{
					if ((result.getObject(1).equals(newLog)) && (result.getObject(2).equals(newMdp)))
					{
						conn.close();
						request.getRequestDispatcher("userDejaUtilise.jsp").forward(request, response);
						pasBon = 1;
					}
				}
				if (pasBon == 0)
				{
					//maj de la table
					PreparedStatement prep1 = conn.prepareStatement("insert into Users set User=? , motDePasse=? ");
					prep1.setString(1,newLog);
					prep1.setString(2,newMdp);
					prep1.executeUpdate();
					
					conn.close();
					request.getRequestDispatcher("newUser.jsp").forward(request, response);
				}
			}
		} 
		catch (ClassNotFoundException e) 
		{
			
		} 
		catch (SQLException e) 
		{
			request.getRequestDispatcher("pageErreur.jsp").forward(request, response);
		}
	}
	
	public void doPost(	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		doGet(request, response);		
	}
}
