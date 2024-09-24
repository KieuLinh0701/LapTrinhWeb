package vn.iotstar.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnection;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImplement extends DBConnection implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "select * from users";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("password"), rs.getString("fullname"), rs.getString("images"),
						rs.getString("phone"), rs.getInt("roleid"), rs.getDate("createDate")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "select * from users where id = ?";

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			UserModel user = null;
			if (rs.next()) {
				user = new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("password"), rs.getString("fullname"), rs.getString("images"),
						rs.getString("phone"), rs.getInt("roleid"), rs.getDate("createDate"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "insert into users (id, username, email, password, images,fullname, phone, roleid, createDate) values (?,?,?,?,?,?,?,?,?)";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getImages());
			ps.setString(6, user.getFullname());
			ps.setString(7, user.getPhone());
			ps.setInt(8, user.getRoleid());
			ps.setDate(9, user.getCreatDate());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean register(UserModel user) {
		UserDaoImplement userDao = new UserDaoImplement();
		if (userDao.checkExistId(user.getId()) == true) {
			System.out.println("Id already exists");
			return false;
		}
		if (userDao.checkExistUsername(user.getUsername()) == true) {
			System.out.println("Username already exists");
			return false;
		}
		if (userDao.checkExistEmail(user.getEmail()) == true) {
			System.out.println("Email already exists");
			return false;
		}
		userDao.insert(user);
		return true;
	}

	@Override
	public UserModel findByUsername(String username) {
		String sql = "select * from users where username=?";

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			rs = ps.executeQuery();

			UserModel user = null;
			if (rs.next()) {
				user = new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
						rs.getString("password"), rs.getString("fullname"), rs.getString("images"),
						rs.getString("phone"), rs.getInt("roleid"), rs.getDate("createDate"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		if (password.equals(user.getPassword()) && user != null) {
			return user;
		}
		return null;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean check = false;
		String sql = "select * from users where username=?";

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, username);

			rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean check = false;
		String sql = "select * from users where email=?";

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, email);

			rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean checkExistId(int id) {
		boolean check = false;
		String sql = "select * from users where id=?";

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean checkAccount(String username, String password) {
		boolean check = false;
		String sql = "select * from users where username=? and password=?";

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public static void main(String[] args) {
		try {
			IUserDao userDao = new UserDaoImplement();
			System.out.println(userDao.findAll());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistPhone(String phone) {
		boolean check = false;
		String sql = "select * from users where phone=?";

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, phone);

			rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public void insertRegister(UserModel user) {
		String sql = "insert into users (username, email, password, fullname, phone, roleid, createDate) values (?,?,?,?,?,?,?)";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getPhone());
			ps.setInt(6, user.getRoleid());
			ps.setDate(7, user.getCreatDate());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePassword(String password, String username) {
		String sql = "update users set password=? where username=?";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, username);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateAccount(String phone, String fullname, String username, String images) {
		String sql = "UPDATE users\n"
				+ "SET phone = ?, fullname = ?, images = ?\n"
				+ "WHERE username = ?;";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setString(2, fullname);
			ps.setString(3, images);
			ps.setString(4, username);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
