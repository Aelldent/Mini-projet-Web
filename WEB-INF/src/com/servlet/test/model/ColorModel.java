package com.servlet.test.model;

public class ColorModel 
{
	private String[] colors = new String[]{"red", "green", "yellow", "purple", "pink", "silver", "orange"};
	private String color;
	
	public ColorModel()
	{
		this.color = colors[Double.valueOf(Math.random()*7).intValue()];
	}
	
	public String getColor()
	{
		return this.color;
	}
}
