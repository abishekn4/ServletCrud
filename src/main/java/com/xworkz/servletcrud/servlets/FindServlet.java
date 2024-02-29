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

@WebServlet(value = "/find")
public class FindServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();

		String tempId = req.getParameter("id");
		int id;
		if (!tempId.isEmpty()) {
			id = Integer.valueOf(tempId);

			
			if (id > 0) {

				OlympicsService service = new OlympicsServiceImpl();

				SportsDto foundDto = service.findById(id);
				
				if(foundDto!=null) {
					
					req.getRequestDispatcher("Find.html").include(req, resp);

					writer.print("<h2>Id : " + foundDto.getId());
					writer.print("<h2>Sport Name : " + foundDto.getSportName());
					writer.print("<h2>Type : " + foundDto.getSportType());
					writer.print("<h2>Equipment: " + foundDto.getEquipment());
					writer.print("<h2>No Of Players : " + foundDto.getNoOfPlayers());
				}
				else {
					
					req.getRequestDispatcher("Find.html").include(req, resp);

					writer.print("<h2 style=\"color:blue;\">Id is not found</h2>");
					
				}

			

			}

			else {
				System.out.println("Id is 0");
				req.getRequestDispatcher("Find.html").include(req, resp);

				writer.print("<h1 style=\"color:red;\">Id is Invalid</h1>");

			}
		} else {
			System.out.println("Id is blank");
			req.getRequestDispatcher("Find.html").include(req, resp);

			writer.print("<h2 style=\"color:red;\">Please enter a number</h2>");
				

		}

	}

}
