package com.shop;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = (String) req.getAttribute("username");
		String password = (String) req.getAttribute("password");
		
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(60);
		session.setAttribute("username", username);
		
		
		resp.sendRedirect("products.html");
		
	}

}
