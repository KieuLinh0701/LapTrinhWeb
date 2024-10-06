package vn.iotstar.services;

import java.util.List;

import vn.iotstar.models.CategoryModel;

public interface ICategoryService {
	void insert(CategoryModel cate);
	void update(CategoryModel cate);
	void delete(int id);
	CategoryModel findById(int id);
	List<CategoryModel> findAll();
	List<CategoryModel> findName(String keyword);
}
