package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/HelloServlet"})
public class HelloServlet extends HttpServlet{
	private String message;
	 @SuppressWarnings("serial")
	 public void init() throws ServletException {
	 // Do required initialization
	 message = "Hello World";
	 }
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
	 // Set response content type
	 response.setContentType("text/html");
	 // Actual logic goes here.
	 PrintWriter out = response.getWriter();
	 out.println("<h1>" + message + "</h1>");
	 }
	 public void destroy() {
	 // do nothing.
	 }
}
