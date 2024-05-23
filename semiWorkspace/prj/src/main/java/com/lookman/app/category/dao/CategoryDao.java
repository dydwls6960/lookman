package com.lookman.app.category.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.category.vo.CategoryVo;

public class CategoryDao {

	public List<CategoryVo> selectCategory(SqlSession ss) {
		return ss.selectList("CategoryMapper.selectCategory");
	}

}
