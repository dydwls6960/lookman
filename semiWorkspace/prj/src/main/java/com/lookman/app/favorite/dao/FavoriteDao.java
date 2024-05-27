package com.lookman.app.favorite.dao;

import org.apache.ibatis.session.SqlSession;

import com.lookman.app.favorite.vo.FavoriteVo;

public class FavoriteDao {

	public int isFavorite(SqlSession ss, FavoriteVo fvo) {
		return ss.selectOne("FavoriteMapper.isFavorite", fvo);
	}

	public int removeFavorite(SqlSession ss, FavoriteVo fvo) {
		return ss.delete("FavoriteMapper.removeFavorite", fvo);
	}

	public int addFavorite(SqlSession ss, FavoriteVo fvo) {
		return ss.insert("FavoriteMapper.addFavorite", fvo);
	}

}
