package com.ralph.servlet;

import java.util.List;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ralph.bean.*;
import com.ralph.service.QueryService;

/**
 * Initialize the list page
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Set character encoding
		req.setCharacterEncoding("UTF-8");
		
		//Get filled-in info in page
		String name=req.getParameter("name");
		String team=req.getParameter("team");
		//Post info to page
		req.setAttribute("name", name);
		req.setAttribute("team", team);
		
		//Search player list and post to page
		QueryService listService=new QueryService();
		List<Player> playerList=listService.queryPlayerList(name, team);
		
		req.setAttribute("playerList", playerList);
		
		//Redirect page
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
