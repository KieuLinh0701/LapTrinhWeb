package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/helloformpost"})
public class HelloFormPost {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Set response content type
	 response.setContentType("text/html");
	 response.setCharacterEncoding("UTF-8");
	 request.setCharacterEncoding("UTF-8");
	 //Nhận dữ liệu từ request URL
	 String ten = request.getParameter("ten");
	 String holot = request.getParameter("holot");
	//Hiển thị dữ liệu ra web bằng đối tượng PrintWriter
	 PrintWriter out = response.getWriter();
	out.println("<b>First Name</b>: " + ten + "<br/><b>Last Name</b>: "+ holot);
	}
}
