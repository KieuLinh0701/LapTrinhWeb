package vn.iotstar.services.implement;

import java.sql.Date;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.implement.UserDaoImplement;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {
	// Lấy toàn bộ hàm trong tầng dao của user
	IUserDao userDao = new UserDaoImplement();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void insertRegister(UserModel user) {
		userDao.insertRegister(user);

	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);

	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public boolean register(String username, String email, String password, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insertRegister(new UserModel(username, email, password, fullname, phone, 1, date));
		return true;
	}

	@Override
	public UserModel updatePassword(String username, String password) {
		UserModel user = this.findByUsername(username);
		if (user != null) {
			userDao.updatePassword(password, username);
			return user;
		}
		return null;
	}

}
