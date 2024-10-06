package vn.iotstar.services.implement;

import java.io.File;
import java.util.List;

import vn.iotstar.dao.implement.CategoryDaoImplement;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.ICategoryService;

public class CategoryService implements ICategoryService{
	CategoryDaoImplement categoryDao = new CategoryDaoImplement();
	@Override
	public void insert(CategoryModel category) {
		categoryDao.insert(category);
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = new CategoryModel();
		cate = categoryDao.findById(category.getCategoryId());
		if (cate!=null) {
			categoryDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		CategoryModel cate = new CategoryModel();
		cate = categoryDao.findById(id);
		if (cate!=null) {
			categoryDao.delete(id);
		}
	}

	@Override
	public CategoryModel findById(int id) {
		return categoryDao.findById(id);
	}

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		return categoryDao.findName(keyword);
	}

}
