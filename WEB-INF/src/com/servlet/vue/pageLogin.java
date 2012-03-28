package com.servlet.vue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class pageLogin extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
			{
				//on charge la bd
				/*try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("DRIVER OK ! ");
					
					String url = "jdbc:mysql://localhost:3306/VINYLCOLLECTION";
					String user = "steeve";
					String passwd = "steeve";
					
					Connection conn = DriverManager.getConnection(url, user, passwd);
					System.out.println("Connection effective !");
					
					//création du contexte
					ServletContext context = getServletContext();
					context.setAttribute("connection", conn);
					conn.close();
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
					request.getRequestDispatcher("pageErreur.jsp").forward(request, response);
				} 
				catch (SQLException e) 
				{
					request.getRequestDispatcher("pageErreur.jsp").forward(request, response);
					e.printStackTrace();
				}*/
				
				RequestDispatcher dispatch = request.getRequestDispatcher("testJsp.jsp");
				dispatch.forward(request, response);
			}	
}
