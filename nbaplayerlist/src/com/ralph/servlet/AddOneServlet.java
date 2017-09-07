package com.ralph.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ralph.service.MaintainService;

public class AddOneServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Set character encoding
		req.setCharacterEncoding("UTF-8");
		
		//Get id info from the page
		String name=req.getParameter("nameAdd");
		String team=req.getParameter("teamAdd");
		String number=req.getParameter("numberAdd");
		
		//Search player list and post to page
		MaintainService maintainService=new MaintainService();
		maintainService.addOne(name, team, number);;
				
		//Redirect page
		req.getRequestDispatcher("/List.action").forward(req, resp);
		
	}
	
	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
