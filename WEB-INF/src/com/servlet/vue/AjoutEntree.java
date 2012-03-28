package com.servlet.vue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjoutEntree extends HttpServlet 
{
	public void doGet(	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		try 
		{	
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/VINYLCOLLECTION";
			String user = "root";
			String passwd = "steeve";
			
			Connection conn = DriverManager.getConnection(url, user, passwd);
			
			//String album=request.getParameter("nomAlbum");
			String soundtrack=request.getParameter("titreSoundtrack");
			String artist=request.getParameter("nomArtiste");
			
			
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM Track");
			ResultSetMetaData resultMeta = result.getMetaData();
			
			while (result.next())
			{
				if ((result.getObject(1).equals(soundtrack)) && (result.getObject(2).equals(artist)))//mm chanson et mm artist : pas bon
				{
					conn.close();
					request.getRequestDispatcher("dejaEntree.jsp").forward(request, response);
				}
			}
			//maj de la table
			PreparedStatement prep1 = conn.prepareStatement("insert into Track set title='?' , artist='?' ");
			prep1.setString(1,soundtrack);
			prep1.setString(2,artist);
			prep1.executeQuery();
			
			conn.close();
			request.getRequestDispatcher("ajoutEntree.jsp").forward(request, response);
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
	}
	
	public void doPost(	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		doGet(request, response);		
	}
}
