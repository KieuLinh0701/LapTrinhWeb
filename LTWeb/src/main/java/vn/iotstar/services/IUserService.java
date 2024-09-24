package vn.iotstar.services;

import vn.iotstar.models.UserModel;

public interface IUserService {
	UserModel login(String usernam, String password);
	
	UserModel findByUsername(String username);
	
	void insertRegister(UserModel user);
	
	boolean register(String username, String email, String password, String fullname, String phone);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);
	
	UserModel updatePassword(String username, String password);
	
	UserModel updateAccount(String phone, String fullname, String username, String images);
}
