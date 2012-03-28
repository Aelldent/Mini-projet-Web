package com.servlet.vue;

import java.io.IOException;

import java.sql.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

@SuppressWarnings("serial")
public class verifLog extends HttpServlet 
{
	public void doGet(	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		try 
		{	
			String log=request.getParameter("log");
			String mdp=request.getParameter("mdp");
			
			HttpSession session = request.getSession();
			session.setAttribute("log", log);
			
			
			if ((log.length() == 0) || (mdp.length() == 0))
			{
				//si champs vides
				request.getRequestDispatcher("mauvaisLogMdp.jsp").forward(request, response);
			}
				else
				{
				
					Class.forName("com.mysql.jdbc.Driver");
					
					String url = "jdbc:mysql://localhost:3306/VINYLCOLLECTION";
					String user = "root";
					String passwd = "steeve";
					
					Connection conn = DriverManager.getConnection(url, user, passwd);
					
					//méthode qui semble pas mal du tout
					PreparedStatement prep1 = conn.prepareStatement("SELECT * FROM Users WHERE User = ?");
					prep1.setString(1,log);
					ResultSet resultQuery = prep1.executeQuery();
					
					resultQuery.next();
					if (resultQuery.getObject(2).equals(mdp))
					{
						//le mdp est le bon
						conn.close();
						resultQuery.close();
						request.getRequestDispatcher("pagePrincipale.jsp").forward(request, response);
					}
					else
					{
						conn.close();
						resultQuery.close();
						request.getRequestDispatcher("mauvaisLogMdp.jsp").forward(request, response);
					}
				}
		} 
		catch (SQLException sqle)
		{
			request.getRequestDispatcher("pageErreur.jsp").forward(request, response);
		}
		catch (Exception e)
		{
			//request.getRequestDispatcher("pageErreur.jsp").forward(request, response);
			//e.printStackTrace();
		}	
		
		//doGet(request, response);
	}
	
	public void doPost(	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		doGet(request, response);		
	}

	
}
