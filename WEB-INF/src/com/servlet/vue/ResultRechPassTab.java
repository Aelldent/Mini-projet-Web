package com.servlet.vue;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultRechPassTab extends HttpServlet 
{
	private ArrayList<String> entete;
	private ArrayList<String> caseTableau;
	
	public void doGet(	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		try 
		{	
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/VINYLCOLLECTION";
			String user = "root";
			String passwd = "steeve";
			
			Connection conn = DriverManager.getConnection(url, user, passwd);
			
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM Track");
			ResultSetMetaData resultMeta = result.getMetaData();
			
			String nomArtiste=request.getParameter("nomArtiste");
			String titreSoundtrack=request.getParameter("titreSoundtrack");
			
			
			//On affiche le nom des colonnes
			for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
			{
				entete.add(resultMeta.getColumnName(i).toString());
			}
			request.setAttribute("entete", this.entete);
			//String[] enteteRetour = request.getParameterValues("entete");
				
			
			if ((nomArtiste.length() == 0) || (titreSoundtrack.length() == 0))//les champs sont vides
			{
				PreparedStatement reqNN = conn.prepareStatement("SELECT * FROM Track");
				ResultSet resultQuery = reqNN.executeQuery();
				
				while(resultQuery.next())
				{
					for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
					{
						caseTableau.add(resultQuery.getObject(i).toString());
					}		
				}
				request.setAttribute("casetableau", this.caseTableau);
				reqNN.close();
				//String[] caseTableauRetour = request.getParameterValues("caseTableau");
			}
			else 
			{
				if ((nomArtiste.length() != 0) && (titreSoundtrack.length() != 0))//les champs sont non vides
				{
					PreparedStatement reqNN = conn.prepareStatement("SELECT * FROM Track WHERE title = ? and artist=?");
					reqNN.setString(1,titreSoundtrack);
					reqNN.setString(2,nomArtiste);
					ResultSet resultQuery = reqNN.executeQuery();
					
	
					while(resultQuery.next())
					{
						for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
						{
							caseTableau.add(resultQuery.getObject(i).toString());

						}		
					}
					//request.setAttribute("casetableau", this.caseTableau);
					reqNN.close();
				}
				else
				{
					if (nomArtiste.length() != 0)//les champs sont non vides
					{
						PreparedStatement reqNN = conn.prepareStatement("SELECT * FROM Track WHERE artist=?");
						reqNN.setString(1,nomArtiste);
						ResultSet resultQuery = reqNN.executeQuery();
						while(resultQuery.next())
						{
							for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
							{
								caseTableau.add(resultQuery.getObject(i).toString());

							}		
						}
						//request.setAttribute("casetableau", this.caseTableau);
						//String[] caseTableauRetour = request.getParameterValues("caseTableau");
					}
					else
					{
						if (titreSoundtrack.length() != 0)//les champs sont non vides
						{
							PreparedStatement reqNN = conn.prepareStatement("SELECT * FROM Track WHERE title=?");
							reqNN.setString(1,titreSoundtrack);
							ResultSet resultQuery = reqNN.executeQuery();
			
							while(resultQuery.next())
							{
								for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
								{
									caseTableau.add(resultQuery.getObject(i).toString());

								}		
							}
							//request.setAttribute("casetableau", this.caseTableau);
							reqNN.close();
							//String[] caseTableauRetour = request.getParameterValues("caseTableau");
						}
					}
				}
			}
			request.setAttribute("casetableau", this.caseTableau);
			conn.close();
			request.getRequestDispatcher("ResultRechList.jsp").forward(request, response);
			
		} 
		catch (SQLException sqle)
		{
			request.getRequestDispatcher("pageErreur.jsp").forward(request, response);
		}
		catch (Exception e)
		{
			request.getRequestDispatcher("pageErreur.jsp").forward(request, response);
			//e.printStackTrace();
		}	
	}
	
	public void doPost(	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		doGet(request, response);		
	}
}
