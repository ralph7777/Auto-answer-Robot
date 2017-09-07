package com.ralph.servlet;

import java.io.IOException;
import java.util.List;

import javax.activation.MailcapCommandMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import com.ralph.bean.Player;
import com.ralph.service.QueryService;
import com.ralph.service.MaintainService;

/*
 * Servlet for deleting one record
 */
public class DeleteOneServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Set character encoding
		req.setCharacterEncoding("UTF-8");
		
		//Get id info from the page
		String id=req.getParameter("id");
		
		//Search player list and post to page
		MaintainService maintainService=new MaintainService();
		maintainService.deleteOne(id);
				
		//Redirect page
		req.getRequestDispatcher("/List.action").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
