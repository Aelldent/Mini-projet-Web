package com.servlet.vue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultRech extends HttpServlet 
{
	public void doGet(	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		request.getRequestDispatcher("pageResultRech.jsp").forward(request, response);
	}
	
	public void doPost(	HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		doGet(request, response);		
	}
}
