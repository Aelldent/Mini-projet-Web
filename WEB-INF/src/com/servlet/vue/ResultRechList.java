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
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ResultRechList extends HttpServlet 
{
	private String entete = null;
	private String caseTableau = null;
	
	public void doGet(	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		try 
		{	
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			//out.println("<h1>Coucou toi !</h1>");
			
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
			
			out.write("<h1>"); out.write(nomArtiste); out.write("</h1>");
			out.write("<p>"); out.write("</p>");
			out.write("<h1>"); out.write(titreSoundtrack); out.write("</h1>");
			
			
			//creation du tableau
			out.write("<body>\n\n");
			out.write("<center>\n\n");
				out.write("<table>");
					out.write("<caption> Résultats recherche"); out.write("</caption>");
						//tete de tableau
						out.write("<thead>");//on récupere les entete de tableau
							out.write("<tr>");
							//On affiche le nom des colonnes
							for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
							{
								this.entete = resultMeta.getColumnName(i).toUpperCase();
								out.write("<th>"); out.write(this.entete);  out.write("</th>");
							}	
							out.write("</tr>");
						out.write("</thead>");
				
						//corps du tableau
						out.write("<tbody>");
			
						if ((nomArtiste.equals("")) && (titreSoundtrack.equals("")))//les champs sont non vides
						{
							PreparedStatement reqNN = conn.prepareStatement("SELECT * FROM Track");
							ResultSet resultQuery = reqNN.executeQuery();
							
							while(resultQuery.next())
							{
								out.write("<tr>");
								for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
								{
									this.caseTableau = resultQuery.getObject(i).toString();
									out.write("<td>"); out.write(this.caseTableau);  out.write("</td>");
								}	
								out.write("</tr>");
							}
						}
						else 
						{
							if ((!nomArtiste.equals("")) && (!titreSoundtrack.equals("")))//les champs sont non vides
							{
								PreparedStatement reqNN = conn.prepareStatement("SELECT * FROM Track WHERE title = ? and artist=?");
								reqNN.setString(1,titreSoundtrack);
								reqNN.setString(2,nomArtiste);
								ResultSet resultQuery = reqNN.executeQuery();
								
				
								while(resultQuery.next())
								{
									out.write("<tr>");
									for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
									{
										this.caseTableau = resultQuery.getObject(i).toString();
										out.write("<td>"); out.write(this.caseTableau);  out.write("</td>");
									}	
									out.write("</tr>");
								}
							}
							else
							{
								if (!nomArtiste.equals(""))//les champs sont non vides
								{
									PreparedStatement reqNN = conn.prepareStatement("SELECT * FROM Track WHERE artist=?");
									reqNN.setString(1,nomArtiste);
									ResultSet resultQuery = reqNN.executeQuery();
									while(resultQuery.next())
									{
										out.write("<tr>");
										for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
										{
											this.caseTableau = resultQuery.getObject(i).toString();
											out.write("<td>"); out.write(this.caseTableau);  out.write("</td>");
										}	
										out.write("</tr>");
									}
								}
								else
								{
									if (!titreSoundtrack.equals(""))//les champs sont non vides
									{
										PreparedStatement reqNN = conn.prepareStatement("SELECT * FROM Track WHERE title=?");
										reqNN.setString(1,titreSoundtrack);
										ResultSet resultQuery = reqNN.executeQuery();
						
										while(resultQuery.next())
										{
											out.write("<tr>");
											for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
											{
												this.caseTableau = resultQuery.getObject(i).toString();
												out.write("<td>"); out.write(this.caseTableau);  out.write("</td>");
											}	
											out.write("</tr>");
										}
									}
								}
							}
						}	
								
						out.write("</tbody>");
					out.write("</table>");
				out.write("</center>\n\n");
				out.write("</body>\n\n");
			
			request.getRequestDispatcher("ResultRechList.jsp").forward(request, response);
			conn.close();
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
