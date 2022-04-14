package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.dao.Dao;
import app.model.Candidate;
@WebServlet(
		name = "RemoveCandidate",
		urlPatterns = {"/removecandidate"}
		)
// made by Rasmus


public class RemoveCandidate extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF_8");
		response.sendRedirect("/showdata");
		Dao dao= new Dao();
		Candidate candidate = readCandidate(request);
		dao.RemoveCandidate(candidate.getEhdokas_id());
		dao.close();
		
		response.sendRedirect("/showdata");

	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
			response.sendRedirect("/showdata"); }
		
	
	private Candidate readCandidate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Candidate candidate=new Candidate();
		
		candidate.setEhdokas_id(Integer.parseInt(request.getParameter("ehdokas_id")));
		return candidate;
	}

}



	


