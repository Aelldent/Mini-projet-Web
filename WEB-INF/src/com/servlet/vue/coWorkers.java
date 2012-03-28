package com.servlet.vue;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

public class coWorkers extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException
			{
				//on charge la bd
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("DRIVER OK ! ");
					
					String url = "jdbc:mysql://localhost:3306/VINYLCOLLECTION";
					String user = "root";
					String passwd = "steeve";
					
					HttpSession session = request.getSession();
					String log= (String) session.getAttribute("log");
					
					java.sql.Connection conn = DriverManager.getConnection(url, user, passwd);
					
					PreparedStatement reqNN = conn.prepareStatement("SELECT coWorker FROM coWorkers WHERE User = ?");
					reqNN.setString(1,log);
					ResultSet resultQuery = reqNN.executeQuery();
					//ResultSetMetaData resultMeta = resultQuery.getMetaData();
					
					ArrayList<String> listeCoW = new ArrayList<String>();
					while(resultQuery.next())
					{
						String retour = resultQuery.getObject(1).toString();
						listeCoW.add(retour);
					}
					
					request.setAttribute("listeCoW", listeCoW);
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
				}
				
				RequestDispatcher dispatch = request.getRequestDispatcher("coWorker.jsp");
				dispatch.forward(request, response);
			}
}
