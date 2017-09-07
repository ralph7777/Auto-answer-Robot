package com.ralph.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ralph.bean.Player;
import com.ralph.service.QueryService;

/**
 * 
 * Automatic Query Module servlet
 *
 */

public class AutoReplyServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");

		PrintWriter out = resp.getWriter();
		QueryService queryService = new QueryService();
		
		//Query by player name
		String reply=queryService.queryByName(req.getParameter("content"));
		
		//Query by team name: one-to-many relationship
//		String reply=queryService.queryByTeam(req.getParameter("content"));
		out.write(reply);
		out.flush();
		out.close();
	}
		
		@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
		
	
}
