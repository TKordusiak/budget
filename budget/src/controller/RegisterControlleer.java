package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;


@WebServlet("/register")
public class RegisterControlleer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("inputName");
		String password = request.getParameter("inputPassword");
		String email = request.getParameter("inputEmail");
		LoginService loginService = new LoginService();
		loginService.addLogin(name, password, email);
		response.sendRedirect(request.getContextPath()+"/");
		
	}

}
