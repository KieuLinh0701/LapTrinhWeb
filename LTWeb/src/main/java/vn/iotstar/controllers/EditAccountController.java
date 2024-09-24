package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.implement.UserService;

@WebServlet(urlPatterns = {"/editaccount"})
public class EditAccountController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	IUserService service = new UserService();
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/editAccount.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Mã hóa bằng tiếng việt
				resp.setContentType("text/html");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");

				// Lấy tham số từ view
				String fullname = req.getParameter("fullname");
				String phone = req.getParameter("phone");
				String username = req.getParameter("username");

				// biến kiểm tra đăng nhập thành công hay thất bại
				String alertMsg = "";

				if (fullname.isEmpty() || phone.isEmpty()) {
					alertMsg = "Tên hoặc mật khẩu không được rỗng";
					req.setAttribute("alert", alertMsg);
					req.getRequestDispatcher("/views/editAccount.jsp").forward(req, resp);
					return;
				}

				// Xử lý bài toán
				UserModel user = service.updateAccount(phone, fullname, username);
				if (user != null) {
					HttpSession session = req.getSession(true);
					session.setAttribute("account", user);
					resp.sendRedirect(req.getContextPath() + "/myaccount");
				} else {
					//alertMsg = "Cập nhật không thành công";
					alertMsg = username;
					req.setAttribute("alert", alertMsg);
					req.getRequestDispatcher("/views/editAccount.jsp").forward(req, resp);
				}
	}
}
