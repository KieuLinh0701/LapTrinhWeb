package vn.iotstar.dao.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnection;
import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.models.CategoryModel;

public class CategoryDaoImplement extends DBConnection implements ICategoryDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public void insert(CategoryModel cate) {
		String sql = "INSERT INTO categories (categoryName, images, status) VALUES (?,?,?)";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cate.getCategoryName());
			ps.setString(2, cate.getImages());
			ps.setInt(3, cate.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel cate) {
		String sql = "UPDATE categories SET categoryName=?, images=?, status=? WHERE categoryId=?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cate.getCategoryName());
			ps.setString(2, cate.getImages());
			ps.setInt(3, cate.getStatus());
			ps.setInt(4, cate.getCategoryId());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM categories WHERE categoryId=?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CategoryModel findById(int id) {
		String sql = "SELECT * FROM categories WHERE categoryId=?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				return category;
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM categories";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				categories.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "SELECT * FROM categories WHERE categoryName like ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryId(rs.getInt("categoryId"));
				category.setCategoryName(rs.getString("categoryName"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				categories.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
