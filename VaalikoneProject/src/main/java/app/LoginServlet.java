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
import app.security.SecurityUtils;

@WebServlet(
	name = "LoginServlet",
	urlPatterns= {"/admin"}
	
)

public class LoginServlet extends HttpServlet {
	 @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		 response.sendRedirect("login.html");
}
	 @Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		 response.setContentType("text/html");
		 response.setCharacterEncoding("UTF-8");
	 
	 Dao dao = new Dao();
	 String uname = request.getParameter("username");
	 String password = request.getParameter("password");
	 
	 String salt = dao.getUserSalt(uname);
	 String hashpw = dao.getUserPasswordHash(uname);
	 dao.close();
	 
	 if ( SecurityUtils.isPasswordOk(hashpw, password, salt) ) {
		 HttpSession session = request.getSession();
		 session.setAttribute("LoggedUser", uname);
	 } else {
		 response.getWriter().println("login failed");
		 RequestDispatcher rd = request.getRequestDispatcher("login.html");
		 rd.forward(request, response);
	 }
	 RequestDispatcher rd = request.getRequestDispatcher("/showdata");
	 rd.forward(request, response);
}
	 }
