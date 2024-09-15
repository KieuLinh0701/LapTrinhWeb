package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.utils.Constant;

@WebServlet(urlPatterns = { "/home", "/logout"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("logout")) {
			getLogOut(req, resp);

		} else {
			req.getRequestDispatcher("/views/home.jsp").forward(req,resp);
		}
	}
	
	protected void getLogOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		session.removeAttribute("account");
		
		Cookie[] cookies = req.getCookies();
		
		if (cookies!=null) {
			for (Cookie cookie:cookies) {
				if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
					cookie.setMaxAge(0); //remove cookie
					resp.addCookie(cookie); //add again
					break;
				}
			}
		}
		resp.sendRedirect("./login");
	}

}
