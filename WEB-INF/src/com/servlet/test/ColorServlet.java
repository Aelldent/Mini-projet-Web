package com.servlet.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.test.model.ColorModel;

public class ColorServlet extends HttpServlet 
{

	public void doGet (HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException
						{
							request.setAttribute("colorString", new ColorModel().getColor());
							request.getRequestDispatcher("colorJsp.jsp").forward(request, response);		
						}
	
}
