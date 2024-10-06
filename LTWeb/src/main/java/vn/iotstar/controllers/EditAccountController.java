package vn.iotstar.controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.implement.UserService;
import vn.iotstar.utils.Constant;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet(urlPatterns = { "/editaccount" })
public class EditAccountController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final String SAVE_DIRECTORY = "uploads";
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

		// Thư mục đích để lưu file
		String uploadDirectory = Constant.UPLOAD_DIRECTORY;

		// Lấy file từ request
		Part filePart = req.getPart("file"); // Thay "file" bằng tên input trong form
		String fileName = getFileName(filePart);

		// Tạo đường dẫn đầy đủ đến file đích
		String filePath = fileName;

		// Lưu file vào thư mục
		try (InputStream input = filePart.getInputStream()) {
			Files.copy(input, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// Xử lý lỗi
			e.printStackTrace();
			// Gửi thông báo lỗi cho người dùng
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi tải file");
		}

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
		UserModel user = service.updateAccount(phone, fullname, username, filePath);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			req.getRequestDispatcher("/views/myAccount.jsp").forward(req, resp);
		} else {
			// alertMsg = "Cập nhật không thành công";
			alertMsg = username;
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/editAccount.jsp").forward(req, resp);
		}
	}

	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
