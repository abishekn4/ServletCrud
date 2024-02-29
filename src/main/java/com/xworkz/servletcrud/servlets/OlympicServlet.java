package com.xworkz.servletcrud.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.servletcrud.dto.SportsDto;
import com.xworkz.servletcrud.service.OlympicsService;
import com.xworkz.servletcrud.service.OlympicsServiceImpl;


@WebServlet("/saveSport")
public class OlympicServlet extends HttpServlet{
	
	private OlympicsService service = new OlympicsServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String sportName = req.getParameter("sportName");
		String sportType = req.getParameter("sportType");
		String equipment = req.getParameter("equipment");
		String noOfPlayers = req.getParameter("noOfPlayers");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		SportsDto dto =	new SportsDto(Integer.valueOf(id), sportName, Integer.valueOf(noOfPlayers), sportType, equipment);
		
		boolean isExisting = false;
		
		if(sportName!=null && !sportName.isEmpty()) {
			SportsDto foundDto = service.findByName(sportName);
			if(foundDto==null) {
				
				boolean result = service.validateAndAdd(dto);
				
				
				if(result) {
					writer.print("<h1>Sport Saved Successfully</h1>");
				}
				else {
					req.getRequestDispatcher("Register.html").include(req, resp);
					writer.print("<h1>Sport is Not valid or Check the Server</h1>");
				}
				
				
			}
			else {
				req.getRequestDispatcher("Register.html").include(req, resp);
				writer.print("<h1>SportName is Already Present</h1>");
			}
			
			
		}
		else {
			req.getRequestDispatcher("Register.html").include(req, resp);
			writer.print("<h1>SportName is Not valid , Please enter Sport Name</h1>");
			
		}
		
	}

}
