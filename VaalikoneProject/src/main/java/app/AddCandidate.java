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

import app.dao.Dao;
import app.model.Candidate;

@WebServlet(
		name = "AddCandidate",
		urlPatterns = {"/addcandidate"}
		)

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

		/*
		 * With a RequestDispatcher object is the htmlstart.html file included to this servlet
		 */
		RequestDispatcher rd=request.getRequestDispatcher("staticpages/htmlstart.html");
		rd.include(request,  response);;
		
		// Read parameters to Model
		Candidate candidate=readCandidate(request);
	
		// Create connection
		Dao dao=new Dao();
		
		// Save value and query total list
		dao.saveCandidate(candidate);
		ArrayList<Candidate> list=dao.readAllCandidates();
		
		// print output and close connection
		printCandidateList(out, list);
		dao.close();
		
		
		out.println("<br><a href='./form.html'>Back to form</a>");

		/*
		 * With a RequestDispatcher object is the htmlend.html file included to this servlet
		 */
		rd=request.getRequestDispatcher("staticpages/htmlend.html");
		rd.include(request,  response);;
	}


	private Candidate readCandidate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Candidate candidate=new Candidate();
		candidate.setSukunimi(request.getParameter("SUKUNIMI"));
		candidate.setEtunimi(request.getParameter("ETUNIMI"));
		candidate.setPuolue(request.getParameter("PUOLUE"));
		candidate.setKotipaikkakunta(request.getParameter("KOTIPAIKKAKUNTA"));
		candidate.setIka(Integer.parseInt(request.getParameter("IKA")));
		candidate.setMiksi_eduskuntaan(request.getParameter("MIKSI_EDUSKUNTAAN"));
		candidate.setMita_asioita_haluat_edistaa(request.getParameter("MITA_ASIOITA_HALUAT_EDISTAA"));
		candidate.setAmmatti(request.getParameter("AMMATTI"));
		candidate.setEhdokas_id(Integer.parseInt(request.getParameter("EHDOKAS_ID")));
		return candidate;
	}
	
	private void printCandidateList(PrintWriter out, ArrayList<Candidate> list) {
		out.println("<ul>");
		for (Candidate g:list) {
			out.println("<li>"+g);
		}
		out.println("</ul>");
	}

}


