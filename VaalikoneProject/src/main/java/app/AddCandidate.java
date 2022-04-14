package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.dao.Dao;
import app.model.Candidate;
import app.security.SecurityUtils;

@WebServlet(
		name = "AddCandidate",
		urlPatterns = {"/addcandidate"}
		)
// made by Rasmus
public class AddCandidate extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		// if sessions does not exist, create new one
		HttpSession session = request.getSession(false);
		if (SecurityUtils.isUserLogged(session)) {
			 response.getWriter().println("Logged in");
			
		}else
		{ response.getWriter().println("Sinun pitää kirjautua");
		response.sendRedirect("/showdata");
		}


		 
		RequestDispatcher rd=request.getRequestDispatcher("form.html");
		rd.include(request,  response);;
		
		// Read parameters to Model
		Candidate candidate=readCandidate(request);
	
		// Create connection
		Dao dao=new Dao();
		
		// Save value and query total list
		dao.saveCandidate(candidate);
		
		
		// print output and close connection
		
		dao.close();
		
		
		
		
		
		 
		response.sendRedirect("/showdata");
		rd.include(request,  response);;
	}


	private Candidate readCandidate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Candidate candidate=new Candidate();
		candidate.setSukunimi(request.getParameter("sukunimi"));
		candidate.setEtunimi(request.getParameter("etunimi"));
		candidate.setPuolue(request.getParameter("puolue"));
		candidate.setKotipaikkakunta(request.getParameter("kotipaikkakunta"));
		candidate.setIka(Integer.parseInt(request.getParameter("ika")));
		candidate.setMiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
		candidate.setMita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		candidate.setAmmatti(request.getParameter("ammatti"));
		candidate.setEhdokas_id(Integer.parseInt(request.getParameter("ehdokas_id")));
		return candidate;
	}

}


