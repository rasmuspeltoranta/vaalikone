package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.Dao;
@WebServlet(
		name = "RemoveCandidate",
		urlPatterns = {"/removecandidate"}
		)


public class RemoveCandidate extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF_8");
		response.sendRedirect("/showdata");
		Dao dao= new Dao();
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		response.sendRedirect("/showdata");
	}
}
