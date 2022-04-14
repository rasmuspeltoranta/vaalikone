package app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.Dao;
import app.security.SecurityUtils;

@WebServlet(
		name = "AddUserServlet",
		urlPatterns = {"/add"}
		)
// made by Rasmus

public class AddUserServlet extends HttpServlet {
	@Override
		   public void doGet(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException, ServletException {
		     response.setContentType("text/html");
		     response.setCharacterEncoding("UTF_8");
			 response.sendRedirect("login.html");
}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		Dao dao = new Dao();
		
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		
		String salt = SecurityUtils.getSalt();
		String hashpw = SecurityUtils.getPasswordHashed(password, salt);
		
		dao.addUser(uname, hashpw, salt);
		
		dao.close();
		response.sendRedirect("login.html");
}}
