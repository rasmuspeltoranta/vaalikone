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
		name = "ShowData",
		urlPatterns = {"/showdata"}
		)
// made by Rasmus
public class ShowData extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
	

		// if sessions does not exist, create new one
				HttpSession session = request.getSession(false);
				if (SecurityUtils.isUserLogged(session)) {
					 response.getWriter().println("Logged in");
					
				}else
				{ response.getWriter().println("Sinun pitää kirjautua");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				 rd.forward(request, response);
				}
		
		Dao dao = new Dao();
		ArrayList<Candidate> candidates = dao.readAllCandidates();
		
		session.setAttribute("allcandidates", candidates);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/showall.jsp");
		rd.forward(request, response);
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}

}