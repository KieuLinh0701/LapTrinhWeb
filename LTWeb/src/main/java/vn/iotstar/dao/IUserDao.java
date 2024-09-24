package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.models.UserModel;

public interface IUserDao {
	
	//Lấy ra danh sách tất cả user
	List<UserModel> findAll();
	
	//Lấy ra 1 user
	UserModel findById(int id);
	
	//Tìm user theo username
	UserModel findByUsername(String username);
	
	//Thêm user
	void insert(UserModel user);
	
	void updatePassword(String password, String username);
	
	void insertRegister(UserModel user);
	
	//Thêm user --> đăng kí tài khoản
	boolean register(UserModel user);
	
	//Kiểm tra username đã tồn tại chưa
	boolean checkExistUsername(String username);
	
	//kiểm tra đăng nhập
	boolean checkAccount(String username, String password);
	
	//Kiểm tra email đã tồn tại chưa
	boolean checkExistEmail(String email);
	
	//Kiểm tra username đã tồn tại chưa
	boolean checkExistId(int id);
	
	boolean checkExistPhone(String phone);
	
	//login
	UserModel login(String username, String password);
	
	void updateAccount(String phone, String fullname, String username, String images);
}
