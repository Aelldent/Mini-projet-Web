package com.servlet.main;

import java.sql.*;

import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

public class mainBD extends HttpServlet
{
	public static void main(String[] args) throws ClassNotFoundException 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DRIVER OK ! ");
			
			String url = "jdbc:mysql://localhost:3306/VINYLCOLLECTION";
			String user = "root";
			String passwd = "steeve";
			
			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connection effective !");
			
			/*PreparedStatement prep1 = conn.prepareStatement("insert into Users set User=? , motDePasse=? ");
			prep1.setString(1,"Billy");
			prep1.setString(2,"billy");
			prep1.executeUpdate();*/
			
			//Création d'un objet Statement
			Statement state = conn.createStatement();
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery("SELECT * FROM Users");
			//On récupère les MetaData
			ResultSetMetaData resultMeta = result.getMetaData();
			
			System.out.println("\n**********************************");
			//On affiche le nom des colonnes
			for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
				System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
			
			System.out.println("\n**********************************");
			
			while(result.next())
			{			
				for(int i = 1; i <=  resultMeta.getColumnCount(); i++)
					System.out.print("\t" + result.getObject(i).toString() + "\t |");
				
				System.out.println("\n---------------------------------");
			
			//L'objet ResultSet contient le résultat de la requête SQL
			

			}
			String nom = "GammaRay";
			PreparedStatement prep2 = conn.prepareStatement("SELECT * FROM Track WHERE artist = ?");
			prep2.setString(1,nom);
			ResultSet resultQuery = prep2.executeQuery();
			ResultSetMetaData resultQueryMeta = resultQuery.getMetaData();
			System.out.println("\n**********************************");
			//On affiche le nom des colonnes
			if (nom.equals(""))
			{
				System.out.println("c null");
			}
			for(int i = 1; i <=  resultQueryMeta.getColumnCount(); i++)
				System.out.print("\t" + resultQueryMeta.getColumnName(i).toUpperCase() + "\t *");
			
			System.out.println("\n**********************************");
			
			while(resultQuery.next())
			{			
				for(int i = 1; i <=  resultQueryMeta.getColumnCount(); i++)
					System.out.print("\t" + resultQuery.getObject(i).toString() + "\t |");
				
				System.out.println("\n---------------------------------");
			}
		} 
		catch (SQLException e)
		{
			System.out.println("sa aaaaaaaaaaaaaaaaaaaaa marche pas");
			e.printStackTrace();
		}
		
	}

}
