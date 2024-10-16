package vn.iotstar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/CheckBoxAction"})
public class CheckBoxAction extends HttpServlet{
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
			 throws ServletException, IOException {
			 // Set response content type
			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			String title = "Doc du lieu tu CheckBox trong Servlet";
			 String docType =
			 "<!doctype html public \"-//w3c//dtd html 4.0 " +
			 "transitional//en\">\n";
			 out.println(docType +
					 "<html>\n" +
					 "<head><title>" + title + "</title></head>\n" +
					 "<body bgcolor = \"#f0f0f0\">\n" +
					"<h1 align = \"center\">" + title + "</h1>\n" +
					 "<ul>\n" +
					 " <li><b>Toan : </b>: "
					+ request.getParameter("toan") + "\n" +
					 " <li><b>Vat Ly: </b>: "
					+ request.getParameter("ly") + "\n" +
					 " <li><b>Hoa Hoc: </b>: "
					 + request.getParameter("hoa") + "\n" +
					 "</ul>\n" +
					 "</body>" +
					 "</html>"
					 );
		}
}
