package com.lookman.app.category.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.category.dao.CategoryDao;
import com.lookman.app.category.vo.CategoryVo;
import static com.lookman.app.db.SQLSessionTemplate.*;

public class CategoryService {
	private final CategoryDao cdao;

	public CategoryService() {
		this.cdao = new CategoryDao();
	}

	public List<CategoryVo> selectCategory() throws Exception {
		SqlSession ss = getSqlSession();
		
		List<CategoryVo> cvoList = cdao.selectCategory(ss);
		
		ss.close();
		return cvoList;
	}

}
